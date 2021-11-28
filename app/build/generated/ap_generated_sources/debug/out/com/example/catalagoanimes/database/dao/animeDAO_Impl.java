package com.example.catalagoanimes.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.catalagoanimes.entity.Anime;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class animeDAO_Impl implements animeDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Anime> __insertionAdapterOfAnime;

  private final EntityDeletionOrUpdateAdapter<Anime> __deletionAdapterOfAnime;

  private final EntityDeletionOrUpdateAdapter<Anime> __updateAdapterOfAnime;

  public animeDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAnime = new EntityInsertionAdapter<Anime>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `animes` (`idAnime`,`nome`,`genero`,`descricao`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Anime value) {
        stmt.bindLong(1, value.getIdAnime());
        if (value.getNome() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNome());
        }
        if (value.getGenero() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGenero());
        }
        if (value.getDescricao() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDescricao());
        }
      }
    };
    this.__deletionAdapterOfAnime = new EntityDeletionOrUpdateAdapter<Anime>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `animes` WHERE `idAnime` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Anime value) {
        stmt.bindLong(1, value.getIdAnime());
      }
    };
    this.__updateAdapterOfAnime = new EntityDeletionOrUpdateAdapter<Anime>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `animes` SET `idAnime` = ?,`nome` = ?,`genero` = ?,`descricao` = ? WHERE `idAnime` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Anime value) {
        stmt.bindLong(1, value.getIdAnime());
        if (value.getNome() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNome());
        }
        if (value.getGenero() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGenero());
        }
        if (value.getDescricao() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDescricao());
        }
        stmt.bindLong(5, value.getIdAnime());
      }
    };
  }

  @Override
  public void salvarPokemon(final Anime anime) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAnime.insert(anime);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void excluirPokemon(final Anime anime) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfAnime.handle(anime);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void editarPokemon(final Anime anime) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfAnime.handle(anime);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Anime> getAnimes() {
    final String _sql = "SELECT * FROM animes";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIdAnime = CursorUtil.getColumnIndexOrThrow(_cursor, "idAnime");
      final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
      final int _cursorIndexOfGenero = CursorUtil.getColumnIndexOrThrow(_cursor, "genero");
      final int _cursorIndexOfDescricao = CursorUtil.getColumnIndexOrThrow(_cursor, "descricao");
      final List<Anime> _result = new ArrayList<Anime>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Anime _item;
        _item = new Anime();
        final int _tmpIdAnime;
        _tmpIdAnime = _cursor.getInt(_cursorIndexOfIdAnime);
        _item.setIdAnime(_tmpIdAnime);
        final String _tmpNome;
        if (_cursor.isNull(_cursorIndexOfNome)) {
          _tmpNome = null;
        } else {
          _tmpNome = _cursor.getString(_cursorIndexOfNome);
        }
        _item.setNome(_tmpNome);
        final String _tmpGenero;
        if (_cursor.isNull(_cursorIndexOfGenero)) {
          _tmpGenero = null;
        } else {
          _tmpGenero = _cursor.getString(_cursorIndexOfGenero);
        }
        _item.setGenero(_tmpGenero);
        final String _tmpDescricao;
        if (_cursor.isNull(_cursorIndexOfDescricao)) {
          _tmpDescricao = null;
        } else {
          _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        }
        _item.setDescricao(_tmpDescricao);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
