package 集合.泛型;

/**
 * @date 2021/4/8 -17:56
 * 自定义泛型：
 * 自定义泛型的时候，<>尖括号中的是一个标识符，随便写
 * java源代码中经常出现的是：
 * <E>和<T>
 * E是Element单词首字字母（表示元素）
 * T是Type单词首字母（表示类型）
 */
public class 自定义泛型 {
    public static void main(String[] args) {
//        创建对象，规定元素为stirng类型
        math<String> m1 = new math<>();
//        System.out.println(m1.move());
//        返回值使用string类型接收
        String s = m1.move();
        System.out.println(s);
//        创建ma对象，规定对象的元素类型为integer
        ma<Integer> m2 = new ma<>();
//        因为对象的返回值类型是integer类型
//        通过将integer中的valueOf方法转换成int类型
        int i = Integer.valueOf(m2.shu(100));
//        因为aaa是string类型，但是对象的泛型是integ类型
//        所以会造成类型不匹配
//        m2.shu("aaa");
        System.out.println(i);


    }
}

//定义一个类，泛型为E
class math<E> {
    public E move() {
        return null;
    }
}

class ma<E> {
    public E shu(E e) {
        return e;
    }
}
