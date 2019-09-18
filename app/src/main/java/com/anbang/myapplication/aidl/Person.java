package com.anbang.myapplication.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable{
	private Integer id;
	private String name;
	
	public Person(){}
	
	public Person(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//ʵ��Parcelable����ʵ�ֵķ���,��֪�����������,ֱ�ӷ���0������
	@Override
	public int describeContents() {
		return 0;
	}

	//д�����ݵ�Parcel�еķ���
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		//�Ѷ���������������д�뵽parcel��
		dest.writeInt(id);
		dest.writeString(name);		
	}
	
	//�����ṩһ����ΪCREATOR��static final���� ��������Ҫʵ��
	//android.os.Parcelable.Creator<T>�ӿ� 
	 public static final Creator<Person> CREATOR = new Creator<Person>() {

		//��Parcel�ж�ȡ����,����Person���� 
		@Override
		public Person createFromParcel(Parcel source) {
			return new Person(source.readInt(),source.readString());
		}

		@Override
		public Person[] newArray(int size) {
			return new Person[size];
		}
	
	 
	 };
	
	//��Ϊ���Ǽ���ȡ��Ԫ�ص�ʱ���Ǹ���Person������ȡ��,���ԱȽ��鷳,
	//��Ҫ������дhashCode()��equals()����
		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			if (name == null)
			{
				if (other.name != null)
					return false;
			}
			else if (!name.equals(other.name))
				return false;
			return true;
		}
	 
	 
}
