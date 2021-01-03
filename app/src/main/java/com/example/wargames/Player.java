package com.example.wargames;

import android.graphics.Bitmap;

public class Player extends Sprite {
    private  float targetX;
    private  float targetY;
    private  double moveX;
    private  double moveY;
    public Player(Bitmap bitmap, int x, int y) {
        super(bitmap, x, y);
        targetX=x;
        targetY=y;
        moveX=0;
        moveY=0;
    }
    public  void  move() {
        moveX = (Math.max(x, targetX) - Math.min(x, targetX));
        moveY = (Math.max(y, targetY) - Math.min(y, targetY));


        if (x < targetX) {
            if (moveY > moveX)
                if (Math.max(y, targetY) == y)
                    y -= 10;
                else
                    y += 10;

            x += 10;
        }

        if (x > targetX) {
            if (moveY > moveX)
                if (Math.max(y, targetY) == y)
                    y -= 10;
                else
                    y += 10;

            x -= 10;
        }
        if (y < targetY) {
            if (moveX > moveY)
                if (Math.max(x, targetX) == x)
                    x -= 10;
                else
                    x += 10;

            y += 10;
        }

        if (y > targetY) {
            if (moveX > moveY)
                if (Math.max(x, targetX) == x)
                    x -= 10;
                else
                    x += 10;

            y -= 10;
        }
    }
    public  void moveTo(float x, float y) {
        targetY=y;
        targetX=x;
    }



}
