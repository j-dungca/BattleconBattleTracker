package com.nodeapps.battlecon.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.nodeapps.battlecon.database.model.CharacterModel;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface CharacterDao {
    @Query("SELECT * FROM charactermodel")
    List<CharacterModel> getAll();

    @Query("SELECT * FROM charactermodel WHERE set_id IS (:setId)")
    Observable<List<CharacterModel>> getAllBySetId(int setId);

    @Insert
    void insertAll(CharacterModel... users);

    @Delete
    void delete(CharacterModel user);
}
