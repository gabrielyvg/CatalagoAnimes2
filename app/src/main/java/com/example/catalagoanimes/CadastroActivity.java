package com.example.catalagoanimes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.catalagoanimes.controller.AnimeDAO;
import com.example.catalagoanimes.entity.Anime;
public class CadastroActivity extends AppCompatActivity {

    EditText etNome;
    EditText etGenero;
    EditText etDescricao;
    Button bSalvar;

    boolean modoEditar = false;

    AnimeDAO animeDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etNome = findViewById(R.id.etNome);
        etGenero = findViewById(R.id.etGenero);
        etDescricao = findViewById(R.id.etDescricao);
        bSalvar = findViewById(R.id.bSalvar);

        animeDAO = new AnimeDAO();

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1);

        if(position != -1){
            Anime anime = animeDAO.getAnime(position);
            etNome.setText(anime.getNome());
            etGenero.setText(anime.getGenero());
            etDescricao.setText(anime.getDescricao());

            modoEditar = true;
        }

        bSalvar.setOnClickListener(v -> {
            if(etNome.getText().toString().isEmpty() || etGenero.getText().toString().isEmpty() || etDescricao.getText().toString().isEmpty()){
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            }else{

                Anime anime = new Anime(
                        etNome.getText().toString(),
                        etGenero.getText().toString(),
                        etDescricao.getText().toString()
                );
                if(!modoEditar){
                    animeDAO.addAnime(anime);
                }
                else{
                    animeDAO.editarAnime(position, anime);
                }
                Toast.makeText(this, "Anime salvo!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}