package com.example.catalagoanimes.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity (tableName="animes")
public class Anime {


    @PrimaryKey (autoGenerate = true)
    private int idAnime;
    private String nome;
    private String genero;
    private String descricao;

    public Anime(){
    }

    @Ignore
    public Anime(String nome, String genero, String descricao) {
        this.nome = nome;
        this.genero = genero;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdAnime() { return idAnime; }

    public void setIdAnime(int idAnime) { this.idAnime = idAnime; }
}
