package array.数组扩容;

/**
 * @date 2021/3/18 -16:51
 */
public class 引用数据类型数组扩容 {
    public static void main(String[] args) {
//        定义一个静态初始化的数组
        String[] arg = {"hello", "hh", "call"};
//        定义一个长度为10的动态初始化的数组
        String[] ar = new String[10];
//        拷贝arg数组到ar数组
        System.arraycopy(arg, 0, ar, 0, arg.length);
//        遍历ar数组
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
        System.out.println(ar.length);
    }
}
