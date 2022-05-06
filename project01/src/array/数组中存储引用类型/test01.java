package array.数组中存储引用类型;

/**
 * @date 2021/3/18 -15:48
 */
public class test01 {
    public static void main(String[] args) {
//        创建animal对象
        Animal a1 = new Animal();
        Animal a2 = new Animal();
//        创建一个引用数组
        Animal[] ars = {a1, a2};
//        循环数组
        for (int i = 0; i < ars.length; i++) {
//            创建一个animal对象的引用保存每一个方法
//            Animal a=ars[i];
//            打印输出数组的索引的方法
//            move方法不是数组的。是数组当中nimal对象的move方法
//            a.move();
//        代码合并
            ars[i].move();
        }
//        合并代码,定义一个数组
        Animal[] a3 = {new bird(), new cat()};
//        循环数组
        for (int i = 0; i < a3.length; i++) {
//            输出鸟和猫中的方法
            a3[i].move();
        }
        Animal[] a8 = {new bird(), new cat()};
//        循环引用数组
        for (int i = 0; i < a8.length; i++) {
//            这个取出来的可能是cat对象或者一个bird对象
//            判断底层对象
            if (a8[i] instanceof cat) {
//                强制转换（向上转型）调用子类型中独特的方法
                cat c2 = (cat) a8[i];
                c2.catmove();
            } else if (a8[i] instanceof bird) {
                bird b2 = (bird) a8[i];
                b2.sing();

            } else {
                System.out.println("类型错误");
            }
        }

    }


}

class Animal {
    //    定义一个方法
    public void move() {
        System.out.println("动物在跑路");
    }
}

//定义一个小猫继承动物
class cat extends Animal {
    public void move() {
        System.out.println("小猫在");
    }

    //    定义一个子类中独特的方法
    public void catmove() {
        System.out.println("抓老鼠");
    }
}

//定义一只鸟
class bird extends Animal {
    //    重写继承方法
    public void move() {
        System.out.println("小脑");
    }

    //    定义一个子类中独特的方法
    public void sing() {
        System.out.println("唱歌");
    }
}