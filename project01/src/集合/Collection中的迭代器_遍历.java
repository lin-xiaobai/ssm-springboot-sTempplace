package 集合;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @date 2021/4/5 -16:51
 * 集合遍历、迭代
 * 因为Collection接口在继承了Iterable对象，
 * 所以Collection接口可以使用iterable对象的iterator()方法
 * <p>
 * 只能在所有的Collection以及子类中使用
 * 在Map集合中不能用。
 */
public class Collection中的迭代器_遍历 {
    public static void main(String[] args) {
//        创建一个集合对象
        Collection c = new ArrayList();
//        往集合添加元素
        c.add(120);//自动转箱
        c.add("hello");
        c.add("您好");
//        第一步：获取集合对象的迭代器对象Iterator
        Iterator i = c.iterator();
//        第二步：通过以上获取的迭代器对象开始迭代/遍历集合
//            以下两个方法是迭代器对象Iterator中的方法：
//                boolean hasNext()如果仍有元素可以迭代，则返回true
//                Object next() 返回迭代的下一个元素
        while (i.hasNext()) {
//            不管存进去什么，取出统一都是object
            Object obj = i.next();
//            存进去是什么类型，取出来的还是什么类型
            if (obj instanceof Integer) {
                System.out.println("integer类型");
            }
//            在输出的时候会转变成字符串类型，
//            因为这里的println会调用toString() 方法。
            System.out.println(obj);
        }
        System.out.println("---------------");
//        使用HashSet：无序不可重复
//        创建集合对象，使用多态
        Collection c1 = new HashSet();
//        无序：进去与取出的元素顺序不一样
//        不可重复：元素不能重复
//        添加元素
        c1.add(100);
        c1.add(200);
        c1.add(50);
        c1.add(60);
        c1.add(100);
//        获取迭代器对象
        Iterator i1 = c1.iterator();
//        迭代方式
        while (i1.hasNext()) {
            System.out.println(i1.next());
        }
    }
}
