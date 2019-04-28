package com.nodeapps.battlecon.database.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class SetModel {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "set_name")
    public String setName;

    @Ignore
    public SetModel() {}

    public SetModel(int uid, String setName) {
        this.uid = uid;
        this.setName = setName;
    }
}
