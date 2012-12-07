package com.rumaxi.gameskel;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class FPSIndicator implements IDrawer {
    private Game game;
    private Paint p;
    
    public void draw(Canvas canvas) {
        canvas.drawText(String.valueOf(game.getFps()), 10, 50, p);
    }
    
    FPSIndicator(Game game) {
        this.game = game;
        p = new Paint();
        p.setColor(Color.GREEN);       
        p.setTypeface(Typeface.MONOSPACE);
        p.setAntiAlias(true);
        p.setSubpixelText(true);
        p.setFilterBitmap(true); 
        p.setTextSize(18);
    }
    
}
