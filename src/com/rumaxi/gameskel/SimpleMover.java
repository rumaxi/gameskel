package com.rumaxi.gameskel;

import android.util.Log;

/*test mover*/
public class SimpleMover implements IMover {
    int dx = Speed.SLOW;
    int dy = Speed.SLOW;
    private Position    pos = null;
    private Dimensions  dim = null;
    public void move(Actor actor) {
        if (pos == null) { pos = actor.getPosition(); }
        if (dim == null) { dim = actor.getActorDimensions(); }
        int newX = pos.getX()+dx;
        int newY = pos.getY()+dy;
        if (newX+dim.getWidth()  >= Settings.screenWidth || newX < 0) { dx = -dx; }
        if (newY+dim.getHeight() >= Settings.screenHeight || newY < 0) { dy = -dy; }
        pos.setX(newX);
        pos.setY(newY);
    }
    
}
