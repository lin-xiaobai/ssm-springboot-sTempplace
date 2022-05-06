package 集合.Map接口;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @date 2021/4/8 -20:48
 */
public class 遍历集合Map {
    public static void main(String[] args) {
//        定义一个map集合，泛型为string类型和integer类型
        Map<Integer, String> m = new HashMap<>();
//        添加元素
        m.put(1, "zhang");
        m.put(2, "li");
        m.put(3, "zhao");
        m.put(4, "lin");
        m.put(5, "lin");
//        遍历集合map
//        获取所有的key值，而所有的key值是一个set集合
        Set<Integer> keys = m.keySet();
//        使用迭代器,指定迭代器的元素类型
        Iterator<Integer> it = keys.iterator();
//        遍历集合map
        while (it.hasNext()) {
//            取出其中一个key值
            Integer key = it.next();
//            通过key获取value，而value的泛型是string类型
            String value = m.get(key);
            System.out.println(key + ":" + value);
        }
        System.out.println(m.size());
        System.out.println("=====");
//        使用foreach
        for (Integer i2 : keys) {
            String s = m.get(i2);
            System.out.println(s);
        }


    }
}
