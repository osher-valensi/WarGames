package com.example.wargames;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {
    private Thread thread;
    private  Player player;
    private  Enemy enemy;

    public GameView(Context context,int windowHeight, int windowWidth) {
        super(context);
        thread=new Thread(this);

        Bitmap playerBitmap= BitmapFactory.decodeResource(getResources(),R.drawable.space_ship1);
        playerBitmap=Bitmap.createScaledBitmap(playerBitmap,150,150,false);
        player=new Player(playerBitmap,50,50);

        Bitmap playerBitmapEnemy= BitmapFactory.decodeResource(getResources(),R.drawable.x);
        playerBitmapEnemy=Bitmap.createScaledBitmap(playerBitmapEnemy,100,100,false);
        enemy=new Enemy(playerBitmapEnemy,500,500);



        thread.start();
    }

    @Override
    public void run() {
        while (true) {

            drawSurface();
            move();
            if (player.checkCollision(enemy)) {
                boolean gameOver = true;
            }
        }


    }


    private void drawSurface() {
        if(getHolder().getSurface().isValid()){
            Canvas canvas=getHolder().lockCanvas();

            enemy.draw(canvas);
            player.draw(canvas);
            getHolder().unlockCanvasAndPost(canvas);
        }

    }

    private void move() {
        player.move();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        player.moveTo(event.getX(),event.getY());
        return true;
    }
}
