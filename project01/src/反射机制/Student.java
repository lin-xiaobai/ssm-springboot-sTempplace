package 反射机制;

/**
 * @date 2021/4/16 -19:25
 */
public class Student {
//    field翻译为字段，其实就是属性
//    4个field，分别采用了不同的访问控制权限修饰符

    private String name;
    protected int age;
    boolean sex;
    public int no;
    public final static double MATH = 3.1415926;


    public boolean chiek(String name, String pwd) {
        if ("ab".equals(name) && ("pwd".equals(pwd))) {
            return true;
        }
        return false;
    }

    public int sun(int num1, int num2) {
        return num1 + num2;
    }
}
