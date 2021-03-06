package com.rumaxi.gameskel;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Debug;
import android.util.Log;
import android.view.SurfaceHolder;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends AbstractGame implements Runnable {
    Core core;
    Scene scene;
    private Boolean running;
    private SurfaceHolder sh;
    private static Integer FPS = Settings.FPS; 
    private int realFps;
    
    Game(GraphView gv) {
        Resources res = gv.getResources();
        this.sh = gv.getHolder();
        this.core = new Core (res);
        scene = new Scene();
        //scene.addPrerender(new ClearScreen());        
        
        ISprite bg = new StaticSprite (Sprites.getBackground());
        scene.addPrerender(new SceneBackground(bg));
        
        Actor duck = new Actor();
        
        IMover mover = new SimpleMover();
        duck.setMover(mover);
        
        ISprite duckSprite = new AnimatedSprite(Sprites.getMario(),6,32);
        IActorDrawer drawer = new SpriteDrawer(duckSprite,5);
        duck.setDrawer(drawer);
        
        duck.type = ActorType.ACTOR_TEST;
        
        TestCollider collider = new TestCollider();
        collider.setType(ActorType.ACTOR_TEST);
        duck.addCollider(collider);
        
        scene.addActor(duck);
        
        //scene.addPostrender(new ObjectCountIndicator(scene));
        scene.addPostrender(new FPSIndicator(this));

        core.setScene(scene);
        running = true;
    }
        
    public void tick(Canvas canvas) { 
        core.tick(canvas);
    }

    @Override
    void onTouch(int x, int y) {
        Log.i("RUMA","Got touch "+String.valueOf(x)+" "+String.valueOf(y));
        Actor duck = new Actor(new Position(x,y), new Dimensions(35,35));
        ISprite duckSprite = new AnimatedSprite(Sprites.getMario(),6,32);
        IMover mover = new SimpleMover();
        duck.setMover(mover);
        IActorDrawer drawer = new SpriteDrawer(duckSprite,5);
        duck.setDrawer(drawer);
        
        duck.type = ActorType.ACTOR_TEST;
        
        TestCollider collider = new TestCollider();
        collider.setType(ActorType.ACTOR_TEST);
        duck.addCollider(collider);        
        
        scene.addActor(duck);        
    }

    public void run() {
        Canvas canvas;
        int frames = 0;
        int millisPerFrame= 1000/FPS;
        long sTime = System.currentTimeMillis();
        while (running) { 
            long startTime = System.currentTimeMillis();
            
            canvas = sh.lockCanvas();
            tick(canvas);
            frames++;

            long currTime = System.currentTimeMillis();
            int sTimeDiff = (int) (currTime -sTime);          
            if (sTimeDiff >= 1000) { sTime = currTime; realFps = frames; frames = 0; }
            sh.unlockCanvasAndPost(canvas);        
  /*          
            int runTime = (int) (currTime - startTime);
            int waitTime = (int)millisPerFrame - runTime;
            if (waitTime > 0) {
                try {
                    Thread.sleep((int)waitTime);
                } catch (InterruptedException ex) { 
                }
            } */
            
        }         
    }



int getFps() {
    return realFps;
}    

}
