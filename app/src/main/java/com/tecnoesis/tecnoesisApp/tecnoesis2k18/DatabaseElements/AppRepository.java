package com.tecnoesis.tecnoesisApp.tecnoesis2k18.DatabaseElements;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.tecnoesis.tecnoesisApp.tecnoesis2k18.DatabaseElements.Dao.NotificationDAO;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.DatabaseElements.Dao.TechEventDAO;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.DatabaseElements.Models.Notification;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.DatabaseElements.Models.TechEvent;


import java.util.List;

public class AppRepository {
    private static NotificationDAO mNotificationDao;
    private static TechEventDAO mEventDao;

    private AppDatabase mDatabase;

    private static final String LOG_TAG = "AppRepository";

    private static final int NOTIF_DELETEALL = 0;
    private static final int NOTIF_DELETE = 1;
    private static final int NOTIF_INSERT = 2;
    private static final int NOTIF_UPDATE = 3;

    private static final int EVENT_DELETEALL = 21;
    private static final int EVENT_DELETE_ID = 22;
    private static final int EVENT_DELETE_NAME = 30;
    private static final int EVENT_INSERT = 23;
    private static final int EVENT_UPDATE = 24;
    private static final int EVENT_GETALL = 25;
    private static final String TAG = "AppRepository";





    public AppRepository(Application application){
        mDatabase = AppDatabase.getDatabase(application);
        mNotificationDao = mDatabase.notificationDAO();
        mEventDao = mDatabase.techEventDAO();
    }
    //get all notifications
    public LiveData<List<Notification>> getAllNotifications(){
        return mNotificationDao.getAll();
    }
    //get all Events
    public LiveData<List<TechEvent>> getAllEvents(){
        return mEventDao.getAll();
    }

    //methods for insert del NOTIFICATIONS
    public void insertNotif(Notification notif){
        new WorkerAsync( NOTIF_INSERT, mDatabase).execute(notif);
    }
    public void deleteNotifbyID(int id){
        new WorkerAsync( NOTIF_DELETE, mDatabase).execute(id);
    }
    public void deleteAllNotif(){
        new WorkerAsync( NOTIF_DELETEALL, mDatabase).execute();
    }
    public void updateNotif(Notification notif){
        new WorkerAsync( NOTIF_UPDATE, mDatabase).execute(notif);
    }

    //methods for insert del EVENTS
    public void insertEvent(TechEvent event){
        new WorkerAsync( EVENT_INSERT, mDatabase).execute(event);
    }
    public void deleteEventByid(int id){
        new WorkerAsync(EVENT_DELETE_ID, mDatabase).execute(id);
    }
    public void deleteEventByName(String name){
        new WorkerAsync(EVENT_DELETE_NAME, mDatabase).execute(name);
    }

    public void deleteAllEvents(){
        new WorkerAsync( EVENT_DELETEALL, mDatabase).execute();
    }
    public void updateEvent(TechEvent event){
        new WorkerAsync( EVENT_UPDATE, mDatabase).execute(event);
    }




    //background async tasker
    static class WorkerAsync extends AsyncTask<Object, Void, Void> {

        NotificationDAO notifDao;
        TechEventDAO eventDao;
        int command;
        WorkerAsync(int command, AppDatabase database){
            this.notifDao = database.notificationDAO();
            this.eventDao = database.techEventDAO();
            this.command = command;
        }

        @Override
        protected Void doInBackground(Object... objects) {

            //notification actions
            if(command == NOTIF_DELETE){
                notifDao.delete((int)objects[0]);
            }
            if(command == NOTIF_DELETEALL){
                notifDao.deleteAll();
            }
            if(command == NOTIF_INSERT){
                notifDao.insert((Notification) objects[0]);
            }
            if(command == NOTIF_UPDATE){
                notifDao.update((Notification) objects[0]);
            }

            //event actions
            if(command == EVENT_DELETE_ID){
                eventDao.deleteByid((int)objects[0]);
            }
            if(command == EVENT_DELETE_NAME){
                eventDao.deleteByEventName((String) objects[0]);
            }
            if(command == EVENT_DELETEALL){
                eventDao.deleteAll();
            }
            if(command == EVENT_INSERT){
                eventDao.insert((TechEvent) objects[0]);
            }
            if(command == EVENT_UPDATE){
                eventDao.update((TechEvent) objects[0]);
            }
            if(command == EVENT_DELETE_NAME){
                eventDao.update((TechEvent) objects[0]);
            }





            return null;
        }
    }

}