package com.anbang.myapplication.broadcast;


import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.anbang.myapplication.BaseActivity;
import com.anbang.myapplication.R;

public class BroadcastTestActivity extends BaseActivity {
    private MyBroadcastReceiver myBroadcastReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private boolean isLocal = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_test);
        myBroadcastReceiver = new MyBroadcastReceiver();
        if (isLocal) {
            localBroadcastManager = LocalBroadcastManager.getInstance(this);
        }
    }

    public void onClick(View view){
        int id = view.getId();
        if (id == R.id.register_broadcast){
            //动态注册
            IntentFilter intentFilter = new IntentFilter(MyBroadcastReceiver.ACTION);
            if (isLocal){
                localBroadcastManager.registerReceiver(myBroadcastReceiver,intentFilter);
            }else {
                registerReceiver(myBroadcastReceiver, intentFilter);
            }

        }else if (id == R.id.unregister_broadcast){
            //动态解绑
            if (isLocal){
                localBroadcastManager.unregisterReceiver(myBroadcastReceiver);
            }else
            {
                unregisterReceiver(myBroadcastReceiver);
            }

        }else if (id == R.id.send){

            //发送广播
            Intent intent = new Intent(MyBroadcastReceiver.ACTION);
            if (isLocal){
                localBroadcastManager.sendBroadcast(intent);
            }else {
                sendBroadcast(intent);
            }
        }
    }
}
