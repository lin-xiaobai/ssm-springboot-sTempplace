package array.二维数组;

/**
 * @date 2021/3/18 -18:12
 */
public class 二维数组的读改 {

    public static void main(String[] args) {
        //    定义一个int类型的二维数组，并且采用静态初始化
        int[][] arr = {
                {100, 120, 100},
                {1203, 150, 200, 0},
                {1, 2, 3}
        };
//        读arr二维数组中的第1个一位数组中的3个值
        System.out.println(arr[0][2]);
//        改
        arr[2][1] = 1006;
        System.out.println(arr[2][1]);

    }

}
