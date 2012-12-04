package com.rumaxi.gameskel;

import android.graphics.Canvas;
import java.util.Stack;

public class Actor {
    private boolean movable;
    private boolean drawable;
    private boolean collidable;
    private boolean mutable;
    
    private IMover mover              = null;
    private IActorDrawer drawer       = null;
    private Stack<ICollider> colliders = null;
    private Stack<IMutator>  mutators  = null;
    
    private Position   position;
    private Dimensions actorDimensions;
    private Dimensions hitboxDimensions;
    
    public void move() {
        mover.move(this);
    }
    
    public void collide(Collision collision) {
        for (ICollider collider: colliders) {
            collider.collide(collision);
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

    public void addCollider(ICollider collider) {
        colliders.add(collider);
    }
    
/*    public void addMutator (IMutator mutator) {
        this.Mutable = true;
        mutators.add(mutator);
    } */

    
    public Dimensions getActorDimensions() {
        return actorDimensions;
    }

    public Dimensions getHitboxDimensions() {
        return hitboxDimensions;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    
    public void setActorDimensions(Dimensions actorDimensions) {
        this.actorDimensions = actorDimensions;
    }    

    public boolean isMovable() {
        return movable;
    }

    public boolean isDrawable() {
        return drawable;
    }

    public boolean isCollidable() {
        return collidable;
    }

    public boolean isMutable() {
        return mutable;
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
        sb.append("x:").append(position.x).append(" y:").append(position.y).append("\n");
        sb.append("w:").append(actorDimensions.width).append(" h:").append(actorDimensions.height).append("\n");
        return sb.toString();
    }
    
    
}
    
