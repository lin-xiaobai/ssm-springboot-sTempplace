package Exception;

import java.util.Scanner;

/**
 * @date 2021/4/1 -23:06
 */
public class 简化代码 {

    public static void main(String[] args) {
        System.out.println("请注册信息");
        Scanner sc = new Scanner(System.in);
//        键盘输入账号和密码
//        创建一个注册检验方法
        UserService us = new UserService();
        System.out.print("请输入账号：");
        String count = sc.next();
        System.out.println();

        System.out.print("请输入密码：");
        String password = sc.next();

//        捕捉异常
        try {
            us.register(count, password);
            System.out.println("注册成功\n账号：" + count + "\n" + "密码：" + password);
        } catch (ZiDingYiLei e) {
            e.printStackTrace();
        }
        System.out.println("------");

    }
}

