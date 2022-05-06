package com.springMVC.bean;

/**
 * @date 2021/10/7 -18:33
 */
//实体类
public class UserBean {
    private Integer id;
    private String name;
    private Integer sex;

    public UserBean(Integer id, String name, Integer sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
    public UserBean(){}

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
