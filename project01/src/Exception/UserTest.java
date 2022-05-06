package Exception;

import java.util.Scanner;

/**
 * @date 2021/4/1 -22:36
 * 注册账号
 * 键盘输入
 * 将接受的int类型转换string类型
 * 对string的长度进行判断
 */
public class UserTest {
    public static void main(String[] args) {
        System.out.println("请注册信息");
        Scanner sc = new Scanner(System.in);
//        键盘输入账号和密码
//        创建一个注册检验方法
        UserService us = new UserService();
        System.out.print("请输入账号：");
        int count = sc.nextInt();
        System.out.println();


        System.out.print("请输入密码：");
        int password = sc.nextInt();

//        捕捉异常
        try {
            //        将一个int类型转换为string类型
            String s1 = String.valueOf(count);
            String s2 = String.valueOf(password);
            us.register(s1, s2);
            System.out.println("注册成功\n账号：" + s1 + "\n" + "密码：" + s2);
        } catch (ZiDingYiLei e) {
            e.printStackTrace();
        }
        System.out.println("------");

    }
}
