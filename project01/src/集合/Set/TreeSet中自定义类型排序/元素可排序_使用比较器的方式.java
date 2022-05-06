package 集合.Set.TreeSet中自定义类型排序;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @date 2021/4/9 -19:20
 * 使用比较器的方式
 */
public class 元素可排序_使用比较器的方式 {
    public static void main(String[] args) {
//        创建TreeSet集合的时候，需要使用这个比较器
//       通过构造方法传递一个比较器进去
//        TreeSet<wugui> t=new TreeSet<>(new wuguiComparable());
//        使用匿名内部类的方式
        TreeSet<wugui> t = new TreeSet<>(new Comparator<wugui>() {
            @Override
            public int compare(wugui wugui, wugui t1) {
                return wugui.age - t1.age;
            }
        });
        t.add(new wugui(100));

        t.add(new wugui(120));
        t.add(new wugui(130));
        for (wugui w : t) {
            System.out.println(w);
        }
    }
}

class wugui {
    int age;

    public wugui(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "小乌龟{" +
                "age=" + age +
                '}';
    }
}
////单独定义一个比较器
//class wuguiComparable implements Comparator<wugui>{
//    @Override
//    public int compare(wugui t1, wugui t2) {
////        按年龄比较
//        return t1.age-t2.age;
//    }
//}