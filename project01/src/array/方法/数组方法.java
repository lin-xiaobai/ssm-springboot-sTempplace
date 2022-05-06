package array.方法;

/**
 * @date 2021/3/18 -13:36
 */
public class 数组方法 {
    public static void main(String[] args) {
//        定义一个int类型的数组，采用静态初始化的方法
        int[] a = {1, 2, 3, 4, 5, 6, 7};
//        定义参数列表为数组的方法
        printfArry(a);
        int[] a2 = new int[5];
        prit02(a2);
//        直接传递一个静态数组的话
        prit02(new int[]{1, 2, 3, 4, 5});
//       prit02(new int[7]);

    }

    public static void printfArry(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("第" + i + "个：" + arr[i]);
        }

    }

    public static void prit02(int[] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}
