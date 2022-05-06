package 集合;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @date 2021/4/6 -17:55
 * 重点:当集合结构发生了改变，迭代器没有重新获取时，如果还是用以前的迭代器时，会出现异常
 * java.util.ConcurrentModificationException
 * 重点：在迭代元素的过程当中，一定要使用迭代器Iterator的remove方法，删除元素，
 * 不要使用集合自带的remove方法删除元素。
 */
public class 迭代器 {
    public static void main(String[] args) {
//        创建集合对象
        Collection c = new ArrayList();
//        添加元素
//        java.util.ConcurrentModificationException
//        此时获取的迭代器，指向的是那集合中没有元素状态下的迭代器
//        当集合结构发生了改变，迭代器没有重新获取时，调用next()方法时，会报错
//        Iterator it=c.iterator();
        c.add(120);//自动装箱
        c.add(50);
        c.add("text");
//        对集合进行遍历、迭代
        Iterator it = c.iterator();
//        hasNext()返回值是boolean值
        while (it.hasNext()) {
            Object obj = it.next();
//            使用集合对象引用去删除集合元素，会报出异常
//            c.remove(obj);
//            原因：集合中的元素删除了，但是没有更新迭代器（迭代器不知道集合变化了
//
//
//            使用迭代删除元素时，会自动更新迭代器，并且更新集合
//            （删除集合中的元素）
            it.remove();
            System.out.println(obj);
        }
        System.out.println(c.size());
    }
}
