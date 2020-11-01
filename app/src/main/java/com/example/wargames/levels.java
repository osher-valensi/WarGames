package com.example.wargames;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class levels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        ArrayList<level> levels = new ArrayList<>() ;
        for (int i = 1;i<21;i++){

            levels.add(new level(""+i+"",false,"level", "x"));


        }
        RecyclerView recyclerView=findViewById(R.id.recyclerview_levels);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        LevelAdapter levelAdapter=new LevelAdapter(levels);
        recyclerView.setAdapter(levelAdapter);
    }
    public void gohome(View view) {
        startActivity(new Intent(this,home_page.class));
    }
}


