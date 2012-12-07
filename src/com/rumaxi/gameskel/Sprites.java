package com.rumaxi.gameskel;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class Sprites {
    static private Resources res;
    static BitmapFactory.Options bmfOpt;
    
    Sprites(Resources res) {
        Sprites.res = res;
    }
    
    public static Bitmap getBackground () {
        return BitmapFactory.decodeResource(res, R.drawable.mario_bg, bmfOpt);
    }
    
    public static Bitmap getCat () {
        return BitmapFactory.decodeResource(res, R.drawable.nyancat, bmfOpt);
    }    
    
    public static Bitmap getMario () {
        return BitmapFactory.decodeResource(res, R.drawable.mariosheet, bmfOpt);        
    }
    
    Sprites () {
        bmfOpt = new BitmapFactory.Options();
        bmfOpt.inScaled = false;      
    }
}
