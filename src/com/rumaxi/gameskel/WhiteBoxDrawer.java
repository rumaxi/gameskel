package com.rumaxi.gameskel;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

public class WhiteBoxDrawer implements IActorDrawer {
    Paint p;
    public void draw(Canvas canvas, Actor actor) {
        Dimensions dim = actor.getActorDimensions();
        Position pos = actor.getPosition();
        Log.i("RUMA", "WhiteBoxDrawer.draw()");
        Log.i("RUMA", actor.toString());
        canvas.drawRect(pos.x, pos.y, pos.x+dim.width, pos.y+dim.height, p);
    }
    
    WhiteBoxDrawer() {
        p = new Paint();
        p.setColor(Color.WHITE);       
        p.setStyle(Paint.Style.FILL);
    }
    
}
