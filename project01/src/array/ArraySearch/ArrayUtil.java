package array.ArraySearch;

/**
 * @date 2021/3/20 -11:07
 */
public class ArrayUtil {
    public static void main(String[] args) {
        //    定义一个数组，采用静态初始化
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = binarySearch(arr, 10);
        System.out.println(index == -1 ? "该元素不存在" : arr[index] + "在下标为" + index);
    }

    /**
     * 定义一个二分法的方法查找元素
     *
     * @param arr        被查询的数组（已排序）
     * @param dest被查找的元素
     * @return返回-1表示不存在，返回大于或等于0的值表示数组的下标
     */
//定义一个二分法的方法查找元素,
    public static int binarySearch(int[] arr, int dest) {
//    定义一个开始的下标
        int begin = 0;
//    定义一个结束的下标
        int end = arr.length - 1;
//    调用方法

//    定义一个中间位置的下标
//        开始元素的下标只要在结束元素下标的左边，就有机会继续循环。
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (arr[mid] == dest) {
                return mid;
            } else if (arr[mid] < dest) {
//                目标在“中间”的右边
//                开始元素下标需要发生变化（开始元素的下标需要重写赋值）
                begin = mid + 1;
            } else {
//                arr[mid]>dest
//                目标在“中间”的左边
//                修改结束元素的下标
                end = mid - 1;
            }

        }

        return -1;

    }

}
