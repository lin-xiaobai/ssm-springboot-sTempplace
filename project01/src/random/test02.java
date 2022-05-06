package random;

import java.util.Random;

/**
 * @date 2021/3/21 -18:10
 */
public class test02 {
    public static void main(String[] args) {
//        创建random对象
        Random r1 = new Random();
//        准备一个长度为5的数组
        int[] arr = new int[5];//默认值为0
//        将数组里的值都赋-1；
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
//            打印输出数组中的元素
//            System.out.println(arr[i]);
        }
//        循环，生成随机数
//        定义数组的下标，默认值为0
        int index = 0;
//        当数组下标的值小于数组的长度则退出循环
        while (index < arr.length) {
//            生成随机数
            int num = r1.nextInt(6);//生成【0-5】的随机数
//            判断arr数组中有没有num这个数
//            如果没有则将num放进去
            System.out.println("生成的随机数" + num);
            if (!contains(arr, num)) {
                arr[index++] = num;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 判断数组中的元素是否有与key值相同
     *
     * @param arr
     * @param key
     * @return 如果是true，则代表元素中有与key值相同的
     */

//    定义一个方法判断arr数组中有没有num这个数
    public static boolean contains(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return true;
            }
        }
//        这个代表不包含
        return false;
    }

}
