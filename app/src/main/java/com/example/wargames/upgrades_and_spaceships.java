package com.example.wargames;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class upgrades_and_spaceships extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrades_and_spaceships);
    }

    public void gohome(View view) {
        startActivity(new Intent(this,home_page.class));
    }
}
