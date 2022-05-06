package 反射机制;

/**
 * @date 2021/4/15 -23:33
 * 如果只是希望一个类的静态代码块执行，其他代码一律不执行，可以使用
 * Class.forName("完整类名")
 * 这个方法的执行会导致类加载，类加载时，静态代码块执行。
 */
public class 执行静态代码块 {
    public static void main(String[] args) {

//        testNo tn=new testNo();
        try {
//            这个方法在执行导致类加载，类加载时，静态代码块执行
            Class.forName("反射机制.testNo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

class testNo {
    //    在类加载的时候，会执行静态代码块
    static {
        System.out.println("静态代码块执行");
    }
}