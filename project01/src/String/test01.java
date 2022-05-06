package String;

/**
 * @date 2021/3/20 -15:47
 */
public class test01 {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        System.out.println(a == b);
//        "双等号"比较的是变量中保存的地址
        String c = new String("xyz");
        String d = new String("xz");
        System.out.println(c == d);
        System.out.println(c.equals(d));

        String k = "test";
//        这样写可以避免空指针异常
        System.out.println("test".equals(k));
        String k1 = null;
        System.out.println("test".equals(k1));
        System.out.println(k1.equals("test"));
    }
}
