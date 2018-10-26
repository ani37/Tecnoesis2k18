package com.tecnoesis.tecnoesisApp.tecnoesis2k18.FirebaseClasses;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
import android.util.Log;

import com.tecnoesis.tecnoesisApp.tecnoesis2k18.Activity.LoginActivity;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.DatabaseElements.AppRepository;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.DatabaseElements.Models.Notification;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.R;
import com.google.firebase.messaging.RemoteMessage;


import java.util.Map;

public class MyFirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService{

    private static final String TAG = "MyNotifService";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_TITLE = "title";
    public static final String NOTIFICATION_CHANNEL_ID = "2345";


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.e(TAG,"onMessagedReceived called");



        if(remoteMessage.getData().size() > 0){
            Map<String, String>  data = remoteMessage.getData();
            String title = data.get(KEY_TITLE);
            String message = data.get(KEY_MESSAGE);
            AppRepository repo = new AppRepository(getApplication());
            long time = System.currentTimeMillis();
            repo.insertNotif(new Notification(message, time));
            Log.e(TAG, title);
            Log.e(TAG, message);
            createNotification(title, message);
        }
    }



    public void createNotification(String title, String message)
    {
        Context mContext = getApplicationContext();
        Intent resultIntent = new Intent(mContext , LoginActivity.class);
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent resultPendingIntent = PendingIntent.getActivity(mContext,
                0 , resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

       android.app.Notification.Builder mBuilder = new android.app.Notification.Builder(mContext);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(false)
                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                .setContentIntent(resultPendingIntent);

        NotificationManager mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "CHANNEL1", importance);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            assert mNotificationManager != null;
            mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
        assert mNotificationManager != null;
        mNotificationManager.notify(0 , mBuilder.build());
    }
}


