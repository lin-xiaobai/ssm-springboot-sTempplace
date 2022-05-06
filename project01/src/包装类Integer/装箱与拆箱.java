package 包装类Integer;

/**
 * @date 2021/3/29 -17:00
 * 基本数据类型---（转换为）--->引用数据类型
 */
public class 装箱与拆箱 {
    public static void main(String[] args) {
        //将基本类型转换为引用数据类型
        Integer i = new Integer(123);
//        将引用类型转换为基本数据类型
        float f = i.floatValue();
        System.out.println(f);
        Integer in = i.intValue();
        System.out.println(in);

//        将string类型的数字，转换成integer包装类型。（string---->int)
        Integer x = new Integer("124");
        double d = x.doubleValue();
        System.out.println(d);

        Byte b = new Byte((byte) 'a');
        int d1 = b.intValue();
        System.out.println(d1);

        System.out.println("获取int最小值" + Integer.MIN_VALUE);
        System.out.println("获取int最大值" + Integer.MAX_VALUE);
        System.out.println("byte最小值" + Byte.MAX_VALUE);
        System.out.println("byte最大值" + Byte.MIN_VALUE);
    }
}
