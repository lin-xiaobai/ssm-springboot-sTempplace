package 反射机制;

/**
 * @date 2021/4/18 -10:26
 */
public class 通过反射获取父类名字和接口 {
    public static void main(String[] args) throws Exception {
//        获取string类型接口
        Class stringClass = Class.forName("java.lang.String");
//        获取父类的名字
        Class name = stringClass.getSuperclass();
        System.out.println(name.getName());

//        获取string的接口
        Class[] classes = stringClass.getInterfaces();
        for (Class c : classes) {

            System.out.println("父类接口" + c.getName());
        }
    }

}
