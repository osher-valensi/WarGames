package com.example.wargames;
import android.graphics.Bitmap;
import android.graphics.Canvas;

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


}
