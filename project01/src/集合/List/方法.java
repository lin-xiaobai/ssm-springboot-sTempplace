package 集合.List;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @date 2021/4/7 -18:32
 */
public class 方法 {
    public static void main(String[] args) {
//        创建list（接口）集合
        List mList = new ArrayList();
//        添加元素
//        默认都是向集合末尾添加元素
        mList.add("a");
        mList.add("b");
        mList.add("c");

//        在指定位置上添加元素，第一个参数是下标,效率低
        mList.add(1, "new");
//        迭代
        Iterator it = mList.iterator();
        while (it.hasNext()) {
            Object o = it.next();
//            使用迭代器对象删除元素，自动更新集合结构
//            it.remove();
            System.out.println(o);

        }
//        打印集合的个数
        System.out.println(mList.size());
//        获取下标为0的元素
        Object fist = mList.get(0);
        System.out.println(fist);
//        list独特的遍历方法
        for (int i = 0; i < mList.size(); i++) {
            Object o = mList.get(i);
            System.out.println("list独特的遍历方法" + i + o);
        }
        System.out.println("=====");
//        修改集合中的元素
        mList.set(1, "king");
        for (int i = 0; i < mList.size(); i++) {
            Object o = mList.get(i);
            System.out.println("list独特的遍历方法" + i + o);
        }
//        查看集合中指定的元素在集合出现第一次的下标
        Object o = mList.indexOf("a");
        System.out.println(o);
        // 查看集合中指定的元素在集合出现在最后一次的下标
        Object o1 = mList.lastIndexOf("king");
        System.out.println(o1);
//        删除集合中指定的下标的元素
        Object o3 = mList.remove(2);
        System.out.println(mList.get(2));
    }

}
