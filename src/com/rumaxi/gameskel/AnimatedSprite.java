package com.rumaxi.gameskel;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

public class AnimatedSprite implements ISprite {
    private int frames;
    private Bitmap bitmap;
    private int frameWidth, frameHeight;
    private int currentFrame;
    private Bitmap frame;
    private Canvas frameCanvas;
    private Rect src, dst;
    
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
        frame = Bitmap.createBitmap(frameWidth, frameHeight, Bitmap.Config.ARGB_8888);
        frameCanvas = new Canvas(frame);
        src = new Rect (0,0,frameHeight,frameWidth);
        dst = new Rect (src);
    }

    public Bitmap getSprite() {
        if (currentFrame >= frames ) { currentFrame = 0; }
        //frame = Bitmap.createBitmap(bitmap,currentFrame*frameWidth,0,frameWidth,frameHeight);
        src.left = currentFrame*frameWidth;
        src.right = (currentFrame+1)*frameWidth;
        frameCanvas.drawBitmap(bitmap, src, dst, null);
        currentFrame++;
        return frame;
    }
    
}
