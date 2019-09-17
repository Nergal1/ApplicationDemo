package com.anbang.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.anbang.myapplication.broadcast.BroadcastTestActivity;
import com.anbang.myapplication.polling.PollingService;
import com.anbang.myapplication.polling.PollingUtils;


public class MainActivity extends BaseActivity {
    private String tag = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(tag, "---------onCreate---------");
        Button button = findViewById(R.id.start_btn);
        //显式启动和隐式启动
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                        Intent second = new Intent(MainActivity.this,SecondActivity.class);
//                        startActivity(second);
//                        overridePendingTransition(R.anim.anim_enter,0);

                ////        param1:Activity、Service所在应用的包名.param2:Activity、Service的包名+类名
                //        ComponentName    path =new ComponentName("com.anbang.myapplication","com.anbang.myapplication.SecondActivity");
                //        Intent second = new Intent();
                //        second.setComponent(path);
                //        startActivity(second);

                //        Intent intent = new Intent("android.intent.action.MAIN");
                //        intent.setClassName("com.anbang.myapplication","com.anbang.myapplication.SecondActivity");
                //        startActivity(intent);

                //        //隐式启动
                //        Intent intent = new Intent();
                //        intent.setAction("second_action");
                //        intent.addCategory("second_category");
                //        startActivity(intent);

                //        //打开QQ音乐
                //        Intent intent = getPackageManager().getLaunchIntentForPackage
                //                ("com.tencent.qqmusic") ;
                //        startActivity(intent) ;
                Intent intent = new Intent();
                intent.setDataAndType(Uri.parse("dj://www.dajia.com:1000/image"),"jpeg/png");
                startActivity(intent);
            }
        });

        Button startService = findViewById(R.id.start_service);
        Button stopService = findViewById(R.id.stop_service);
        Button pollingService = findViewById(R.id.polling_service);

        //start service
        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.anbang.myapplication.service.TEST_SERVICE1");
                //android 5.0以上
                intent.setPackage(getPackageName());
                startService(intent);
            }
        });

        //stop servic
        stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.anbang.myapplication.service.TEST_SERVICE1");
                intent.setPackage(getPackageName());
                stopService(intent);
            }
        });

        //轮询服务
        pollingService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PollingUtils.startPollingService(MainActivity.this, 60, PollingService.class, PollingService.ACTION);
            }
        });

        Button aidlComplexTest = findViewById(R.id.aidl_service_c);
        aidlComplexTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AIDLClientComplexActivity.class);
                startActivity(intent);
            }
        });

        Button aidlTest = findViewById(R.id.aidl_service);
        aidlTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AIDLClientActivity.class);
                startActivity(intent);
            }
        });

        Button broadcast = findViewById(R.id.broadcast);
        broadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BroadcastTestActivity.class);
                startActivity(intent);
            }
        });

        Intent it1 = new Intent("com.anbang.myapplication.service.TEST_SERVICE3");
        it1.setPackage(getPackageName());
        Bundle b1 = new Bundle();
        b1.putString("param", "s1");
        it1.putExtras(b1);

        Intent it2 = new Intent("com.anbang.myapplication.service.TEST_SERVICE3");
        it2.setPackage(getPackageName());
        Bundle b2 = new Bundle();
        b2.putString("param", "s2");
        it2.putExtras(b2);

        Intent it3 = new Intent("com.anbang.myapplication.service.TEST_SERVICE3");
        it3.setPackage(getPackageName());
        Bundle b3 = new Bundle();
        b3.putString("param", "s3");
        it3.putExtras(b3);

        //接着启动多次IntentService,每次启动,都会新建一个工作线程
        //但始终只有一个IntentService实例
        startService(it1);
        startService(it2);
        startService(it3);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(tag, "---------onRestart---------");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(tag, "---------onStart---------");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(tag, "---------onRestoreInstanceState---------");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.i(tag, "---------onWindowFocusChanged---------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(tag, "---------onResume---------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(tag, "---------onPause---------");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(tag, "---------onStop---------");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(tag, "---------onSaveInstanceState---------");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag, "---------onDestroy---------");
    }
}
