package com.example.wargames;

import android.graphics.Bitmap;

import java.util.Random;

public class Enemy extends Sprite {
    public Enemy(Bitmap bitmap, int x, int y) {
        super(bitmap, x, y);
    }
 private  int change = 0;
    private  int moveSpeed = 17;
    public  void  move(){


        Random r = new Random();

        int ran = r.nextInt(3) ;

        if(ran==1)
            x+=moveSpeed;
        else
            if (ran==2)
                x-=moveSpeed;

        ran = r.nextInt(3) ;
        if(ran==1)
            y+=moveSpeed;
        else
        if (ran==2)
            y-=moveSpeed;


 if(x<10)
     x+=10;
 if(y<10)
     y+=10;

        if(x>800)
            x-=10;
        if(y>1250)
            y-=10;

    }
}
