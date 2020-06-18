package com.jerryHong.mypm25app.data.db;

import com.jerryHong.mypm25app.data.model.RepoAQIResponse;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import io.reactivex.Completable;

@Dao
public interface RepoAQIDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(RepoAQIResponse repoAQIResponse);
}
