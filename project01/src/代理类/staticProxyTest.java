package 代理类;

/**
 * @date 2021/7/20 -11:56
 * 静态代理
 * <p>
 * 特点：代理类和被代理类在编译期间，就确定下来了
 */

//定于一个接口
interface ClothFactory {
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory {
    //用来被代理类对象进行实例化
    private ClothFactory clothFactory;

    public ProxyClothFactory() {
    }

    //    通过有参构造 传递一个被代理类
    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做准备工作");
//        调用被代理类中的实现方法
        clothFactory.produceCloth();

        System.out.println("代理类工厂结束");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("nike鞋正在工作");
    }
}

//测试静态代理
public class staticProxyTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//       方式一： 通过反射机制，获取class，
        Class nike = Class.forName("代理类.NikeClothFactory");
//     通过class来实例化对象
        NikeClothFactory nikeClothFactory = (NikeClothFactory) nike.newInstance();

        // 方式二：ClothFactory nike= new NikeClothFactory();
        ClothFactory clothFactory = new ProxyClothFactory(nikeClothFactory);
        clothFactory.produceCloth();
    }

}
