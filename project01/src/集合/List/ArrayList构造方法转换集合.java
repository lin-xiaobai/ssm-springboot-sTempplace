package 集合.List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Size方法是集合的元素个数，不能用来查询元素的容量
 *
 * @date 2021/4/7 -20:17
 */
public class ArrayList构造方法转换集合 {
    public static void main(String[] args) {
//        默认初始化容量10
        List l = new ArrayList();
//        指定初始化容量20；
        List l1 = new ArrayList(20);
//        创建一个HashSet集合
        Collection c1 = new HashSet();
//        添加元素
        c1.add(100);
        c1.add(200);
        c1.add(300);
//        通过构造方法将HashSet集合转换成List集合
//        参数为集合对象引用
//        Size方法是集合的元素个数，不能用来查询元素的容量
        List l2 = new ArrayList(c1);
        for (int i = 0; i < l2.size(); i++) {
            System.out.println(l2.get(i));
        }

    }
}
