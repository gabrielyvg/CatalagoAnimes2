package com.example.catalagoanimes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catalagoanimes.controller.AnimeDAO;
import com.example.catalagoanimes.entity.Anime;

public class DetalhesActivity extends AppCompatActivity {

    TextView tvNome;
    TextView tvGenero;
    TextView tvDescricao;
    Button bExcluir;
    Button bEditar;

    AnimeDAO animeDAO;

    boolean[] deletado = {false};
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        tvNome = findViewById(R.id.tvNome);
        tvGenero = findViewById(R.id.tvGenero);
        tvDescricao = findViewById(R.id.tvDescricao);
        bExcluir = findViewById(R.id.bExcluir);
        bEditar = findViewById(R.id.bEditar);

        animeDAO = new AnimeDAO();

        Intent detalhesIntent = getIntent();
        int position = detalhesIntent.getIntExtra("position", -1);

        if(position == -1){
            finish();
        }


        bExcluir.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Excluir Anime")
                    .setMessage("Deseja excluir este anime do catalago?")
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            animeDAO.deleteAnime(position);
                            deletado[0] = true;
                            onResume();

                        }
                    })
                    .setNegativeButton("Não", null)
                    .show();
        });

        bEditar.setOnClickListener(v -> {
            Intent editarIntent = new Intent(this, CadastroActivity.class);
            editarIntent.putExtra("position", position);
            startActivity(editarIntent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(deletado[0]){
            Toast.makeText(this, "Anime excluido!", Toast.LENGTH_SHORT);
            finish();
        }
        else{
            Anime anime = animeDAO.getAnime(position);

            tvNome.setText("Nome: " + anime.getNome());
            tvGenero.setText("Genero: " + anime.getGenero());
            tvDescricao.setText("Descricao: " + anime.getDescricao());
        }
    }
}