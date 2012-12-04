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
    private ArrayList<Collision> collisions = new ArrayList<Collision>();
    private Position objPosition;
    private Position subjPosition;
    private Dimensions objDimensions;
    private Dimensions subjDimensions;
    
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
        collisions = new ArrayList<Collision>();
        
        for (Actor object: collidableList) {
            for (Actor subject: collidableList) {
                if (!object.equals(subject)) {
                    objPosition = object.getPosition();
                    subjPosition = subject.getPosition();
                    objDimensions = object.getActorDimensions(); // !!!
                    subjDimensions = subject.getActorDimensions();
                    //int tw = objDimensions.
                    
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
