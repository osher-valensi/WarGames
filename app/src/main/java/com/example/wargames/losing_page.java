package com.example.wargames;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class losing_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_losing_page);
    }

    public void home_page(View view) {
        startActivity(new Intent(this,home_page.class));
    }

    public void winpage(View view) {
        startActivity(new Intent(this,win_screen.class));
    }
}
