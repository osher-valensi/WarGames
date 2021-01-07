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
    private boolean showPlayer ;
    private Enemy enemy;
    private boolean showEnemy ;
    private Shot shot;
    private Enemy enemy2;
    private boolean showEnemy2 ;
    private Enemy enemy3;
    private boolean showEnemy3 ;
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

        Bitmap playerBitmapEnemy3 = BitmapFactory.decodeResource(getResources(), R.drawable.enemy1);
        playerBitmapEnemy3 = Bitmap.createScaledBitmap(playerBitmapEnemy3, 100, 100, false);
        enemy3 = new Enemy(playerBitmapEnemy2, 700, 700);

        Bitmap playerShot1 = BitmapFactory.decodeResource(getResources(), R.drawable.lazer_shot);
        playerShot1 = Bitmap.createScaledBitmap(playerShot1, 100, 100, false);
        shot = new Shot(playerShot1, 0, 0);

        Bitmap gameBackgroundBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.home_page_background1);
//       gameBackgroundBitmap=Bitmap.createScaledBitmap(gameBackgroundBitmap,windowWidth,windowHeight,false);
        gameBackground = new GameBackground(gameBackgroundBitmap, 0, 0);

        showEnemy = true;
        showEnemy2 = true;
        showEnemy3 = true;
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
            counter %= 22;
            if (counter == 0) {
                shot.restart(player.getX(), player.getY());

            }
if(!gameOver) {
    drawSurface();
    move();
}


            if ((shot.checkCollision(enemy2)&&showEnemy2 )|| (shot.checkCollision(enemy)&&showEnemy) || (shot.checkCollision(enemy3)&&showEnemy3))  {
//                if (!hitTarget)
//                hits++;
//                if (hits == 15) {
//                    gameOver = true;
//                    Message msg = handler.obtainMessage();
//
//                    msg.what = 3;
//                    handler.sendMessage(msg);
//                    thread.stop();
//                }
//
                if(shot.checkCollision(enemy)) {
                    if(showEnemy) {
                        shot.restart(player.getX(), player.getY());
                        addScore();
                    }
                    showEnemy = false;

                }
                if(shot.checkCollision(enemy2)) {
                    if(showEnemy2) {
                        shot.restart(player.getX(), player.getY());
                        addScore();
                    }
                    showEnemy2 = false;

                }
                if(shot.checkCollision(enemy3)) {
                    if(showEnemy3) {
                        shot.restart(player.getX(), player.getY());
                        addScore();
                    }
                    showEnemy3 = false;

                }



            }





                    if(!showEnemy3&&!showEnemy2&&!showEnemy)
            {
                gameOver = true;
                Message msg = handler.obtainMessage();

                msg.what = 3;
                handler.sendMessage(msg);

            }
           else if ((player.checkCollision(enemy)&&showEnemy) || (player.checkCollision(enemy2)&&showEnemy2) || (player.checkCollision(enemy3)&&showEnemy3)) {
                gameOver = true;

                Message msg = handler.obtainMessage();

                msg.what = 2;
                handler.sendMessage(msg);


            }

        }




    }
private void addScore(){
        Message msg = handler.obtainMessage();
        msg.getData().putInt("score", 1);
        msg.what = 1;
        handler.sendMessage(msg);

    }

    private void drawSurface() {
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            gameBackground.draw(canvas);
            if(showEnemy)
            enemy.draw(canvas);
            player.draw(canvas);
            if(showEnemy2)
            enemy2.draw(canvas);
            if(showEnemy3)
            enemy3.draw(canvas);
            shot.draw(canvas);
            getHolder().unlockCanvasAndPost(canvas);
        }

    }

    private void move() {
        player.move();
        if(showEnemy)
        enemy.move();
        shot.move();
        if(showEnemy2)
        enemy2.move();
        if(showEnemy3)
        enemy3.move();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        player.moveTo(event.getX(), event.getY());
        return true;
    }

    public void pause() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        thread = new Thread();
        thread.start();
    }
}

