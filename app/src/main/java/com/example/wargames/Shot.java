package com.example.wargames;

import android.graphics.Bitmap;

public class Shot extends Sprite {
    public Shot(Bitmap bitmap, int x, int y) {
        super(bitmap, x, y);
    }

    public void move() {

        y -= 17;


    }

    public void restart(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
