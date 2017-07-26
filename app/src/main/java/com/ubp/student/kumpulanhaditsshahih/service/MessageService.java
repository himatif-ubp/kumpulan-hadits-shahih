package com.ubp.student.kumpulanhaditsshahih.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;
import com.orm.SugarRecord;
import com.ubp.student.kumpulanhaditsshahih.R;
import com.ubp.student.kumpulanhaditsshahih.activity.PemberitahuanActivity;
import com.ubp.student.kumpulanhaditsshahih.clients.model.NotifModel;

/**
 * Created by Dizzay on 7/22/2017.
 */

public class MessageService extends FirebaseMessagingService {

    private static final String TAG = "Service";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            Log.d(TAG, "Message data payload: " + remoteMessage.getData().get("data"));
            String json = remoteMessage.getData().get("data");
            NotifModel notifModel = new Gson().fromJson(json, NotifModel.class);
            SugarRecord.save(notifModel);
            sendNotification(notifModel);
        }

    }

    public void sendNotification(NotifModel notifModel) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ubp_logo)
                        .setContentTitle("Hadits Hari Ini")
                        .setContentText(notifModel.getNama());
        Intent resultIntent = new Intent(this, PemberitahuanActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(PemberitahuanActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1001, mBuilder.build());
    }

}
