package com.springMVC.Bean;

/**
 * @date 2021/9/7 -20:59
 */
public class Userbean {
//    要使用引用类型
    private  String username;
    private  String pwd;
    private String sex;
    public Userbean(){

    }
    public Userbean(String username,String pwd,String sex){
        this.username=username;
        this.pwd=pwd;
        this.sex=sex;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Userbean{" +
                "username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
