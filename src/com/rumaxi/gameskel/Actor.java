package com.rumaxi.gameskel;

import android.graphics.Canvas;
import java.util.Stack;

public class Actor {
    boolean movable;
    boolean drawable;
    boolean collidable;
    boolean mutable;
    
    IMover mover               = null;
    IActorDrawer drawer        = null;
    Stack<Collider> colliders  = new Stack<Collider>();
    Stack<Mutator>  mutators   = new Stack<Mutator>();
    
    ActorType  type;
    Position   position;
    Dimensions actorDimensions;
    Dimensions hitboxDimensions;
    
    public void move() {
        mover.move(this);
    }
    
    public void collide(Actor subject) {
        for (Collider collider: colliders) {
            if (collider.check(subject)) { collider.collide(this,subject);} 
        }
    }
    
    public void draw(Canvas canvas) {
        drawer.draw(canvas, this);
    }

    public void setDrawer(IActorDrawer drawer) {
        drawable =    true;
        this.drawer = drawer;
    }
        
    public void setMover(IMover mover) {
        movable  =    true;
        this.mover = mover;
    }

    public void addCollider(Collider collider) {
        collidable = true;
        colliders.add(collider);
    }

    public void setActorDimensions(Dimensions actorDimensions) {
        this.actorDimensions = actorDimensions;
    }    
    
    Actor () {
        this.position = new Position (0,0);
        this.actorDimensions = new Dimensions(35,35);
    }
    
    Actor (Position pos, Dimensions dim) {
        this.position = pos;
        this.actorDimensions = dim;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
      //  sb.append("x:").append(position.getX()).append(" y:").append(position.getY()).append("\n");
      //  sb.append("w:").append(actorDimensions.getWidth()).append(" h:").append(actorDimensions.getHeight()).append("\n");
        //return sb.toString();
        return type.toString();
    }
    
    
}
    
