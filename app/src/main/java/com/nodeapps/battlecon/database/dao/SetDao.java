package com.nodeapps.battlecon.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.nodeapps.battlecon.database.model.SetModel;

import java.util.List;

@Dao
public interface SetDao {
    @Query("SELECT * FROM setmodel")
    List<SetModel> getAll();

    @Query("SELECT * FROM setmodel WHERE uid IN (:uids)")
    List<SetModel> getAllByIds(int[] uids);

    @Insert
    void insertAll(SetModel... users);

    @Delete
    void delete(SetModel user);
}
