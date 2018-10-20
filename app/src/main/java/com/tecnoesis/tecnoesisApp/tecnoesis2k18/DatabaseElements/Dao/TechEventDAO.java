package com.tecnoesis.tecnoesisApp.tecnoesis2k18.DatabaseElements.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.tecnoesis.tecnoesisApp.tecnoesis2k18.DatabaseElements.Models.TechEvent;

import java.util.List;

@Dao
public interface TechEventDAO {
    @Insert
    void insert(TechEvent event);

    @Query("SELECT * FROM events_table ORDER BY event_date ASC")
    LiveData<List<TechEvent>> getAll();

    @Query("DELETE FROM events_table WHERE _id = :id")
    void deleteByid(int id);

    @Query("DELETE FROM events_table")
    void deleteAll();

    @Query("DELETE FROM events_table WHERE event_name = :name")
    void deleteByEventName(String name);

    @Update
    void update(TechEvent event);
}
