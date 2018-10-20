package com.tecnoesis.tecnoesisApp.tecnoesis2k18.DatabaseElements.Models;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "notifications_table")
public class Notification {
    @PrimaryKey(autoGenerate = true)
    public int _id;
    @ColumnInfo(name = "text")
    public String mText;
    @ColumnInfo(name = "issue_time")
    public long mIssueTime;

    public Notification(String mText, long mIssueTime) {
        this.mText = mText;
        this.mIssueTime = mIssueTime;
    }

    public Notification() {

    }

    public String getmText() {
        return mText;
    }

    public long getmIssueTime() {
        return mIssueTime;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
