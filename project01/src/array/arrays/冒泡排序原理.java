package array.arrays;

import java.util.Arrays;

/**
 * @date 2021/3/19 -18:03
 */
public class 冒泡排序原理 {
    public static void main(String[] args) {
        //    定义一个数组，采用静态赋值
        int[] arr = {12, 1, 2, 5, 8, 0};
        int[] arr2 = {12, 1, 2};
//        采用java中定义好的方法
        Arrays.sort(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

//        查询循环次数
        int count = 0;
//        外层循环采用倒序
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
//                count++;
//                假设2只手都着拿东西，想要互换手里东西，必须有个盒子暂时存放一个东西，再互换，
//                类似于三角
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
//        System.out.println(count);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
