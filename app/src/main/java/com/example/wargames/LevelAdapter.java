package com.example.wargames;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.levelviewholder> {

    private   ArrayList<level> levels  ;

    public LevelAdapter(ArrayList<level> levels) {
        this.levels = levels;
    }

    @NonNull
    @Override
    public levelviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View levelview = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleritem_level,parent,false);
        return new levelviewholder(levelview);
    }

    @Override
    public void onBindViewHolder(@NonNull levelviewholder holder, int position) {
        level cuurentLevel=levels.get(position);
        holder.level_number.setText(cuurentLevel.getLevel_number());
        holder.level.setText(cuurentLevel.getLevel());
        holder.iconImageveiw.setImageResource( holder.level_number.getResources().getIdentifier(cuurentLevel.getIcon(), "drawble", holder.level_number.getContext().getPackageName()) );
    }

    @Override
    public int getItemCount() {
        return levels.size();
    }

    public  static  class levelviewholder extends RecyclerView.ViewHolder {



        public TextView level_number;
        public TextView level;
        public ImageView iconImageveiw;
        public levelviewholder(@NonNull View itemView) {
            super(itemView);
            level_number=itemView.findViewById(R.id.textView_level_number);
            level=itemView.findViewById(R.id.textView_level);
            iconImageveiw=itemView.findViewById(R.id.imageView_icon);
        }
    }
}
