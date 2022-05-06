package 静态内部类;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 2021/4/8 -20:08
 */
public class 静态内部类的集合 {
    //    定义一个静态内部类
    private static class m1 {
//        定义一个map集合

    }

    public static void main(String[] args) {
//        调用静态内部类的集合对象
//       Set集合中存储的是 静态内部类的集合.m1类型
        Set<静态内部类的集合.m1> s1 = new HashSet<>();

        Set<mymap.myentry<Integer, String>> s2 = new HashSet<>();
    }
}

class mymap {
    public static class myentry<k, v> {

    }
}

