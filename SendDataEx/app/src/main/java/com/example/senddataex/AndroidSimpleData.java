package com.example.senddataex;

import android.os.Parcel;
import android.os.Parcelable;


public class AndroidSimpleData implements Parcelable {
    private String name;
    private int age;
    private boolean gender;

    public AndroidSimpleData() {
    }

    public AndroidSimpleData(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // 역직렬화란, 스트링을 자바객체로 변환해주는 작업
    // 역직렬화 메서드
    protected AndroidSimpleData(Parcel in) {
        name = in.readString();
        age = in.readInt();
        gender = in.readByte() != 0;
    }
    
    public static final Creator<AndroidSimpleData> CREATOR = new Creator<AndroidSimpleData>() {
        @Override
        public AndroidSimpleData createFromParcel(Parcel in) {
            return new AndroidSimpleData(in);
        }

        @Override
        public AndroidSimpleData[] newArray(int size) {
            return new AndroidSimpleData[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "AndroidSimpleData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // 직렬화란, 객체를 스트링으로 변환해주는 작업
    // 직렬화 메서드
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeByte((byte) (gender ? 1 : 0));
    }
}
