package 反射机制;

import java.io.InputStream;
import java.util.Properties;

/**
 * @date 2021/4/16 -11:09
 */
public class 以流的形式直接返回 {
    public static void main(String[] args) throws Exception {
////        获取一个文件的绝对路径
//        FileReader reader=new FileReader("classinfo.properties");
//        Properties properties=new Properties();
//        properties.load(reader);
//        String s=properties.getProperty("class");
//        System.out.println(s);

//        以流的形式返回，以输出流的方式
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("classInfoText.properties");
//        创建map集合
        Properties properties = new Properties();
//        将流的对象加载到map对象中
        properties.load(is);
//        通过key获取value值
//        String path=properties.getProperty("name");
        String path = properties.getProperty("class");

        System.out.println(path);
        is.close();
    }
}
