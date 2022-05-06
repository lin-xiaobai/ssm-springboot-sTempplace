package com.boot.bean;

/**
 * @date 2021/11/5 -20:02
 */

public class Pet {
    private String name;
    public Pet(){}
    public Pet(String name){this.name=name;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }
}
