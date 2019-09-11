package com.anbang.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String tag = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(tag,"---------onCreate---------");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(tag,"---------onRestart---------");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(tag,"---------onStart---------");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(tag,"---------onRestoreInstanceState---------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(tag,"---------onResume---------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(tag,"---------onPause---------");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(tag,"---------onStop---------");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(tag,"---------onSaveInstanceState---------");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag,"---------onDestroy---------");
    }
}
