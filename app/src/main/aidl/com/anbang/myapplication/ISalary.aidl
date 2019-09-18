package com.anbang.myapplication;

import com.anbang.myapplication.aidl.Salary;
import com.anbang.myapplication.aidl.Person;
interface ISalary
{

	Salary getMsg(in Person owner);
}
       