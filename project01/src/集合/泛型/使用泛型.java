package 集合.泛型;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @date 2021/4/8 -17:27
 * 1.泛型这种语法机制，只在程序编译阶段起作用，只是给编译器参考的。（运行阶段泛型没用）
 * 2.使用泛型的好处是：
 * （1）.集合中存储的元素类型统一了。
 * （2）.从集合中取出的元素类型是泛型指定的类型，不需要进行大量的“向下转型”。
 * 3.泛型的缺点是：
 * 导致集合中存储的元素缺乏多样性。
 * <p>
 * 迭代器指定元素类型后，返回的值就不是object了，是那个指定元素的类型的了，
 * 不用通过强转类型获取想要的元素类型了。
 */
public class 使用泛型 {
    public static void main(String[] args) {
//        使用泛型
//        定义一个ArrayList集合,
//        规定集合中的元素类型
//        List<animal> l=new ArrayList<>();
        List<animal> l = new ArrayList<animal>();
//        创建cat和bird对象
        cat c = new cat();
        bird b = new bird();
//        往集合添加元素

        l.add(b);
        l.add(c);
//        获取迭代器迭代对象
//        规定迭代器的元素类型
        Iterator<animal> it = l.iterator();
//        迭代
        while (it.hasNext()) {
//            迭代器使用泛型后，可以省略强转animal类型
//            因为迭代器的泛型已经设置好元素类型
//            Object obj=it.next();
//            if (obj instanceof animal){
//                animal a=(animal)obj;
//            }

//            可以使用animal对象接受元素
            animal a = it.next();
//            可以直接调用父类中的方法
//            a.move();

//            如果要调用子类中的方法，必须进行强制
            if (a instanceof cat) {
                cat c1 = (cat) a;
                c1.cath();
            }
            if (a instanceof bird) {
                bird b1 = (bird) a;
                b1.fly();
            }

        }
    }
}

class animal {
    public void move() {
        System.out.println("动物抛");
    }
}

class bird extends animal {
    public void fly() {
        System.out.println("鸟在飞");
    }
}

class cat extends animal {
    public void cath() {
        System.out.println("抓老鼠");
    }
}
