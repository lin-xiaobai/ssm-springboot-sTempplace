package 集合.Map接口;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @date 2021/4/8 -21:07
 * //        使用Set<Map.Entry<k,v>> entrySet()方法
 * 遍历集合
 */
public class 第二种遍历方法 {
    public static void main(String[] args) {
//        定义一个map集合，泛型为string类型和integer类型
        Map<Integer, String> m = new HashMap<>();
//        添加元素
        m.put(1, "zhang");
        m.put(2, "li");
        m.put(3, "zhao");
        m.put(4, "lin");
        m.put(5, "lin");
//        使用Set<Map.Entry<k,v>> entrySet()方法
        Set<Map.Entry<Integer, String>> set = m.entrySet();
//        set引用中包含了key的值和value的值
//        使用迭代器，规定泛型
//       Iterator<Map.Entry<Integer,String>> it=set.iterator();
//        while (it.hasNext()){
////
//            Map.Entry<Integer,String> node=it.next();
////            获取集合中的key值和value值
//            Integer i1=node.getKey();
//            String vaue=node.getValue();
//            System.out.println(i1+":"+vaue);
//        }
//        使用foreach循环增强:效率比较高
//        因为获取的key和value都是直接从node对象中获取的属性值
//        比较适合大数据量
        for (Map.Entry<Integer, String> node : set) {
//            Integer integer=me.getKey();
//            String s=me.getValue();
            System.out.println(node.getKey() + "::" + node.getValue());
        }
    }
}
