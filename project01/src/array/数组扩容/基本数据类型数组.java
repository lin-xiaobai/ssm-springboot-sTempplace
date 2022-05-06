package array.数组扩容;

/**
 * @date 2021/3/18 -16:29
 */
public class 基本数据类型数组 {
    public static void main(String[] args) {
//        定义一个静态初始化方法的基本数据类型
        int[] ars = {1, 2, 3, 4, 5};
//        定义一个长度为10的动态初始化方法的基本数据类型,默认值为0
        int[] ar = new int[20];
//        将ars数组扩容到ar数组中
//        第一个参数为源数组，第二参数为源数组的第n个索引，
//        第三个参数为目标数组，第四参数为目标数组的第n个索引，
//        第五个参数为拷贝数组元素的长度
//        意思是将数组ars拷贝索引为3-6的值到数组ar索引为5
        System.arraycopy(ars, 1, ar, 5, 3);
//        循环拷贝过去的数组ar
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }

        System.out.println(ar.length);
        System.out.println("============");
//        将ars数组中所有的值拷贝到ar数组中
        System.arraycopy(ars, 0, ar, 2, ars.length);
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
    }
}
