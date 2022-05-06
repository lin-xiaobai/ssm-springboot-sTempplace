package com.spring5;

/**
 * @date 2021/7/3 -19:57
 * 在spring配置文件配置对象创建。配置属性注入
 * 方式2  set方法注入属性
 */
public class book {
    private String name;
    private int id;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void test() {
        System.out.println(name + "::" + id);
    }
}
