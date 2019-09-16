package com.anbang.myapplication.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.anbang.myapplication.IPerson;

/**
 * Created by Jay on 2015/8/18 0018.
 */
public class AIDLService extends Service {

    private IBinder binder = new PersonQueryBinder();
    private String[] names = {"A神","B神","C神","D神","E神"};

    private String query(int num)
    {
        if(num > 0 && num < 6){
            return names[num - 1];
        }
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        int pid = android.os.Process.myPid();
        Log.i("AIDL","-----service---pid--------："+pid);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private final class PersonQueryBinder extends IPerson.Stub {
        @Override
        public String queryPerson(int num) throws RemoteException {
            return query(num);
        }
    }
}