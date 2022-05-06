package 包装类Integer;

/**
 * @date 2021/3/30 -17:26
 * 网页上文本框中输入的100实际上是“100”字符串。后台数据库中要求存储100数字，此时java程序需要将“100”转换成数字100。
 */
public class 字符串转换成基本类型 {
    public static void main(String[] args) {
//        创建一个integer类型，创建一个int对象
        //传参是一个字符串
        //将字符串类型转换成基本数据类型
//       String --> int
        int i = Integer.parseInt("123");
        System.out.println(i + 123);

        double b = Double.parseDouble("123.00");
        System.out.println(b + 123);

        String num = "234.0";
        float f = Float.parseFloat(num);
        System.out.println(f * 2);


    }
}
