package com.example.wargames;

import android.graphics.Bitmap;

public class Shot extends Sprite {
    public Shot(Bitmap bitmap, int x, int y) {
        super(bitmap, x, y);
    }

    public  void  move(){

           y-=10;
           if(y<=0)
               y=2000;

    }
}
