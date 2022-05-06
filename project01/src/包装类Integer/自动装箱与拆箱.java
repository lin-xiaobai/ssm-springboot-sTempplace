package 包装类Integer;

/**
 * @date 2021/3/29 -17:28
 */
public class 自动装箱与拆箱 {
    public static void main(String[] args) {
//        自动装箱
//        int类型---自动转换为-->Integer
        Integer i = 200;
//        自动拆箱
//        integer类型-->自动转换为int类型
        int y = i;
        System.out.println(y);
        Double d = 10.0;
        double d2 = d;
        System.out.println(d2);
        Integer i2 = new Integer(20);
        double b = i2.doubleValue();
        System.out.println(b);

    }
}
