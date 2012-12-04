package com.rumaxi.gameskel;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class PointDrawer implements IActorDrawer {
    Paint p;
    public void draw(Canvas canvas, Actor actor) {
        Position pos = actor.getPosition();
        canvas.drawPoint(pos.x, pos.y, p);
    }
    
    PointDrawer() {
        p = new Paint();
        p.setColor(Color.WHITE);       
        p.setStyle(Paint.Style.FILL);        
    }
    
}
