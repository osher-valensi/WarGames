package com.example.wargames;

import android.graphics.Bitmap;
import android.graphics.Color;

public class Player extends Sprite {
    private  float targetX;
    private  float targetY;
    public Player(Bitmap bitmap, int x, int y) {
        super(bitmap, x, y);
        targetX=x;
        targetY=y;
    }
    public  void  move(){
        if(x<targetX )
            x+=20;
        if(x>targetX)
            x-=20;
        if(y<targetY )
            y+=20;
        if(y>targetY)
            y-=20;
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
