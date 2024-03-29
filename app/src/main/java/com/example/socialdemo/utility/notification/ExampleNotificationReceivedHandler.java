package com.example.socialdemo.utility.notification;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.onesignal.OSNotification;
import com.onesignal.OneSignal;

import org.json.JSONObject;

public class ExampleNotificationReceivedHandler implements OneSignal.NotificationReceivedHandler {
    private Context mcontext;
    public ExampleNotificationReceivedHandler(Context context) {
        this.mcontext=context;
    }

    @Override
    public void notificationReceived(OSNotification notification) {
        JSONObject data = notification.payload.additionalData;
        String notificationID = notification.payload.notificationID;
        String title = notification.payload.title;
        String body = notification.payload.body;
        String smallIcon = notification.payload.smallIcon;
        String largeIcon = notification.payload.largeIcon;
        String bigPicture = notification.payload.bigPicture;
        String smallIconAccentColor = notification.payload.smallIconAccentColor;
        String sound = notification.payload.sound;
        String ledColor = notification.payload.ledColor;
        int lockScreenVisibility = notification.payload.lockScreenVisibility;
        String groupKey = notification.payload.groupKey;
        String groupMessage = notification.payload.groupMessage;
        String fromProjectNumber = notification.payload.fromProjectNumber;
        String rawPayload = notification.payload.rawPayload;
              Intent intent = new Intent();
               // Intent intent = new Intent(NotificationExtenderExample.this, NotificationReceiver.class);
                intent.setAction("com.objects.NotificationReceiver11");
                // Broadcast the given intent to all interested BroadcastReceivers
        mcontext.sendBroadcast(intent);
        String customKey;

        Log.i("OneSignalExample", "NotificationID received: " + notificationID);

        if (data != null) {
            customKey = data.optString("customkey", null);
            if (customKey != null)
                Log.i("OneSignalExample", "customkey set with value: " + customKey);
        }
    }
}
