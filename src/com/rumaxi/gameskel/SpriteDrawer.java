package com.rumaxi.gameskel;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class SpriteDrawer implements IActorDrawer {
    private Rect dst;
    private Position pos;
    private Dimensions dim;
    private ISprite sprite;
    private Bitmap bitmap;
    private int updateRate = -1;
    private int update;
    private int w,h; // for static wh for object.  TODO //

    SpriteDrawer(ISprite sprite) {
        this.sprite = sprite;
        bitmap = sprite.getSprite();
        updateRate=update=0;
    }
    
    SpriteDrawer(ISprite sprite, int updateRate) {
        this.sprite = sprite;
        bitmap = sprite.getSprite();
        this.updateRate = updateRate;
        update = updateRate;
    }
    
    public void draw(Canvas canvas, Actor actor) {
        int x,y; 
        if (updateRate != -1) { 
            if (update == 0) {bitmap = sprite.getSprite(); update = updateRate; }
            update--; 
        }
        if (dim == null) { dim = actor.actorDimensions; w=dim.width; h=dim.height; }
        pos = actor.position;
        x = pos.x;
        y = pos.y;
        dst = new Rect(x,y,x+w,y+h);
        canvas.drawBitmap(bitmap, null, dst, null);
    }
}
