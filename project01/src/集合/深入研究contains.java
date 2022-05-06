package 集合;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @date 2021/4/5 -17:59
 * boolean  contains(Object o)
 * 判断集合中是否包含某个对象o
 * 如果包含返回true，如果不包含返回false。
 * <p>
 * contains方法是用来判断集合中是否包含某个元素的方法。
 */
public class 深入研究contains {
    public static void main(String[] args) {
//        创建集合对象
        Collection c = new ArrayList();
        c.add(120);//自动装箱
        c.add(new String("abc"));
        c.add(new String("ad"));
//        调用迭代方法
        Iterator it = c.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        String x = new String("abc");

//        底层调用了equals()方法;
//        判断的是集合中是否包含某个元素的方法
        System.out.println(c.contains(x));

//        创建集合和对象
        Collection c2 = new ArrayList();
        stu s1 = new stu("jack");
        stu s2 = new stu("miak");

        c2.add(s1);
        c2.add(s2);

        stu s3 = new stu("jack");
        c2.remove(s3);
        System.out.println("个数" + c2.size());
        Iterator it1 = c2.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }
    }

}

class stu {
    private String name;

    public stu(String name) {
        this.name = name;
    }

    //        重写equals
    public boolean equals(Object o) {
        if (o == null || !(o instanceof stu)) return false;
        if (o == this) return true;
//            强转
        stu s = (stu) o;
        return s.name.equals(this.name);
    }

    @Override
    public String toString() {
        return "stu{" +
                "name='" + name + '\'' +
                '}';
    }
}

