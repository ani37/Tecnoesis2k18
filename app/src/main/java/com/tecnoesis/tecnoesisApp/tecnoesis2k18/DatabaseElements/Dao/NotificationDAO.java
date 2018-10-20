package com.tecnoesis.tecnoesisApp.tecnoesis2k18.DatabaseElements.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.tecnoesis.tecnoesisApp.tecnoesis2k18.DatabaseElements.Models.Notification;

import java.util.List;

@Dao
public interface NotificationDAO {
    @Insert
    void insert(Notification notification);

    @Update
    void update(Notification notification);

    @Query("SELECT * FROM notifications_table ORDER BY issue_time ASC")
    LiveData<List<Notification>> getAll();

    @Query("DELETE FROM notifications_table WHERE _id= :id")
    void delete(int id);

    @Query("DELETE FROM notifications_table")
    void deleteAll();

}
