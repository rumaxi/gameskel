package com.rumaxi.gameskel;

import android.util.Log;

public class FreefallMover implements IMover {
    int fallTime;
    double g= 0.01;
    double dy;
    int dx = Speed.SLOW;
    public void move(Actor actor) {
            Log.i("RUMA", "FreefallMover.move()");
            Log.i("RUMA", actor.toString());
            Position pos = actor.getPosition();
            dy = g*fallTime;
            int newX = pos.x+dx;
            int newY = (int) ((int) pos.y+dy);
            pos.setY(newY);
            pos.setX(newX);
            fallTime++;
            if (newY+25 >= Settings.screenHeight || newY < 0) { g=-g; }
            if (newX+25  >= Settings.screenWidth || newX < 0) { dx = -dx; }
    }

    public FreefallMover() {
        fallTime = 0;
    }
    
}
