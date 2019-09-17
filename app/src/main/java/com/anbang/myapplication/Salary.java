package com.anbang.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Salary implements Parcelable{
	private String type;
	private Integer salary;
	
	public Salary(){}
	

	public Salary(String type, Integer salary) {
		super();
		this.type = type;
		this.salary = salary;
	}


	



	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Integer getSalary() {
		return salary;
	}


	public void setSalary(Integer salary) {
		this.salary = salary;
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(type);
		dest.writeInt(salary);
	}
	
	 public static final Creator<Salary> CREATOR = new Creator<Salary>() {

		@Override
		public Salary createFromParcel(Parcel source) {
			return new Salary(source.readString(),source.readInt());
		}

		@Override
		public Salary[] newArray(int size) {
			return new Salary[size];
		}
	
	 
	 };
	
	public String toString() 
	{
		return "  工种:"+type+"   薪水:ˮ"+salary;
	};
	
}
