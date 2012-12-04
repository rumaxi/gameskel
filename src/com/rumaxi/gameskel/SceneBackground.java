
package com.rumaxi.gameskel;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;


public class SceneBackground implements IDrawer {
    private Rect dst;
    private ISprite sprite;
    private Bitmap bitmap;
    public void draw(Canvas canvas) {
        bitmap = sprite.getSprite();
        canvas.drawBitmap(bitmap, null, dst, null);
    }
    
    SceneBackground(ISprite sprite) {
        dst = new Rect(0,0,Settings.screenWidth,Settings.screenHeight);
        this.sprite = sprite;
    }
    
}
