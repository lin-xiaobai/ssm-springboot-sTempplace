package random;

import java.util.Arrays;
import java.util.Random;

/**
 * @date 2021/3/31 -21:16
 */
public class test04 {
    public static void main(String[] args) {
//        创建数组
        int[] arr = new int[5];
//        为数组全部赋值-1
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
//        定义一个下标0
        int index = 4;
//        创建对象
        Random random = new Random();
        // 计算方法运行的时间,从1970年1月1日到现在系统的时间，毫秒
        long began = System.currentTimeMillis();
//        当下标的数大于arr的长度则退出
        int sum = 0;
        while (index < arr.length && index >= 0) {
//            随机数从0-5
            int num = random.nextInt(6);
            sum++;
            if (!sum(arr, num)) {
                arr[index] = num;
                index--;
            }

        }
        System.out.println(sum + "次");
        long end = System.currentTimeMillis();
        System.out.println((end - began) + "毫秒");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static boolean sum(int[] arr, int num) {
////        使用二分法，先将数组进行升序
        Arrays.sort(arr);
////        如果找不到则返回-1；当找到时，返回的值将》=0；
        return Arrays.binarySearch(arr, num) >= 0;


//        效率较低
////        遍历数组
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i]==num){
//                return true;
//            }
//        }
//        return false;
////
    }
}
