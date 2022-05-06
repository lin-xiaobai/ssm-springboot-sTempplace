package String;

/**
 * @date 2021/3/30 -15:38
 * 字符串不可变意思是双引号里面的字符串对象(abc)一旦创建不可变。
 * 但是s变量可以指向其它对象的
 */
public class 字符串对象不可变 {
    public static void main(String[] args) {
//        abc是一个字符串对象
//        name是一个变量
        String name = "abc";
        System.out.println(name);
        name = "xyz";
        System.out.println(name);
    }
}
