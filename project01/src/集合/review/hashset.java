package 集合.review;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * @date 2021/4/10 -11:09
 * 存储在hashmap集合key的元素需要同时重写hashCode和equals
 * hashset等同于存储在hashmap的key部分
 */
public class hashset {
    public static void main(String[] args) {
//        创建set对象
        Set<stu> stus = new HashSet<>();
        stus.add(new stu(12, "zhang"));
        stus.add(new stu(13, "libai"));
        stus.add(new stu(14, "mo"));
//        迭代器遍历
        Iterator<stu> it = stus.iterator();
        while (it.hasNext()) {
            stu s = it.next();
            System.out.println(s);
        }
//        测试无序不可重复
        stus.add(new stu(14, "mo"));
        System.out.println(stus.size());
    }
}

class stu {
    int no;
    String name;

    public stu(int no, String name) {
        this.no = no;
        this.name = name;
    }
//    需要重写hashCode和equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        stu stu = (stu) o;
        return no == stu.no &&
                Objects.equals(name, stu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, name);
    }

    @Override
    public String toString() {
        return "stu{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}