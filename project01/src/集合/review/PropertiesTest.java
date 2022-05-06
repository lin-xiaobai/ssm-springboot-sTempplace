package 集合.review;

import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * @date 2021/4/10 -12:03
 */
public class PropertiesTest {
    public static void main(String[] args) {
        Properties p = new Properties();
        p.setProperty("100", "a123");
        p.setProperty("20", "500");
        p.setProperty("30", "600");
//        通过字符串key获取value，返回值是一个string类型
        System.out.println(p.getProperty("100"));
        SimpleDateFormat sdf = new SimpleDateFormat();
    }
}
