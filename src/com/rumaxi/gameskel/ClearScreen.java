package com.rumaxi.gameskel;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


public class ClearScreen implements IDrawer {
    private Paint p;
    
    public void draw(Canvas canvas) {
        canvas.drawPaint(p);
    }
    
    ClearScreen () {
        p = new Paint();
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.BLACK);        
    }
    
    
}
