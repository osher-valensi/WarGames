package com.example.wargames;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;

public abstract class Sprite {
    protected Bitmap bitmap;
    protected  int x;
    protected  int y;

    public Sprite(Bitmap bitmap, int x, int y) {
        this.bitmap = bitmap;
        this.x = x;
        this.y = y;
    }
    public  void  draw(Canvas canvas){
        canvas.drawBitmap(bitmap,x,y,null);
    }
    public   abstract void  move ();


    public int  getX() {return x;};
    public int  getY() {return y;};

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
