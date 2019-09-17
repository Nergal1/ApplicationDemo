package com.anbang.myapplication;

import android.app.Activity;
import android.app.Service;  
import android.content.ComponentName;  
import android.content.Intent;  
import android.content.ServiceConnection;  
import android.os.Bundle;  
import android.os.IBinder;  
import android.os.RemoteException;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.Button;  
import android.widget.EditText;  
import android.widget.TextView;  
  
  
public class AIDLClientComplexActivity extends BaseActivity {
  
    private ISalary salaryService;  
    private Button btnquery;  
    private EditText editname;  
    private TextView textshow;  
    private ServiceConnection conn = new ServiceConnection() {  
          
        @Override  
        public void onServiceDisconnected(ComponentName name) {  
            salaryService = null;  
        }  
          
        @Override  
        public void onServiceConnected(ComponentName name, IBinder service) {  
            //返回的是代理对象,要调用这个方法哦!  
            salaryService = ISalary.Stub.asInterface(service);  
        }  
    };  
      
      
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_aidl_client2);
          
        btnquery = (Button) findViewById(R.id.btn_query);
        editname = (EditText) findViewById(R.id.edit_num);
        textshow = (TextView) findViewById(R.id.txt_name);
          
        Intent it = new Intent();  
        it.setAction("android.intent.action.AIDLService2");
        it.setPackage(getPackageName());
        bindService(it, conn, Service.BIND_AUTO_CREATE);  
          
        btnquery.setOnClickListener(new OnClickListener() {           
            @Override  
            public void onClick(View v) {  
                try  
                {  
                    String name = editname.getText().toString();  
                    Salary salary = salaryService.getMsg(new Person(1,name));  
                    textshow.setText(name + salary.toString());  
                }catch(RemoteException e){e.printStackTrace();}  
            }  
        });  
          
    }  
    @Override  
    protected void onDestroy() {  
        super.onDestroy();  
        this.unbindService(conn);  
    }  
      
} 
