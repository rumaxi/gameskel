package com.rumaxi.gameskel;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;


public class Core {
    private Scene currentScene;


    Core(Resources resources) {
        Sprites bitmaps = new Sprites(resources);
    }

    void tick(Canvas canvas) {
        currentScene.tick(canvas);
    }
        
    public void setScene(Scene scene) {
        this.currentScene = scene;
    }
    
    
    
}
