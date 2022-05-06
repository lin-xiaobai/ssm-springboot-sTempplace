package array;

/**
 * @date 2021/3/17 -23:39
 */
public class test02 {
    public static void main(String[] args) {
//        定义一个长度为3的数组，采用动态初始化的方式
        int[] arr = new int[4];
        arr[0] = 10;
        arr[1] = 20;
        arr[3] = 25;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("第" + i + "个：" + arr[i]);
        }

//        定义一个引用类型的数组，采用动态初始化的方式
//        Object[] obj2={new Object(),new Object(),new Object()};
        Object obj2 = new Object();
        Object obj3 = new Object();
        Object obj4 = new Object();
        Object[] obj5 = {obj2, obj3, obj4};
        for (int i = 0; i < obj5.length; i++) {
            System.out.println("第" + i + "个：" + obj5[i]);
        }
    }
}
