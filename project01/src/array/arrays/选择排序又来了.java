package array.arrays;

/**
 * @date 2021/3/19 -18:42
 */
public class 选择排序又来了 {
    public static void main(String[] args) {
//        定义一个静态初始化的数组
        int[] arr = {11, 10, 2, 3, 0};
        int count = 0;
        int count2 = 0;
//            选择排序
//        5条数据循环4次。（外层循环4次）
        for (int i = 0; i < arr.length - 1; i++) {
//            i的值是0,1,2,3
//            i正好是“参加比较的这堆数据中”最左边那个元素的下标
//            i是一个参与比较的这堆数据中的起点下标
//            假设起点i下标位置上的元素是最小的
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                count2++;
                if (arr[j] < arr[min]) {
                    min = j;//最小值的元素下标是j
                }
            }
//            当i和min相等时，表示最初猜测是对的
//            当i和min不相等时，表示最初猜测是错的，有比这个元素更小的元素
//                需要拿着这个更小的元素和最左边的元素交换位置
            if (min != i) {
//                表示存在更小的数据
//                        arr[min]最小的数据
//                        arr[i]最前面的数据
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
                count++;
            }
        }
        System.out.println("交换次数：" + count);
        System.out.println("循环次数：" + count2);
        //        循环数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
