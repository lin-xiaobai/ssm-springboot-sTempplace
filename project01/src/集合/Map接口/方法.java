package 集合.Map接口;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @date 2021/4/8 -20:21
 */
public class 方法 {
    public static void main(String[] args) {
//        创建map方法,key为integer类型，value为string类型
        Map<Integer, String> m = new HashMap<>();
//        向Map集合添加键值对
        m.put(1, "wang");//这里的1会自动装箱，将1的int类型转换成integ类型
        m.put(2, "li");
        m.put(3, "zhao");
        m.put(4, "lin");
//        通过key获取value，返回值类型是value的泛型string
        String name = m.get(3);
        System.out.println(name);
        System.out.println("=========");
//        获取Map集合中键值对的个数
        int index = m.size();
        System.out.println("键值对个数" + index);
//        判断Map集合中元素个数是否为0
        System.out.println("元素个数是否为空" + m.isEmpty());
//        判断Map集合中是否包含某个key
//       contains方法底层调用的都是equals方法进行比对
//        自定义的类型需要重写equals方法。
//        5会自动装箱：int--->Integer
        System.out.println("该集合中是否包含key为5：" + m.containsKey(5));
//        等同于
//        System.out.println("该集合中是否包含key为5："+m.containsKey(new Integer(5)));
//        判断Map集合中是否包含某个value
//        这里的“lin”其实是创建了一个string类型，然后通过equals方法去与集合比对
//        System.out.println("该集合中是否包含value为lin"+m.containsValue(new String("lin")));
        System.out.println("该集合中是否包含value为lin" + m.containsValue("lin"));
//        获取Map集合中所有的value，返回一个collection，上面value的泛型是string类型
        Collection<String> value = m.values();
//        foreach增强for循环
        for (String s : value) {
            System.out.print(s + "");
        }
//        通过key删除键值对
        System.out.println("=====");
        m.remove(4);
        System.out.println(m.size());
//        清空集合中的键值对
        System.out.println("======");
        m.clear();
        System.out.println(m.size());

    }
}
