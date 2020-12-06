package com.example.wargames;

import android.graphics.Bitmap;

import java.util.Random;

public class Enemy extends Sprite {
    public Enemy(Bitmap bitmap, int x, int y) {
        super(bitmap, x, y);
    }

    public  void  move(){
        Random r = new Random();
        int ran = r.nextInt(3) ;
        if(ran==1)
            x+=10;
        else
            if (ran==2)
                x-=10;
        ran = r.nextInt(3) ;
        if(ran==1)
            y+=10;
        else
        if (ran==2)
            y-=10;


 if(x<10)
     x+=10;
 if(y<10)
     y+=10;

        if(x>800)
            x-=10;
        if(y>800)
            y-=10;

    }
}
