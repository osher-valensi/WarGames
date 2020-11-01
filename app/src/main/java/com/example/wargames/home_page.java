package com.example.wargames;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class home_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
    }

    public void play(View view) {
        startActivity(new Intent(this,levels.class));
    }

    public void gotoupgrades(View view) {
        startActivity(new Intent(this,upgrades_and_spaceships.class));
    }

    public void losingscreen(View view) {
        startActivity(new Intent(this,losing_page.class));
    }

    public void goplay(View view) {

            startActivity(new Intent(this,playing.class));

    }
}
