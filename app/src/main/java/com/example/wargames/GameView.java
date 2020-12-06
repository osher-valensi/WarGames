package com.example.wargames;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {
    private Thread thread;
     private  GameBackground gameBackground;
    private  Player player;
    private  Enemy enemy;
    private  Shot shot;
    private  Enemy enemy2;

    public GameView(Context context,int windowHeight, int windowWidth) {
        super(context);
        thread=new Thread(this);

        Bitmap playerBitmap= BitmapFactory.decodeResource(getResources(),R.drawable.space_ship1);
        playerBitmap=Bitmap.createScaledBitmap(playerBitmap,150,150,false);
        player=new Player(playerBitmap,50,50);

        Bitmap playerBitmapEnemy= BitmapFactory.decodeResource(getResources(),R.drawable.x);
        playerBitmapEnemy=Bitmap.createScaledBitmap(playerBitmapEnemy,100,100,false);
        enemy=new Enemy(playerBitmapEnemy,500,500);

        Bitmap playerBitmapEnemy2= BitmapFactory.decodeResource(getResources(),R.drawable.x);
        playerBitmapEnemy2=Bitmap.createScaledBitmap(playerBitmapEnemy2,100,100,false);
        enemy2=new Enemy(playerBitmapEnemy2,600,600);

        Bitmap playerShot1= BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_foreground);
        playerShot1=Bitmap.createScaledBitmap(playerShot1,100,100,false);
         shot = new Shot(playerShot1, 600, 600);

        Bitmap gameBackgroundBitmap= BitmapFactory.decodeResource(getResources(),R.drawable.home_page_background1);
//       gameBackgroundBitmap=Bitmap.createScaledBitmap(gameBackgroundBitmap,windowWidth,windowHeight,false);
        gameBackground=new GameBackground(gameBackgroundBitmap,0,0);



        thread.start();
    }

    @Override
    public void run() {
        boolean gameOver = false;
        while (!gameOver) {

            drawSurface();
            move();
            if (player.checkCollision(enemy)) {
                 gameOver = true;
            }
        }


    }


    private void drawSurface() {
        if(getHolder().getSurface().isValid()){
            Canvas canvas=getHolder().lockCanvas();
gameBackground.draw(canvas);
            enemy.draw(canvas);
            player.draw(canvas);
            enemy2.draw(canvas);
            shot.draw(canvas);
            getHolder().unlockCanvasAndPost(canvas);
        }

    }

    private void move() {
        player.move();
        enemy.move();
        shot.move();
        enemy2.move();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        player.moveTo(event.getX(),event.getY());
        return true;
    }
}
