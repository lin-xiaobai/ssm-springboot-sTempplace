package array.ArraySearch;

import java.util.Arrays;

/**
 * @date 2021/3/20 -10:49
 */
public class 普通方法 {
    public static void main(String[] args) {
//        定义一个一维数组，使用静态初始化
        int arr[] = {1, 5, 8, 3, 6};
//        对一维数组进行排序
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
//        调用方法,定义一个int类型的整数接受从方法中返回的值
        int index = arraySearch(arr, 6);
        System.out.println(index == -1 ? "该元素不存在" : arr[index] + "该元素位置在下标" + index);
    }

    /**
     * 从数组中检索某个元素的下标
     *
     * @param arr被检索的数组
     * @param ele被检索的元素
     * @return大于等于0的数表示元素的下标，-1表示该元素不存在
     */
    //    定义一个查找元素的方法，并且对方法进行封装
    public static int arraySearch(int[] arr, int ele) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele) {
                return i;
            }
        }
//        -1表示不存在
        return -1;
    }
}


