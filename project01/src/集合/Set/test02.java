package 集合.Set;

import java.util.Set;
import java.util.TreeSet;

/**
 * @date 2021/4/8 -19:22
 * TreeSet集合<>()
 * 无序不可重复，但是存储的元素可以自动从小到大排序
 * 称为可排序集合
 * <p>
 * 无序：存进去和取出来的顺序不同，并且没有下标
 */
public class test02 {
    public static void main(String[] args) {
//        创建集合对象
        Set<String> s1 = new TreeSet<>();
//        添加元素
        s1.add("k");
        s1.add("a");
        s1.add("b");
        s1.add("a");
        s1.add("z");
        s1.add("z");
//        foreach循环集合
        for (String s : s1) {
            System.out.println(s);
        }
    }
}
