package com.tecnoesis.tecnoesisApp.tecnoesis2k18.DatabaseElements;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.tecnoesis.tecnoesisApp.tecnoesis2k18.DatabaseElements.Dao.NotificationDAO;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.DatabaseElements.Dao.TechEventDAO;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.DatabaseElements.Models.Notification;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.DatabaseElements.Models.TechEvent;


@Database(entities = {Notification.class, TechEvent.class} , version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NotificationDAO notificationDAO();
    public abstract TechEventDAO techEventDAO();
    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "app_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }



    /*private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };



    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final NotificationDAO mDao;

        PopulateDbAsync(AppDatabase db) {
            mDao = db.notificationDAO();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            return null;
        }
    }*/

}
