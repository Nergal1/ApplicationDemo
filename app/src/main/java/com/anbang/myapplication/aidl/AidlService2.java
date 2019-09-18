package com.anbang.myapplication.aidl;

import java.util.HashMap;
import java.util.Map;

import com.anbang.myapplication.ISalary;

import android.app.Service;
import android.content.Intent;  
import android.os.IBinder;  
import android.os.RemoteException;  
  
public class AidlService2 extends Service {  
  
    private SalaryBinder salaryBinder;  
    private static Map<Person,Salary> ss = new HashMap<Person, Salary>();
    //初始化Map集合,这里在静态代码块中进行初始化,当然你可也以在构造方法中完成初始化  
    static  
    {  
        ss.put(new Person(1, "Jay"), new Salary("码农", 2000));  
        ss.put(new Person(2, "GEM"), new Salary("歌手", 20000));  
        ss.put(new Person(3, "XM"), new Salary("学生", 20));  
        ss.put(new Person(4, "MrWang"), new Salary("老师", 2000));  
    }  
      
      
    @Override  
    public void onCreate() {  
        super.onCreate();  
        salaryBinder = new SalaryBinder();  
    }  
      
    @Override  
    public IBinder onBind(Intent intent) {  
        return salaryBinder;  
    }  
  
      
    //同样是继承Stub,即同时实现ISalary接口和IBinder接口  
    public class SalaryBinder extends ISalary.Stub
    {  
        @Override  
        public Salary getMsg(Person owner) throws RemoteException {  
            return ss.get(owner);  
        }  
    }  
      
    @Override  
    public void onDestroy() {  
        System.out.println("服务结束！");  
        super.onDestroy();  
    }  
}  
