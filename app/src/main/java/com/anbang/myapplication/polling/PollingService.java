package com.anbang.myapplication.polling;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;



/**
 * @author zhangchen
 *
 * @date 2017/10/17 下午2:50
 *
 * @Description 注意：使用前请确保EventBus已经注册。
 *
 */
public class PollingService extends Service {
	public static final String ACTION = "com.anbang.myapplication.polling.PollingService";
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	@Override
	public void onCreate() {
		super.onCreate();
		Log.i("PollingService", "轮询服务被创建onCreate");
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("PollingService", "onStartCommand");
		Log.d("PollingService","Polling...");
		return START_NOT_STICKY;
	}

	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i("PollingService", "轮询服务销毁了");
	}
}
