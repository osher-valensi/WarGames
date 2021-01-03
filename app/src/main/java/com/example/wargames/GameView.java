package com.example.wargames;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Message;
import android.view.MotionEvent;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {
    private Thread thread;
    private GameBackground gameBackground;
    private Player player;
    private Enemy enemy;
    private Shot shot;
    private Enemy enemy2;
    private playing.ScoreHandler handler;


    public GameView(Context context, int windowHeight, int windowWidth, playing.ScoreHandler handler) {
        super(context);
        thread = new Thread(this);
         this.handler=handler;
        Bitmap playerBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.space_ship1);
        playerBitmap = Bitmap.createScaledBitmap(playerBitmap, 150, 150, false);
        player = new Player(playerBitmap, 50, 50);

        Bitmap playerBitmapEnemy = BitmapFactory.decodeResource(getResources(), R.drawable.enemy1);
        playerBitmapEnemy = Bitmap.createScaledBitmap(playerBitmapEnemy, 100, 100, false);
        enemy = new Enemy(playerBitmapEnemy, 500, 500);

        Bitmap playerBitmapEnemy2 = BitmapFactory.decodeResource(getResources(), R.drawable.enemy1);
        playerBitmapEnemy2 = Bitmap.createScaledBitmap(playerBitmapEnemy2, 100, 100, false);
        enemy2 = new Enemy(playerBitmapEnemy2, 600, 600);

        Bitmap playerShot1 = BitmapFactory.decodeResource(getResources(), R.drawable.lazer_shot);
        playerShot1 = Bitmap.createScaledBitmap(playerShot1, 100, 100, false);
        shot = new Shot(playerShot1, 0, 0);

        Bitmap gameBackgroundBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.home_page_background1);
//       gameBackgroundBitmap=Bitmap.createScaledBitmap(gameBackgroundBitmap,windowWidth,windowHeight,false);
        gameBackground = new GameBackground(gameBackgroundBitmap, 0, 0);


        thread.start();
    }

    @Override
    public void run() {
        int counter = 0;
        int hits = 0;
        boolean hitTarget=false;
        boolean gameOver = false;
        while (!gameOver) {

            counter++;
            counter %= 30;
            if (counter == 0) {
                shot.restart(player.getX(), player.getY());

            }

            drawSurface();
            move();
            if (shot.checkCollision(player))
                hitTarget = false;
            if (shot.checkCollision(enemy2) || shot.checkCollision(enemy)) {
                if (!hitTarget)
                hits++;
                if (hits == 15) {
                    gameOver = true;
                    Message msg = handler.obtainMessage();

                    msg.what = 3;
                    handler.sendMessage(msg);
                    thread.stop();
                }

                Message msg = handler.obtainMessage();
                if (!hitTarget) {

                    msg.getData().putInt("score", 1);
                    msg.what = 1;
                    handler.sendMessage(msg);
                    hitTarget = true;
                }

            }

            if (player.checkCollision(enemy) || player.checkCollision(enemy2)) {
                gameOver = true;

                Message msg = handler.obtainMessage();

                msg.what = 2;
                handler.sendMessage(msg);
                thread.stop();

            }

        }




    }


    private void drawSurface() {
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
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
        player.moveTo(event.getX(), event.getY());
        return true;
    }
}
