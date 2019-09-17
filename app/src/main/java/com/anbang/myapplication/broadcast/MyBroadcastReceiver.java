package com.anbang.myapplication.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    public final static String ACTION = "com.beiyou.broadcast";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION)) {
            Toast.makeText(context, "接受到广播啦！", Toast.LENGTH_SHORT).show();
        }
    }
}
