package com.nodeapps.battlecon.database.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = SetModel.class,
                        parentColumns = "uid",
                        childColumns = "set_id"))
public class CharacterModel {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "character_name")
    public String characterName;

    @ColumnInfo(name = "character_description")
    public String characterDescription;

    @ColumnInfo(name = "set_id")
    public int setId;

    @Ignore
    public CharacterModel() {}

    public CharacterModel(String characterName, String characterDescription, int setId) {
        this.characterName = characterName;
        this.characterDescription = characterDescription;
        this.setId = setId;
    }
}
