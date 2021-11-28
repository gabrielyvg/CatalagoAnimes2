package com.example.catalagoanimes.controller;

import com.example.catalagoanimes.entity.Anime;

import java.util.ArrayList;
import java.util.List;

public class AnimeDAO {

    private static List<Anime> listaAnime = new ArrayList<>();


    public void addAnime (Anime a){
        listaAnime.add(a);
    }

    public Anime getAnime(int position){
        return listaAnime.get(position);
    }

    public void deleteAnime(int position){
        listaAnime.remove(position);
    }

    public List<Anime> getListaAnime(){
        return listaAnime;
    }

    public void editarAnime(int position, Anime anime){
        listaAnime.set(position, anime);
    }
}
