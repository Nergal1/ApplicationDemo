package com.anbang.myapplication.contentprovider;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;

public class MyObserver extends ContentObserver {
    /**
     * Creates a content observer.
     *
     * @param handler The handler to run {@link #onChange} on, or null if none.
     */
    public MyObserver(Handler handler) {
        super(handler);
    }

    @Override
    public void onChange(boolean selfChange) {
        Log.i("MyObserver","------onChange-----:"+selfChange);
        super.onChange(selfChange);
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        Log.i("MyObserver","------onChange-----:"+selfChange+"|----uri----:"+uri.toString());

        super.onChange(selfChange, uri);
    }
}
