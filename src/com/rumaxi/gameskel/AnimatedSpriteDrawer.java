package com.rumaxi.gameskel;

import android.graphics.Canvas;

public class AnimatedSpriteDrawer implements IActorDrawer {
    private int ticksPerFrame;
    private AnimatedSprite sprite;
    private int lastFrame;
    
    public void draw(Canvas canvas, Actor actor) {
        
    }

    public AnimatedSpriteDrawer(AnimatedSprite sprite, int ticksPerFrame) {
        this.ticksPerFrame = ticksPerFrame;
        this.sprite = sprite;
        lastFrame=0;
    }
        
}
