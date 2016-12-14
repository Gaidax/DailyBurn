package com.example.dailyburn;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

public class MyAlarmService extends Service {

    // private NotificationManager mManager;
    public MyAlarmService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        // throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        super.onStart(intent, startId);

        Log.d("testing alarm","Hello hello 1 2 3   hello hello service class");
        NotificationCompat.Builder mNotify=new NotificationCompat.Builder(this.getApplicationContext());
        mNotify.setSmallIcon(R.drawable.notification_icon);
        mNotify.setContentTitle("DailyBurn");
        mNotify.setContentText("Hi there! Time to eat your meal !! ");
        mNotify.setPriority(Notification.PRIORITY_HIGH);
        mNotify.setDefaults(Notification.DEFAULT_ALL);
        Intent resultIntent=new Intent(this.getApplicationContext(),ProgressSurvey.class);
        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this.getApplicationContext());
        stackBuilder.addParentStack(MainActivity.class); //add the to-be-displayed activity to the top of stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        mNotify.setContentIntent(resultPendingIntent);
        NotificationManager notificationManager=(NotificationManager) this.getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,mNotify.build());
    }


}

