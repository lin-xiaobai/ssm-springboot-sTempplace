package 集合;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @date 2021/4/5 -16:13
 * 集合中不能直接存储基本数据类型，也不能存java对象，
 * 只能存储java对象的内存地址。
 */
public class Collection中的方法 {
    public static void main(String[] args) {
        //    创建一个集合对象
//    Collection是一个接口，无法实例化（new对象）
//    多态：父类型的引用指向子类型的对象
        Collection c = new ArrayList();
//    向集合添加元素
//        1200是一个对象的内存地址
        c.add(1200);//自动装箱
//        创建对象
        c.add(new student());

//        获取集合中元素个数
        System.out.println("个数" + c.size());
//        清空集合中的元素
        c.clear();
        System.out.println("个数" + c.size());

//        添加元素
        c.add(100);
        c.add("小明");
        c.add(true);
        c.add(new student());
//        判断集合中是否包含元素；返回值是true或者false
        System.out.println(c.contains(true));
        System.out.println(c.contains("xiao"));
//        删除集合中指定的元素
        c.remove(100);
        System.out.println("个数" + c.size());
//        判断集合中元素是否为空
        System.out.println(c.isEmpty());
        System.out.println("------------------------");
//        将集合转换成数组
//        创建数组接受集合中元素
        Object[] obj = c.toArray();
        for (int i = 0; i < obj.length; i++) {
//            已经重写了toString方法
//            System.out.println(obj[i].toString());
            System.out.println(obj[i]);
        }
    }


}

class student {

}