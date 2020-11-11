package com.example.senddataex;

import java.io.Serializable;

// 자바객체를 인텐트에 담아 전송하려면 해당 클래스에서 직렬화/역직렬화를 해야한다
public class JavaSimpleData implements Serializable {
    private String name;
    private int age;
    private boolean gender;

    // 기본생성자
    public JavaSimpleData() {
        this("무명", 22, true);
    }

    // 파라미터있는 기본생성자
    public JavaSimpleData(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

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
        return "JavaSimpleData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
