package 集合.Set.TreeSet中自定义类型排序;

import java.util.TreeSet;

/**
 * @date 2021/4/9 -17:52
 */
public class TreeSet中自定义comparable接口 {
    public static void main(String[] args) {
//        创建对象
        userss u1 = new userss(28);
        userss u2 = new userss(25);
        userss u3 = new userss(24);
        userss u4 = new userss(29);
//        创建集合对象
        TreeSet<userss> t = new TreeSet<>();
        t.add(u1);
        t.add(u2);
        t.add(u3);
        t.add(u4);
//        在这里报错，因为TreeSet中的泛型没有定义比较规则
        for (userss u : t) {
            System.out.println(u);
        }
    }
}

//需要实现comparable接口，并且实现compareTo方法，equals方法可以不用谢
//k.compareTo(t.key)
//拿着参数k和集合中的每一个k进行比较，返回值可能是>0,<0,=0
//比较规则由程序员指定:例如年龄的降序
class userss implements Comparable<userss> {
    int age;

    public userss(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(userss user) {
        return user.age - this.age;
    }

    @Override
    public String toString() {
        return "users{" +
                "age=" + age +
                '}';
    }
}
