package com.example.socialdemo.utility.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class NotificationReceiver extends BroadcastReceiver {

//    protected Set<NotificationReceiverListener> listeners;
//
//    public NotificationReceiver() {
//        listeners = new HashSet<NotificationReceiverListener>();
//    }
    @Override
    public void onReceive(Context context, Intent intent) {
        // an Intent broadcast.
        Toast.makeText(context,"Please Check Your data",Toast.LENGTH_SHORT).show();
//        notifyStateToAll();
    }
//
//    public void addListener(NotificationReceiverListener l) {
//        listeners.add(l);
//    }
//    private void notifyStateToAll() {
//        for(NotificationReceiverListener listener : listeners)
//           listener.updateUI();
//    }
//    public void removeListener(NotificationReceiverListener l) {
//        listeners.remove(l);
//    }
//
//    public interface NotificationReceiverListener {
//         void updateUI();
//    }
}
