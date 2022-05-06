package for循环;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @date 2021/4/8 -18:30
 */
public class 集合循环 {
    public static void main(String[] args) {
//        定义一个ArrayList集合，泛型规定为string类型,有序可重复
        List<String> l = new ArrayList<>();
//        添加元素
        l.add("aaa");
        l.add("bbb");
        l.add("ccc");
//        使用迭代器
        Iterator<String> it = l.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("==========");
//        使用下标遍历
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
//        因为list集合的泛型是string类型，所以使用string类型
//        使用增强for循环（foreach）
        for (String l1 : l) {
            System.out.println(l1);
        }
    }
}
