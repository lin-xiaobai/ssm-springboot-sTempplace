package 集合.Map接口;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * @date 2021/4/9 -16:33
 */
public class properties属性类 {
    public static void main(String[] args) {
//        创建集合（线程安全）泛型指定是string类型
        Properties properties = new Properties();
//        添加元素
        properties.setProperty("username", "123");
        properties.setProperty("name1", "11");
        properties.setProperty("name2", "11");
        properties.setProperty("name3", "11");
        properties.setProperty("name4", "11");
        properties.setProperty("name5", "11");
//        通过key获取value
//       如果key的值在集合中找不到会返回一个null
        String name1 = properties.getProperty("username");
        String name2 = properties.getProperty("name1");
        String name3 = properties.getProperty("name2");
        String name4 = properties.getProperty("name3");
        String name5 = properties.getProperty("name4");
        String name6 = properties.getProperty("name");

        List<String> list = new ArrayList<>();
        list.add(name1);
        list.add(name2);
        list.add(name3);
        list.add(name4);
        list.add(name5);
        list.add(name6);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
    }

}
