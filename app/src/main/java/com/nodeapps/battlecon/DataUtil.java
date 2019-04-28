package com.nodeapps.battlecon;

import com.nodeapps.battlecon.database.model.CharacterModel;
import com.nodeapps.battlecon.database.model.SetModel;

public class DataUtil {
    public static CharacterModel[] prepopulateCharacterTable() {
        CharacterModel[] characters = {
                new CharacterModel("Eligor","The First Character",1),
                new CharacterModel("Shektur","The Second Character",1),
                new CharacterModel("Akuma","The Third Character",2)
        };

        return characters;
    }

    public static SetModel[] prepopulateSetTable() {
        SetModel[] sets = {
                new SetModel(1,"Devastation of Indines"),
                new SetModel(2, "Fate of Indines")
        };

        return sets;
    }
}
