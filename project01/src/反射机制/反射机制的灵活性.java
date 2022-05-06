package 反射机制;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @date 2021/4/15 -23:06
 * 验证反射机制的灵活性
 * java代码写一遍，在不改源代码的基础之上，可以做到不同对象的实例化，非常灵活
 * （符合OCP开闭原则：对扩展开放，对修改关闭）
 */
public class 反射机制的灵活性 {
    public static void main(String[] args) throws Exception {
//        这种方式就写死了，只能创建一个user对象
//        user u=new user();

//        以下代码是比较灵活的，代码不需要改动，可以修改配置文化，配置文件修改之后，可以创建出不同的实例变量
//        通过io流读取配置文件
//            创建输入流
        FileInputStream fis = new FileInputStream("classinfo.properties");
//        创建map集合
        Properties properties = new Properties();
//        将输入流加载到properties集合中
        properties.load(fis);
//        关闭流
        fis.close();
//        通过key获取value
//        String value=properties.getProperty("class");
        String classname = properties.getProperty("name");

//        通过反射机制实例化对象
//        Class c=Class.forName(value);
        Class c = Class.forName(classname);
//        通过newInstance()实例化对象，并且调用无参构造方法，返回是一个object
        Object obj = c.newInstance();
        System.out.println(obj);
    }
}
