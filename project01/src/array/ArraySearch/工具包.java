package array.ArraySearch;

import java.util.Arrays;

/**
 * @date 2021/3/20 -12:07
 */
public class 工具包 {
    public static void main(String[] args) {
//        定义一个数组，采用静态初始化的方法
        int[] arr = {1, 2, 5, 6, 5, 2, 0, 2, 3, 5,};
//        调用java中数组类中的排序方法
        Arrays.sort(arr);
//        对数组遍历，并且打印输出
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
//        查找arr数组中5的下标位置
//        定义一个int整数获取从方法传来的index下标位置
        int index = Arrays.binarySearch(arr, 5);
//        -1表示不存在
        System.out.println(index == -1 ? "该元素不存在" : "该元素的下标" + index);

        System.out.println(arr[index + 2]);
    }

}
