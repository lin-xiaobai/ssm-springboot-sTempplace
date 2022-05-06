package com.spring5;

/**
 * @date 2021/7/4 -19:40
 * 5.p名称空间注入（了解） 底层还是应用了set方法
 * （1）使用p名称空间注入，可以简化基于xml配置方式
 * <p>
 * （2）进行属性注入，在bean标签里面进行操作
 */
public class student {
    private String name;
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public String toString() {
//        return "student{" +
//                "name='" + name + '\'' +
//                ", id='" + id + '\'' +
//                '}';
//    }
}

