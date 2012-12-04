package com.rumaxi.gameskel;

import android.util.Log;

public class TestCollider extends Collider {

    @Override
    void collide(Actor object, Actor subject) {
       // Log.i("RUMA", object.toString()+" collides with "+subject.toString());
        Log.i("RUMA", "Collision !");
    }
    
    
    
}
