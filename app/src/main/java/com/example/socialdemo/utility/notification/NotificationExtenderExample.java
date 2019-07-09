package com.example.socialdemo.utility.notification;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.socialdemo.utility.broadcast.NotificationReceiver;
import com.onesignal.NotificationExtenderService;
import com.onesignal.OSNotificationDisplayedResult;
import com.onesignal.OSNotificationReceivedResult;

import java.math.BigInteger;

public class NotificationExtenderExample extends NotificationExtenderService {
    public static final String channelID = "channelID";
    public static final String channelName = "Channel Name";
    private NotificationManager mManager;

    private  OSNotificationDisplayedResult displayedResult;
    @Override
    protected boolean onNotificationProcessing(OSNotificationReceivedResult notification) {
        //OverrideSettings overrideSettings = new OverrideSettings();
       createChannel();
//        overrideSettings.extender = new NotificationCompat.Extender() {
//            @Override
//            public NotificationCompat.Builder extend(NotificationCompat.Builder builder) {
//                builder.setChannelId(channelID).setColor(new BigInteger("FFFF0000", 16).intValue());
//                //mManager.notify(0, builder.build());
//              Intent intent = new Intent();
//               // Intent intent = new Intent(NotificationExtenderExample.this, NotificationReceiver.class);
//                intent.setAction("com.objects.NotificationReceiver11");
//                // Broadcast the given intent to all interested BroadcastReceivers
//                sendBroadcast(intent);
//                return builder;
//            }
//        };
         //displayedResult = displayNotification(overrideSettings);
     //   Log.d("OneSignalExample", "Notification displayed with id: " + displayedResult.androidNotificationId);
        // Return true to stop the notification from displaying
        return true;
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);//Low
        mManager = getSystemService(NotificationManager.class);
        mManager.createNotificationChannel(channel);
    }
}
