package 集合.Map接口;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @date 2021/4/9 -11:54
 */
public class 测试HashMap集合key部分元素特点 {
    public static void main(String[] args) {
//        创建hashMap集合，泛型是integer和string
//        integer和string都重写了hashCode方法和equals方法
        Map<Integer, String> m = new HashMap<>();
//        添加元素
        m.put(111, "zhang");
        m.put(222, "liu");
        m.put(333, "lin");
        m.put(444, "cheng");
        m.put(111, "cai");//key重复的时候value会自动覆盖
//        map集合的无序不可重复
        System.out.println("集合元素个数：" + m.size());//4个，因为key重复了，会覆盖value
//        使用foreach遍历集合
//        因为key的值是放在set集合的
        Set<Map.Entry<Integer, String>> s1 = m.entrySet();
        for (Map.Entry<Integer, String> set : s1) {
            System.out.println(set.getKey() + "---》" + set.getValue());
        }
//        使用迭代器(效率低，每次都的通过key获取value
        Iterator<Map.Entry<Integer, String>> it = s1.iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> me = it.next();
            System.out.println(me.getKey() + "=" + me.getValue());
        }

    }
}
