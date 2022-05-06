package array.二维数组;

/**
 * @date 2021/3/18 -18:34
 */
public class 方法参数列表是二维数组 {
    public static void main(String[] args) {
//        定义一个二维数组，采用动态初始化
//        2个一维数组，1个一维数组2个值,
//        动态初始化从1开始
        int[][] a = new int[2][2];
//        循环二维数组
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
//            打印换行
            System.out.println();
        }
        System.out.println("=============");
//        定义一个静态初始化的二维数组
        int er[][] = {
                {11, 22, 33, 44},
                {22, 33, 44, 55},
                {55, 55},
        };
//        调用方法
        printf(er);
    }

    //    使用static是为了不用new对象
//    定义一个参数列表为二维数组的方法
    public static void printf(int arr[][]) {
//        循环数组
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }
    }
}
