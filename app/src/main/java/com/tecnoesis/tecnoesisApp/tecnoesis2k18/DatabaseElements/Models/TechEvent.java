package com.tecnoesis.tecnoesisApp.tecnoesis2k18.DatabaseElements.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "events_table")
public class TechEvent {
    @PrimaryKey(autoGenerate = true)
    public int _id;

    @ColumnInfo(name = "event_name")
    public String mName;

    @ColumnInfo(name = "event_summary")
    public String mSummary;

    @ColumnInfo(name = "event_date")
    public long mDate;

    @ColumnInfo(name = "event_description")
    public String mDescription;

    @ColumnInfo(name = "event_url")
    public String mUrl;

    public TechEvent(String mName, String mSummary, long mDate, String mDescription, String mUrl) {
        this.mName = mName;
        this.mSummary = mSummary;
        this.mDate = mDate;
        this.mDescription = mDescription;
        this.mUrl = mUrl;
    }

    public TechEvent() {

    }

    public int get_id() {
        return _id;
    }

    public String getmName() {
        return mName;
    }

    public String getmSummary() {
        return mSummary;
    }

    public long getmDate() {
        return mDate;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
