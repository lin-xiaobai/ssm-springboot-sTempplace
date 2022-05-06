package array.数组扩容;

/**
 * @date 2021/3/18 -16:57
 */
public class 对象数组扩容 {
    public static void main(String[] args) {
//        创建object类的对象，并且用obj1，obj2，obj3变量存储他们的内存地址
//        Object obj1=new Object();
//        Object obj2=new Object();
//        Object obj3=new Object();
////        定义一个数组,采用静态初始化的方法
//        Object[] o={obj1,obj2,obj3};
//      代码合并
        Object[] o = {new Object(), new Object(), new Object()};
//        创建一个长度为10的数组
        Object[] o2 = new Object[10];
//        将数组o拷贝到o2数组中
        System.arraycopy(o, 0, o2, 0, o.length);
//        循环数组o2
        for (int i = 0; i < o2.length; i++) {
//            默认添加一个toString的方法
            System.out.println(o2[i]);
        }
        System.out.println(o2.length);
    }
}
