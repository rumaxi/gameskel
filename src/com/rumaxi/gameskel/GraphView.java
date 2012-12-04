package com.rumaxi.gameskel;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class GraphView extends SurfaceView implements SurfaceHolder.Callback {
   private Game game;
   
   GraphView(Context context) {
        super(context); 
        getHolder().addCallback(this);
        game = new Game (this);
   }

    public void surfaceCreated(SurfaceHolder sh) {
        Thread t = new Thread (game);
        t.start();
    }
 
    public boolean onTouchEvent(MotionEvent event){
        game.getTouch(event);
        return false;
    }

    
    public void surfaceChanged(SurfaceHolder sh, int i, int i1, int i2) { }
    public void surfaceDestroyed(SurfaceHolder sh) { }    
}