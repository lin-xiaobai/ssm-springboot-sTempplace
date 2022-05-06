package 集合.Set;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @date 2021/4/9 -16:53
 * 底层实际上是一个TreeMap
 * 是一个二叉树
 * 放到TreeSet集合的元素，等同于放到TreeMap集合的key部分。
 * 是一个无序不可重复，但是可以按照元素大小顺序自动排序
 */
public class TreeSet集合 {
    public static void main(String[] args) {
//        创建TreeSet集合
        TreeSet<String> t = new TreeSet<>();
//        添加元素，会自动排序
        t.add("name");
        t.add("abc");
        t.add("btf");
//        特点：没有下标
        for (String s : t) {
            System.out.println(s);
        }
        TreeSet<Integer> t1 = new TreeSet<>();
        t1.add(1);//自动装箱
//        等同于
        t1.add(new Integer(10));
        t1.add(0);
        t1.add(10);
//        使用迭代器
        Iterator<Integer> it = t1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

}
