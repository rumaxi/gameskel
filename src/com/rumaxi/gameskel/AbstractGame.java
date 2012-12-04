package com.rumaxi.gameskel;

import android.view.MotionEvent;

public abstract class AbstractGame {
    public void getTouch (MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            onTouch ((int)event.getX(),(int)event.getY());
        }
    }
    
    abstract void onTouch (int x,int y);
    
}
