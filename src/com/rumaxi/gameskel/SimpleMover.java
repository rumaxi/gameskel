package com.rumaxi.gameskel;

import android.util.Log;

/*test mover*/
public class SimpleMover implements IMover {
    int dx = Speed.SLOW;
    int dy = Speed.SLOW;
    private Position    pos = null;
    private Dimensions  dim = null;
    public void move(Actor actor) {
        if (pos == null) { pos = actor.position; }
        if (dim == null) { dim = actor.actorDimensions; }
        int newX = pos.x+dx;
        int newY = pos.y+dy;
        if (newX+dim.width  >= Settings.screenWidth || newX < 0) { dx = -dx; }
        if (newY+dim.height >= Settings.screenHeight || newY < 0) { dy = -dy; }
        pos.x = newX;
        pos.y = newY;
    }
    
}
