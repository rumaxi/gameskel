package com.rumaxi.gameskel;

import android.graphics.Bitmap;

public class StaticSprite implements ISprite {
    Bitmap bitmap;
    public Bitmap getSprite() {
        return bitmap;
    }
    
    StaticSprite (Bitmap bitmap) {
        this.bitmap = bitmap;
    }
    
}
