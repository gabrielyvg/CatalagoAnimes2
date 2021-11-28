package com.example.catalagoanimes.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catalagoanimes.DetalhesActivity;
import com.example.catalagoanimes.R;
import com.example.catalagoanimes.controller.AnimeDAO;
import com.example.catalagoanimes.entity.Anime;

public class AnimeAdapter extends RecyclerView.Adapter{

    private Context context;
    private AnimeDAO animeDAO;

    public AnimeAdapter(Context context, AnimeDAO animeDAO) {
        this.context = context;
        this.animeDAO = animeDAO;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View viewAnime = LayoutInflater.from(context).inflate(R.layout.anime_layout, parent, false);

       AnimeViewHolder animeViewHolder = new AnimeViewHolder(viewAnime);

        return animeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        AnimeViewHolder animeViewHolder = (AnimeViewHolder) holder;

        Anime anime = animeDAO.getAnime(position);

        animeViewHolder.tvNome.setText(anime.getNome());

        animeViewHolder.bDetalhes.setOnClickListener(v ->{
            Intent detalhesIntent = new Intent(context, DetalhesActivity.class);
            detalhesIntent.putExtra("position", position);
            context.startActivity(detalhesIntent);
        });

    }

    @Override
    public int getItemCount() {
        return animeDAO.getListaAnime().size();
    }
}
