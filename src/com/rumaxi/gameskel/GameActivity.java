package com.rumaxi.gameskel;

import android.app.Activity;
import android.os.Bundle;
import android.os.Debug;
import android.view.Display;
import android.view.Window;

public class GameActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Display display = getWindowManager().getDefaultDisplay(); 
        Settings.screenHeight = display.getHeight();
        Settings.screenWidth = display.getWidth();
        setContentView(new GraphView(this)); 
       // Debug.startMethodTracing("gameskel");
    }
    
    @Override
    public void onDestroy() {
         //   Debug.stopMethodTracing();
    }
}
