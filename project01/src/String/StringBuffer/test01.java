package String.StringBuffer;

/**
 * @date 2021/3/21 -16:46
 */
public class test01 {
    public static void main(String[] args) {
//        字符串拼接尽可能使用StringBuffer类中的append方法[字符串缓冲区）
//        因为string的byte数组长度是不可变的
//        创建一个stringBuffer对象,默认16个byte[] 数组
//        append方法底层在进行追加的时候，如果byte数组满了，会自动扩容。
//        线程安全的
//        StringBuilder线程不安全的
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hellow");
        stringBuffer.append("rok");
        stringBuffer.append(true);
        stringBuffer.append(3.14);
        stringBuffer.append('a');
//        打印输出
        System.out.println(stringBuffer);
        System.out.println("=============");
//        创建一个stringBuffer对象,手动赋值100个byte[] 数组
        StringBuffer s1 = new StringBuffer(100);
        s1.append("hellowr");
        s1.append("rok");
        s1.append(true);
        s1.append(3.14);
        s1.append('a');
//        打印输出
        System.out.println(s1);

    }
}
