1.
//启动轮询服务
PollingUtils.startPollingService(this, 60, PollingService.class, PollingService.ACTION);

2. 轮询

    @Override
    	public int onStartCommand(Intent intent, int flags, int startId) {
    		Log.i("PollingService", "onStartCommand");
    		Log.d("PollingService","Polling...");
    		return START_NOT_STICKY;
    	}

3.
    //关闭轮询服务
    PollingUtils.stopPollingService(this, PollingService.class, PollingService.ACTION);