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
    private int x,y,w,h;

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
        if (updateRate != -1) { 
            if (update == 0) {bitmap = sprite.getSprite(); update = updateRate; }
            update--; 
        }
        if (dim == null) { dim = actor.getActorDimensions(); w=dim.getWidth(); h=dim.getHeight(); }
        pos = actor.getPosition();
        x = pos.getX();
        y = pos.getY();
        dst = new Rect(x,y,x+w,y+h);
        canvas.drawBitmap(bitmap, null, dst, null);
    }
    
    

/*          I don't think we really need it   
    SpriteDrawer (ISprite sprite, Actor actor) {
        dim = actor.getActorDimensions();
        pos = actor.getScreenPosition();
        dst = new Rect(pos.x,pos.y,pos.x+dim.width,pos.y+dim.height);
        this.sprite = sprite;
    }
*/
    
}
