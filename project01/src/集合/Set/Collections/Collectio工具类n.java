package 集合.Set.Collections;

import java.util.*;

/**
 * @date 2021/4/9 -20:56
 * java.util.Collection  集合接口
 * java.util.Collections  集合工具类，方便集合的操作
 * <p>
 * Collections.sort中需要传进一个list集合
 */
public class Collectio工具类n {
    public static void main(String[] args) {
//        创建一个集合对象,有序可重复
        List<String> list = new ArrayList<>();
//        ArrayList集合不是线程安全的
//        将线程变成线程安全的
        Collections.synchronizedList(list);
//        排序
        list.add("abg");
        list.add("abd");
        list.add("abz");
        list.add("abe");
        list.add("abe");
        list.add("abj");
        Collections.sort(list);
//        遍历集合
        for (String s : list) {
            System.out.println(s);
        }
//        创建一个set集合（无序不可重复）
        Set<String> set = new HashSet<>();
        set.add("king");
        set.add("king");
        set.add("kings");
        set.add("kingz");
        set.add("kinga");
//        排序
//        将set集合转换成list集合
//        创建一个list集合，将set对象放到构造方法的参数上
        List<String> l1 = new ArrayList<>(set);
//        Collections.sort的参数是list集合
        Collections.sort(l1);
        for (String s1 : l1) {
            System.out.println(s1);
        }
        System.out.println("========");
//        创建一个set集合
        Set<wugui3> s = new HashSet<>();
        s.add(new wugui3(100));
        s.add(new wugui3(20));
        s.add(new wugui3(50));
        s.add(new wugui3(60));
//        set集合转换成list集合
        List<wugui3> l2 = new ArrayList<>(s);
        Collections.sort(l2);
        for (wugui3 w : l2) {
            System.out.println(w);
        }
    }
}

class wugui3 implements Comparable<wugui3> {
    int age;

    public wugui3(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(wugui3 wugui3) {
        return this.age - wugui3.age;
    }

    @Override
    public String toString() {
        return "wugui3{" +
                "age=" + age +
                '}';
    }
}