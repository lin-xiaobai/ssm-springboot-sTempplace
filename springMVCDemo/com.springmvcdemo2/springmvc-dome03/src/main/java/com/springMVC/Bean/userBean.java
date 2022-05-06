package com.springMVC.Bean;

/**
 * @date 2021/9/12 -18:48
 */
//实体类
public class userBean {
    private String username;
    private  String pwd;
    public userBean(){
    }
    public userBean(String username,String pwd){
        this.username=username;
        this.pwd=pwd;
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

    @Override
    public String toString() {
        return "userBean{" +
                "username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
