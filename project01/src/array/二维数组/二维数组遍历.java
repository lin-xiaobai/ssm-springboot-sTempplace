package array.二维数组;

/**
 * @date 2021/3/18 -18:23
 */
public class 二维数组遍历 {
    public static void main(String[] args) {
//        定义一个int类型的二维数组数组，并且静态初始化
        int[][] arr = {
                {11, 22, 33},
                {12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };
//        遍历二维数组
//        for (int i = 0; i <arr.length ; i++) {
////            负责遍历一维数组
//            int[] a=arr[i];
//            for (int j = 0; j <a.length ; j++) {
//                System.out.print(a[j]+" ");
//            }
//        合并代码
        for (int i = 0; i < arr.length; i++) {
//            arr[i]表示第i个一维数组
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }

//            打印换行
            System.out.println();
        }
    }
}
