package com.rumaxi.gameskel;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Debug;
import android.util.Log;


public class Core {
    private Scene currentScene;
    int i = 0;

    Core(Resources resources) {
        Sprites bitmaps = new Sprites(resources);
    }

    void tick(Canvas canvas) {
        i++;
        if (i == 2) { Debug.startMethodTracing("tick");  } 
        currentScene.tick(canvas);
                if (i == 8) { Debug.stopMethodTracing(); System.exit(1); } 
                
    }
        
    public void setScene(Scene scene) {
        this.currentScene = scene;
    }
    
    
    
}
