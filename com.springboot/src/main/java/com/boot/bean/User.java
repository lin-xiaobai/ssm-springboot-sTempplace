package com.boot.bean;

/**
 * @date 2021/11/5 -20:02
 */

public class User {
    private  String name;
    private int age;
    private  Pet pet;

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
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

    public  User(){
    }
    public  User(String name,int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
