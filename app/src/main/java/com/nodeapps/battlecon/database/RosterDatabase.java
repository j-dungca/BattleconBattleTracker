package com.nodeapps.battlecon.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.nodeapps.battlecon.DataUtil;
import com.nodeapps.battlecon.database.dao.CharacterDao;
import com.nodeapps.battlecon.database.dao.SetDao;
import com.nodeapps.battlecon.database.model.CharacterModel;
import com.nodeapps.battlecon.database.model.SetModel;

import java.util.concurrent.Executors;

@Database(entities = { CharacterModel.class, SetModel.class }, version = 1)
public abstract class RosterDatabase extends RoomDatabase {
    private static volatile RosterDatabase INSTANCE;

    public abstract CharacterDao characterDao();
    public abstract SetDao setDao();

    public static RosterDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (RosterDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RosterDatabase.class, "BattleconBattleTracker.db")
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    Executors.newSingleThreadScheduledExecutor().execute(
                                            () -> {
                                                getInstance(context).setDao().insertAll(DataUtil.prepopulateSetTable());
                                                getInstance(context).characterDao().insertAll(DataUtil.prepopulateCharacterTable());
                                            });
                                }
                            }).build();
                }
            }
        }
        return INSTANCE;
    }
}
