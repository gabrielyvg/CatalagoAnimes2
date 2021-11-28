package com.example.catalagoanimes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.catalagoanimes.adapter.AnimeAdapter;
import com.example.catalagoanimes.controller.AnimeDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {


    RecyclerView rvAnime;
    FloatingActionButton fabAdd;
    AnimeDAO animeDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAnime = findViewById(R.id.rvAnime);
        fabAdd = findViewById(R.id.fabAdd);

        animeDAO = new AnimeDAO();

        fabAdd.setOnClickListener(v -> {
           startActivity(new Intent(this, CadastroActivity.class));
        });

        RecyclerView.LayoutManager meuLayout = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        );

        rvAnime.setLayoutManager(meuLayout);

    }

    @Override
    protected void onResume(){
        super.onResume();

        AnimeAdapter animeAdapter = new AnimeAdapter(this, animeDAO);

        rvAnime.setAdapter(animeAdapter);
    }
}