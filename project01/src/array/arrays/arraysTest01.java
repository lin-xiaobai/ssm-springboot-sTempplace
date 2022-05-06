package array.arrays;

import java.util.Arrays;

/**
 * @date 2021/3/19 -17:16
 */
public class arraysTest01 {
    public static void main(String[] args) {
//        定义一个数组，采用静态赋值
        int[] a = {1, 3, 2, 520, 120, 325, 22};
//        调用Arrays的工具类对数组a进行排序
        Arrays.sort(a);
//        循环遍历
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
