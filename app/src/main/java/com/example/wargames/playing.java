package com.example.wargames;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class playing extends AppCompatActivity {
    private FrameLayout frameLayout;
    private int score = 0;
    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);
        frameLayout = findViewById(R.id.framelayout);


    }

    @Override
    protected void onPause() {
        super.onPause();
        if (gameView != null)
            gameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (gameView != null)
            gameView.resume();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        int windowHeight = frameLayout.getHeight();
        int windowWidth = frameLayout.getWidth();
        gameView = new GameView(this, windowWidth, windowHeight, new ScoreHandler());
        frameLayout.addView(gameView);
    }

    public class ScoreHandler extends Handler {


        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == 1) {
                score += msg.getData().getInt("score");
                TextView scoreTextView = findViewById(R.id.textviewscore);
                scoreTextView.setText("score: " + score);
            }
           else if (msg.what == 2) {
                startActivity(new Intent(playing.this, losing_page.class));
                finish();
            }

             else if (msg.what == 3) {
                startActivity(new Intent(playing.this, win_screen.class));
                finish();
            }


        }
    }
}
