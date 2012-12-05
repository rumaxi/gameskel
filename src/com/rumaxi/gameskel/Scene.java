package com.rumaxi.gameskel;

import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Stack;

public class Scene {
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

 
  
    
void addPrerender (IDrawer drawer) {
        prerenderList.add(drawer);
    }

void addPostrender (IDrawer drawer) {
        postrenderList.add(drawer);
    }
    
public void delActor(Actor actor) {
        delList.add(actor);
    }
    
public void addActor(Actor actor) {
        addList.add(actor);
    }
   
void tick (Canvas canvas) {
        for (Actor actor : movableList) { actor.move(); }
        for (IDrawer drawer : prerenderList) { drawer.draw(canvas); }
        for (Actor actor : drawableList) { actor.draw(canvas); }
        for (IDrawer drawer : postrenderList) { drawer.draw(canvas); }
        collideObjects();
        updateObjects();
    }  
    
private void updateObjects() {
        for (Actor actor: delList) {
            actorList.remove(actor);
            if (actor.movable) { movableList.remove(actor); }
            if (actor.collidable) { collidableList.remove(actor); }
            if (actor.drawable) { drawableList.remove(actor); }             
        }
        
        for (Actor actor: addList) {
            actorList.add(actor);
            if (actor.movable) { movableList.add(actor);  }
            if (actor.collidable) { collidableList.add(actor); }
            if (actor.drawable) { drawableList.add(actor); }            
        }
        delList.clear();
        addList.clear();
    }
    
private void collideObjects() {
        for (Actor object: collidableList) {
            objPosition = object.position;
            objDimensions = object.actorDimensions;
            int tw = objDimensions.width;
            int th = objDimensions.height;  
            int tx = objPosition.x;
            int ty = objPosition.y;   
            tw += tx;
            th += ty; 
            for (Actor subject: collidableList) {
                if (object != subject) {
                    subjPosition = subject.position;
                    subjDimensions = subject.actorDimensions;
                    int rw = subjDimensions.width;
                    int rh = subjDimensions.height;
                    int rx = subjPosition.x;
                    int ry = subjPosition.y;
                    rw += rx;
                    rh += ry;
                    boolean collide = ((rw < rx || rw > tx) &&
                               (rh < ry || rh > ty) &&
                               (tw < tx || tw > rx) &&
                               (th < ty || th > ry));
                    if (collide) { object.collide(subject); } 
                }
            }
        }
        
        
        
    };
 
int objectCount() {
        return actorList.size();
}

            
}
