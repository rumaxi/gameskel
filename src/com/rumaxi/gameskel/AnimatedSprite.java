package com.rumaxi.gameskel;

import android.graphics.Bitmap;
import android.util.Log;

public class AnimatedSprite implements ISprite {
    private int frames;
    private Bitmap bitmap;
    private int frameWidth, frameHeight;
    private int currentFrame;
    Bitmap frame;
    
    AnimatedSprite (Bitmap bitmap, int frames) {
        this.frames = frames;
        this.bitmap = bitmap;
        frameWidth  = bitmap.getWidth() / frames;
        frameHeight = bitmap.getHeight();
        currentFrame = 0;
    }
    
    AnimatedSprite (Bitmap bitmap, int frames, int frameWidth) {
        this.bitmap = bitmap;
        this.frames = frames;
        this.frameWidth = frameWidth;
        currentFrame = 0;
        frameHeight  = bitmap.getHeight();
    }

    public Bitmap getSprite() {
        if (currentFrame >= frames ) { currentFrame = 0; }
        frame = Bitmap.createBitmap(bitmap,currentFrame*frameWidth,0,frameWidth,frameHeight);
        currentFrame++;
        return frame;
    }
    
}
