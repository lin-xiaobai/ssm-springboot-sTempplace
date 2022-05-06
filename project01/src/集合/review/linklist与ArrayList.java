package 集合.review;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @date 2021/4/10 -10:50
 * 1。集合对象的创建（new）
 * 2.向集合添加元素
 * 3.从集合取出元素
 * 4.变量集合
 */
public class linklist与ArrayList {
    public static void main(String[] args) {
//        创建集合对象，泛型是string类型
        List<String> list = new ArrayList<>();
//        添加元素,下标从0开始
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
//        获取集合的某个元素
        System.out.println(list.get(3));
//        使用下标遍历循环（list特有）
        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//            将字符串改成int类型
            int num = Integer.valueOf(list.get(i));
            System.out.println(num + 1);
        }
//        将迭代器循环
        for (Iterator<String> it1 = list.iterator(); it1.hasNext(); ) {
            System.out.println(it1.next());
        }
//        迭代器迭代
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
//        foreach
        for (String s : list) {
            System.out.println(s);
        }
    }
}
