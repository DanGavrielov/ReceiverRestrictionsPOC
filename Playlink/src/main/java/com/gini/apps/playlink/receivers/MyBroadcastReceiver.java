package com.gini.apps.playlink.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "ReceiverDebug";
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "intent received! " + intent.getAction(), Toast.LENGTH_LONG).show();
        Log.d(TAG, "intent received! " + intent.getAction());
    }
}
