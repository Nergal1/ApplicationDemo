package com.anbang.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.anbang.myapplication.service.TestService2;


public class SecondActivity extends BaseActivity {
    //保持所启动的Service的IBinder对象,同时定义一个ServiceConnection对象
    TestService2.MyBinder binder;
    private ServiceConnection conn = new ServiceConnection() {

        //Activity与Service断开连接时回调该方法
        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("------Service DisConnected-------");
        }

        //Activity与Service连接成功时回调该方法
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("------Service Connected-------");
            binder = (TestService2.MyBinder) service;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Uri uri = getIntent().getData();
        Toast.makeText(getApplicationContext(),""+uri.toString(),Toast.LENGTH_SHORT).show();

        Button bindService = findViewById(R.id.bindservice);
        //bind service
        bindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.anbang.myapplication.service.TEST_SERVICE2");
                intent.setPackage(getPackageName());
                bindService(intent,conn,BIND_AUTO_CREATE);
            }
        });
        Button unbindService = findViewById(R.id.unbindservice);
        //unbind service
        unbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setAction("com.anbang.myapplication.service.TEST_SERVICE2");
                    intent.setPackage(getPackageName());
                    unbindService(conn);
                }catch (IllegalArgumentException exception){
                    exception.printStackTrace();
                    Toast.makeText(getApplicationContext(),exception.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button connService = findViewById(R.id.connservice);

        //获取service 运行结果
        connService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binder!=null) {
                    Log.i("TestService2", "--------------:" + binder.getCount());
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.alpha_anim,0);
    }
}
