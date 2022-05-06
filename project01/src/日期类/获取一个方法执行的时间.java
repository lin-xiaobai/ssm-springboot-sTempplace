package 日期类;

/**
 * @date 2021/3/31 -19:56
 * 获取自1970年1月1日00:00:00 00到当前系统时间的总毫秒数
 */
public class 获取一个方法执行的时间 {
    public static void main(String[] args) {
//        获取自1970年1月1日00:00:00 00到当前系统时间的总毫秒数
//        返回值类型是long
        long time = System.currentTimeMillis();
        System.out.println(time);
//        调用sum方法
//        获取方法的运行时间
//        运行前的时间
        long began = System.currentTimeMillis();
        sum();
//        运行后的时间
        long end = System.currentTimeMillis();
        System.out.println("方法运行的时间" + (end - began) + "毫秒");
    }

    public static void sum() {
        int sum = 0;
        for (int i = 0; i < 10000000; i++) {
            sum += i;
//            System.out.println(i);
        }
    }
}
