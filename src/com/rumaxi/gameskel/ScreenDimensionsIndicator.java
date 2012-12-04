package com.rumaxi.gameskel;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class ScreenDimensionsIndicator implements IDrawer {
    Paint p;
    
    public void draw(Canvas canvas) {
        canvas.drawText("h: "+Settings.screenHeight, 10, 20, p);
        canvas.drawText("w: "+Settings.screenWidth, 10, 35, p);
    }

    public ScreenDimensionsIndicator() {
        p = new Paint();
        p.setColor(Color.BLACK);       
        p.setTypeface(Typeface.MONOSPACE);
        p.setAntiAlias(true);
        p.setSubpixelText(true);
        p.setFilterBitmap(true); 
    }
    
    
    
}
