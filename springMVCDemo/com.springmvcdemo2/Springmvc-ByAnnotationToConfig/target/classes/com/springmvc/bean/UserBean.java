package com.springmvc.bean;

/**
 * @date 2021/10/7 -18:33
 */
//实体类
public class UserBean {
    private Integer id;
    private String pwd;

    public UserBean(Integer id, String sex) {
        this.id = id;
        this.pwd = sex;
    }

    public UserBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}


