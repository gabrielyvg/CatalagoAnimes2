package com.example.catalagoanimes.adapter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catalagoanimes.R;

public class AnimeViewHolder extends RecyclerView.ViewHolder{

    TextView tvNome;
    Button bDetalhes;

    public AnimeViewHolder(@NonNull View itemView){
        super(itemView);

        tvNome = itemView.findViewById(R.id.tvNome);
        bDetalhes = itemView.findViewById(R.id.bDetalhes);

    }

}
