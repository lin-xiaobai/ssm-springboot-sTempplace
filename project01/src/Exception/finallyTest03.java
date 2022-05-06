package Exception;

/**
 * @date 2021/3/22 -19:50
 * 结果为100;
 * 为什么是100而不是101
 * 因为方法是从上到下执行的，
 * ++i是会执行的
 * 它的反编译是
 * 先定义一个变量存储i的值，
 * 再将i的值赋給新定义的变量j
 * 然后++i；
 * 最后return j；
 * 反编码：
 * int j=i；
 * i++；
 * return j
 */
public class finallyTest03 {
    public static void main(String[] args) {

        System.out.println(sun());
    }

    //    定义一个方法
    public static int sun() {
        int i = 100;
        try {
            return i;
        } finally {
            ++i;
        }
    }
}
