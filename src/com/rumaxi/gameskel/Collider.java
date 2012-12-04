package com.rumaxi.gameskel;

import android.util.Log;

public abstract class Collider {
    private ActorType type;
    
    public boolean check (Actor actor) {
        return (actor.getType() == type);
    } 

    public void setType(ActorType type) {
        this.type = type;
    }
            
    abstract void collide (Actor object, Actor subject);        
    
            
            
}
