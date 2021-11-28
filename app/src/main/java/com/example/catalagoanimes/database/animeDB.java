package com.example.catalagoanimes.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.catalagoanimes.database.dao.animeDAO;
import com.example.catalagoanimes.entity.Anime;

@Database(entities = {Anime.class}, version = 1, exportSchema = false)
public abstract class animeDB extends RoomDatabase {

    private static animeDB instance;

    public static animeDB getInstance(Context context) {

        if (instance == null){
            instance = Room.databaseBuilder(context, animeDB.class,"anime")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract animeDAO getanimeDAO();
}
