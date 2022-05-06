package 集合.Set;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 2021/4/8 -18:43
 * HashSet集合：无序不可重复
 * 1.存储时候顺序和取出的顺序不同
 * //        2.元素不可重复
 * //        3.放到HashSet集合中的元素实际上是放到HashMap集合中的key部分了1
 */
public class test {
    public static void main(String[] args) {
//        定义一个HashSet集合，泛型为intege类型
        Set<Integer> s1 = new HashSet<>();
        s1.add(200);
        s1.add(200);
        s1.add(100);
        s1.add(100);
        s1.add(100);
        s1.add(100);
        s1.add(100);
        s1.add(200);
        s1.add(200);
        s1.add(300);
//        1.存储时候顺序和取出的顺序不同
//        2.元素不可重复
//        3.放到HashSet集合中的元素实际上是放到HashMap集合中的key部分了1
//        使用增强for循环（foreach），没有下标
        for (Integer i : s1) {
//            自动转换int类型
            System.out.println(i + 1);
        }

    }
}
