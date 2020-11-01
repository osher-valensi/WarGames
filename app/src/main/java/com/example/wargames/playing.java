package com.example.wargames;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

public class playing extends AppCompatActivity {
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);
        frameLayout=findViewById(R.id.framelayout);





    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        int windowHeight = frameLayout.getHeight();
        int windowWidth = frameLayout.getWidth();
        GameView gameView = new GameView(this, windowWidth, windowHeight);
        frameLayout.addView(gameView);
    }
}
