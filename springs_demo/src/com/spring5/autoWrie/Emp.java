package com.spring5.autoWrie;

/**
 * @date 2021/7/17 -17:31
 * 员工类
 * <p>
 * 手动转配：自己在配置文件中自定义<property>中name和value
 * 自动转配：
 */
public class Emp {
    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }
}
