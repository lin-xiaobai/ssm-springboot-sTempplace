package com.spring5.InsideBean;

/**
 * @date 2021/7/9 -17:38
 * 3.注入属性---内部bean
 * <p>
 * spring配置文件
 * <p>
 * 一对多关系：部门和员工
 * 一个部门有多个员工，一个员工属于一个部门
 * 部门是一，员工是多
 * （2）在实体类之间表示一对多关系，员工表示所属部门，使用对象类型属性进行表示
 */
//部门类
public class Dept {
    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }


    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
