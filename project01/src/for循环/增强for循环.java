package for循环;

/**
 * @date 2021/4/8 -18:23
 * 增强for循环或者foreach
 * 语法：
 * for(元素类型  变量名：数组或集合）
 */
public class 增强for循环 {
    public static void main(String[] args) {
//        定义一个数组
        int[] arr = {111, 120, 130, 144};
//        普通循环
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//        使用增强for循环（foreach）
        for (int index : arr) {
            System.out.println(index);
        }

    }
}
