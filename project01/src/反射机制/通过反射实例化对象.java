package 反射机制;

/**
 * @date 2021/4/15 -21:29
 * 获取Class，能干什么
 * 通过Class的newInstance（）方法来实例化对象
 * 注意：newInstance（）方法内部实际上调用了无参数构造方法，必须保证无参构造存在才可以
 */
public class 通过反射实例化对象 {
    public static void main(String[] args) {

        user u = new user();
        System.out.println(u);

//        以反射机制的方式创建对象
        try {
//            通过反射机制，获取class，通过class来实例化对象
            Class c = Class.forName("反射机制.user");
            Object obj = null;
            try {
//                newInstance()这个方法会调用user这个类的无参构造方法，完成对象的创建
                obj = c.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
