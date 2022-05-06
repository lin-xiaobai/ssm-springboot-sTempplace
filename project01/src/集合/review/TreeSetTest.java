package 集合.review;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @date 2021/4/10 -11:26的
 * 测试集合中元素是可排序
 * 测试集合中的存储的类型是自定义的
 * 测试实现Comparable接口方式
 * 测试实现Comparator接口的方式
 * 测试实现匿名内部类的Comparator接口的方式
 */
public class TreeSetTest {
    public static void main(String[] args) {
//        创建集合对象
        TreeSet<b> t = new TreeSet<>();
        t.add(new b(100));
        t.add(new b(0));
        t.add(new b(300));
        for (b b1 : t) {
            System.out.println(b1);
        }
        System.out.println("======");
        TreeSet<b> t1 = new TreeSet<>(new Comparator<b>() {
            @Override
            public int compare(b b, b t1) {

                return t1.num - b.num;
            }
        });
        t1.add(new b(10));
        t1.add(new b(0));
        t1.add(new b(30));
        for (b b2 : t1) {
            System.out.println(b2);
        }
        System.out.println("======");
//        实现自定义比较器
        TreeSet<b> t3 = new TreeSet<>(new bComparator());
        t3.add(new b(110));
        t3.add(new b(01));
        t3.add(new b(301));
        for (b b3 : t3) {
            System.out.println(b3);
        }
    }
}

//class b implements Comparable<b>{
//实现接口
class b implements Comparable<b> {
    int num;

    public b(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "b{" +
                "num=" + num +
                '}';
    }

    @Override
    public int compareTo(b b) {
//        从小到大
        return this.num - b.num;
    }
}

//创建比较器
class bComparator implements Comparator<b> {


    @Override
    public int compare(b b, b t1) {
        return t1.num - b.num;
    }

}