package com.nodeapps.battlecon.database;

import com.nodeapps.battlecon.database.dao.CharacterDao;
import com.nodeapps.battlecon.database.dao.SetDao;
import com.nodeapps.battlecon.database.model.CharacterModel;

import java.util.List;

import io.reactivex.Observable;

public class RosterDataSource {

    private final CharacterDao characterDao;
    private final SetDao setDao;

    public RosterDataSource(CharacterDao characterDao, SetDao setDao) {
        this.characterDao = characterDao;
        this.setDao = setDao;
    }

    public Observable<List<CharacterModel>> getCharacterModels(int setId) {
        return characterDao.getAllBySetId(setId);
    }
}
