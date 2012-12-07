package com.rumaxi.gameskel;

import android.graphics.Canvas;
import android.os.Debug;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Stack;

public class Scene {
private ArrayList<Actor>      actorList       = new ArrayList<Actor>();
private ArrayList<Actor>      movableList     = new ArrayList<Actor>();
private ArrayList<Actor>      collidableList  = new ArrayList<Actor>();
private ArrayList<Actor>      drawableList    = new ArrayList<Actor>();
private ArrayList<Actor>      delList         = new ArrayList<Actor>();
private ArrayList<Actor>      addList         = new ArrayList<Actor>();
private ArrayList<IDrawer>    postrenderList  = new ArrayList<IDrawer>();
private ArrayList<IDrawer>    prerenderList   = new ArrayList<IDrawer>();   
private Position    objPosition,   subjPosition;
private Dimensions  objDimensions, subjDimensions;


 
  
    
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

    for (int i=0, n = movableList.size(); i<n; ++i) {
        movableList.get(i).move();
    }
    for (int i=0, n = prerenderList.size(); i<n; ++i) {
        prerenderList.get(i).draw(canvas);
    }
    for (int i=0, n = drawableList.size(); i<n; ++i) {
        drawableList.get(i).draw(canvas);
    }  
    for (int i=0, n = postrenderList.size(); i<n; ++i) {
        postrenderList.get(i).draw(canvas);
    }   
    collideObjects();  
    updateObjects();  
}  
    
private void updateObjects() {

        for (int i=0, n = delList.size(); i<n; ++i) {
            actorList.remove(delList.get(i));
            if (delList.get(i).movable) { movableList.remove(delList.get(i)); }
            if (delList.get(i).collidable) { collidableList.remove(delList.get(i)); }
            if (delList.get(i).drawable) { drawableList.remove(delList.get(i)); }             
        } 
        
        for (int i=0, n = addList.size(); i<n; ++i) {
            actorList.add(addList.get(i));
            if (addList.get(i).movable) { movableList.add(addList.get(i)); }
            if (addList.get(i).collidable) { collidableList.add(addList.get(i)); }
            if (addList.get(i).drawable) { drawableList.add(addList.get(i)); }             
        } 
        delList.clear(); 
        addList.clear(); 
    }
    
private void collideObjects() {
        for (int i=0, n = collidableList.size(); i<n; ++i) {
            objPosition   = collidableList.get(i).position;
            objDimensions = collidableList.get(i).actorDimensions;
            int tw = objDimensions.width;
            int th = objDimensions.height;  
            int tx = objPosition.x;
            int ty = objPosition.y;   
            tw += tx;
            th += ty; 
            for (int j=0, k = collidableList.size(); j<k; ++j) {                
                if (collidableList.get(i) != collidableList.get(j)) {
                    subjPosition = collidableList.get(j).position;
                    subjDimensions = collidableList.get(j).actorDimensions;
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
                    if (collide) { collidableList.get(i).collide(collidableList.get(j)); } 
                }
            }
        }
        
        
        
    };
 
int objectCount() {
        return actorList.size();
}

            
}
