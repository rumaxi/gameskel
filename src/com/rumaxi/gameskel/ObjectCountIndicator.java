package com.rumaxi.gameskel;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class ObjectCountIndicator implements IDrawer {
    private Scene scene;
    private Paint p;
    
    public void draw(Canvas canvas) {
        canvas.drawText(String.valueOf(scene.objectCount()), 10, 25, p);
    }
    
    ObjectCountIndicator(Scene scene) {
        this.scene = scene;
        p = new Paint();
        p.setColor(Color.GREEN);       
        p.setTypeface(Typeface.MONOSPACE);
        p.setAntiAlias(true);
        p.setSubpixelText(true);
        p.setFilterBitmap(true); 
        p.setTextSize(18);

    }
    
}
