package com.example.wargames;

import android.graphics.Bitmap;
import android.graphics.Color;

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
                    y -= 20;
                else
                    y += 20;

            x += 20;
        }

        if (x > targetX) {
            if (moveY > moveX)
                if (Math.max(y, targetY) == y)
                    y -= 20;
                else
                    y += 20;

            x -= 20;
        }
        if (y < targetY) {
            if (moveX > moveY)
                if (Math.max(x, targetX) == x)
                    x -= 20;
                else
                    x += 20;

            y += 20;
        }

        if (y > targetY) {
            if (moveX > moveY)
                if (Math.max(x, targetX) == x)
                    x -= 20;
                else
                    x += 20;

            y -= 20;
        }
    }
    public  void moveTo(float x, float y) {
        targetY=y;
        targetX=x;
    }
    public boolean checkCollision(Sprite other) {
        int left = Math.max(x, other.x);

        int right = Math.min(x+bitmap.getWidth(), other.x+other.bitmap.getWidth());
        int top = Math.max(y, other.y);
        int bottom = Math.min(y+bitmap.getHeight(), other.y+other.bitmap.getHeight());
        for (int row  = left; row < right; row++) {
            for (int col = top; col < bottom; col++) {
                if (bitmap.getPixel(row-x, col-y)!= Color.TRANSPARENT &&
                        other.bitmap.getPixel(row-other.x, col-other.y)!= Color.TRANSPARENT) {
                    return true;
                }
            }
        }
        return false;
    }


}
