package array;

/**
 * @date 2021/3/17 -23:12
 */
public class test01 {
    public static void main(String[] args) {
//        定义一个int类型的静态一维数组
        int[] arr = {100, 120, 1002, 200};
        System.out.println(arr.length);
        System.out.println(arr[0]);
        System.out.println(arr[arr.length - 1]);

        arr[0] = 10;
        System.out.println(arr[0]);
        System.out.println(arr[arr.length - 1]);

        for (int i = 0; i < arr.length; i++) {
            System.out.println("第" + (i + 1) + arr[i]);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println("颠倒" + i + arr[i]);
        }
        System.out.println(arr[10]);
    }
}
