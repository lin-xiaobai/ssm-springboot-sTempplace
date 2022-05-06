package 包装类Integer;

/**
 * @date 2021/3/30 -16:02
 */
public class test01 {
    public static void main(String[] args) {
//        自动装箱，这里相当于new一个对象
        Integer a = 10;// 相当于Integer i=new Integer(10);
//        这里相当于自动拆箱（+-*/）
        System.out.println(a + 10);
//        创建一个int包装类
        Integer i = 11;
//        这里相当与比较两个对象的内存地址

        System.out.println(i == a);
    }
}
