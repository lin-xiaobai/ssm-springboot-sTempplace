package com.spring5.webfiuxdemo.entity;

/**
 * @date 2021/8/6 -11:41
 * 实体类
 */
public class User {
    private String name;
    private  String gender;
    private Integer age;
    public User(){
    }
    public User(String name,String gender,Integer age){
        this.name=name;
        this.gender=gender;
        this.age=age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }
}

