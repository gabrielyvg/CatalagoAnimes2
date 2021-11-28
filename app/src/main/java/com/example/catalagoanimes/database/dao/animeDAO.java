package com.example.catalagoanimes.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.catalagoanimes.entity.Anime;

import java.util.List;

@Dao
public interface animeDAO {

    @Insert
    void salvarPokemon(Anime anime);

    @Delete
    void excluirPokemon(Anime anime);

    @Update
    void editarPokemon(Anime anime);

    @Query("SELECT * FROM animes")
    List<Anime> getAnimes();


}
