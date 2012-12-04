package com.rumaxi.gameskel;

import android.graphics.Canvas;
import android.util.Log;
import java.util.ArrayList;
import java.util.Stack;

public class Scene {
    Canvas canvas;
    
    private ArrayList<Actor> actorList       = new ArrayList();
    private ArrayList<Actor> movableList     = new ArrayList();
    private ArrayList<Actor> collidableList  = new ArrayList();
    private ArrayList<Actor> drawableList    = new ArrayList();
    private Stack<IDrawer>    postrenderList  = new Stack();
    private Stack<IDrawer>    prerenderList   = new Stack();
    private ArrayList<Actor>  delList = new ArrayList<Actor>();
    private ArrayList<Actor>  addList = new ArrayList<Actor>();
    private Position objPosition;
    private Position subjPosition;
    private Dimensions objDimensions;
    private Dimensions subjDimensions;
    private int tw,th,rw,rh,tx,ty,rx,ry;
    private boolean collide;
    
    void render() {
        for (Actor actor : movableList) { actor.move(); }
        for (IDrawer drawer : prerenderList) { drawer.draw(canvas); }
        for (Actor actor : drawableList) { actor.draw(canvas); }
        for (IDrawer drawer : postrenderList) { drawer.draw(canvas); }
        collideObjects();
        updateObjects();
    }
    
    
    public void delActor(Actor actor) {
        delList.add(actor);
    }
    
    public void addActor(Actor actor) {
        addList.add(actor);
    }
    
    private void updateObjects() {
        for (Actor actor: delList) {
            actorList.remove(actor);
            if (actor.isMovable()) { movableList.remove(actor); }
            if (actor.isCollidable()) { collidableList.remove(actor); }
            if (actor.isDrawable()) { drawableList.remove(actor); }             
        }
        
        for (Actor actor: addList) {
            actorList.add(actor);
            if (actor.isMovable()) { movableList.add(actor);  }
            if (actor.isCollidable()) { collidableList.add(actor); }
            if (actor.isDrawable()) { drawableList.add(actor); }            
        }
        delList.clear();
        addList.clear();
    }
    
    private void collideObjects() {
        for (Actor object: collidableList) {
            objPosition = object.getPosition();
            objDimensions = object.getActorDimensions();
            tw = objDimensions.getWidth();
            th = objDimensions.getHeight();  
            tx = objPosition.getX();
            ty = objPosition.getY();   
            tw += tx;
            th += ty; 
            for (Actor subject: collidableList) {
                if (object != subject) {
                    subjPosition = subject.getPosition();
                    subjDimensions = subject.getActorDimensions();
                    rw = subjDimensions.getWidth();
                    rh = subjDimensions.getHeight();
                    rx = subjPosition.getX();
                    ry = subjPosition.getY();
                    rw += rx;
                    rh += ry;
                    collide = ((rw < rx || rw > tx) &&
                               (rh < ry || rh > ty) &&
                               (tw < tx || tw > rx) &&
                               (th < ty || th > ry));
                    if (collide) { object.collide(subject); } 
                    Log.i("RUMA", String.valueOf(collide));
                }
            }
        }
        
        
        
    };
    
            
    
    void addPrerender (IDrawer drawer) {
        prerenderList.add(drawer);
    }

    void addPostrender (IDrawer drawer) {
        postrenderList.add(drawer);
    }
    
    void tick (Canvas canvas) {
        this.canvas = canvas;
        render();
    }

    int objectCount() {
        return actorList.size();
    }
            
}
