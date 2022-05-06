package 集合.Set.TreeSet中自定义类型排序;

import java.util.TreeSet;

/**
 * @date 2021/4/9 -18:20
 * 按年龄升序，如果年龄相同按姓名升序
 */
public class 案例 {
    public static void main(String[] args) {
//        创建集合
        TreeSet<vip> t = new TreeSet<>();
        t.add(new vip(10, "linz"));
        t.add(new vip(11, "lina"));
        t.add(new vip(10, "linb"));
        for (vip v : t) {
            System.out.println(v);
        }
    }
}

class vip implements Comparable<vip> {
    int age;
    String name;

    public vip(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "vip{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(vip vip) {
//        年龄相同按照名字排序
//        姓名与string类型，可以直接比，调用compareTo来完成比较
        if (this.age == vip.age) {
            return this.name.compareTo(vip.name);

        } else {
//            年龄不一样
            return this.age - vip.age;
        }
    }
}