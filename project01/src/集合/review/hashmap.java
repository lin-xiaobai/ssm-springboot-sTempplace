package 集合.review;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @date 2021/4/10 -11:53
 */
public class hashmap {
    public static void main(String[] args) {
//        创建集合
        HashMap<Integer, String> h = new HashMap<>();
//        添加元素
        h.put(1, "zhang");
        h.put(1, "lin");//key相同，会覆盖value
        h.put(2, "li");
        h.put(3, "liu");
        h.put(4, "zhang");
        h.put(5, "li");
        System.out.println(h.size());
//        遍历集合
//        第一种方式：获取所有的key，遍历key的时候，通过key获取value
        Set<Integer> s = h.keySet();
        for (Integer i : s) {
            System.out.println(s + "-----" + h.get(i));
        }

//        第二种：将map集合转换成set集合，set集合中的每一个元素都是node元素
//        这个node节点有key和value
        Set<Map.Entry<Integer, String>> s1 = h.entrySet();
        for (Map.Entry<Integer, String> me : s1) {
            System.out.println(me.getKey() + ":" + me.getValue());
        }
    }
}
