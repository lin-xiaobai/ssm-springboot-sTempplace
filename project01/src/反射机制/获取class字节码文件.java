package 反射机制;

import java.util.Date;

/**
 * @date 2021/4/15 -20:54
 * 获取class文件（字节码文件）方式：
 * 1.Class.forName()
 * (1)静态方法
 * (2)方法的参数是一个字符串
 * (3)字符串需要的是一个完整类名
 * (4)完整类名必须带有包名，java.lang包也不能省略
 * <p>
 * 第一种：Class c=Class.forName("完整类名带包名”）
 * 第二种：Class c=对象.getClass（）；
 * 第三种：Class c=任何类型.class;
 */
public class 获取class字节码文件 {
    public static void main(String[] args) {
//        获取字节码文件
        Class c1 = null;
        Class c2 = null;
        try {
//            C1代表String.class文件，或者说c1代表string类型
            c1 = Class.forName("java.lang.String");
//            c2代表Date类型
            c2 = Class.forName("java.util.Date");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//        java中任何一个对象都有一个方法：getClass()
        String X = "ABC";
        Class x = X.getClass();
//        x代表的String.class字节码文件，x代表string类型
        System.out.println(x == c1);//==判断的是对象的内存地址

        Date date = new Date();
        Class time = date.getClass();
//        time代表的是Date.class字节码文件，
        System.out.println(time == c2);

//        第三种方式：java语言中任何一种类型，包括基本数据类型，它都有.class属性
        Class z = String.class;//代表的是string类型
        Class i = int.class;
        Class f = float.class;
        System.out.println(c1 == z);

    }
}
