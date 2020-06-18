package com.jerryHong.mypm25app.data;

import android.content.Context;

import com.jerryHong.mypm25app.data.db.RepoAQIDao;
import com.jerryHong.mypm25app.data.db.RepoDatabase;

import androidx.room.Room;

public class DataManager {
    public static DataManager instance = null;

    private RepoDatabase db;
    private DataManager() {
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }

        return instance;
    }

    public void initDatabase(Context context) {
        db = Room.databaseBuilder(context, RepoDatabase.class, "MyDatabase")
                //.allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    public void closeDatabase() {
        db.close();
    }

    public RepoAQIDao getRepoAQIDao(){
        return db.getRepoAQI();
    }
}
