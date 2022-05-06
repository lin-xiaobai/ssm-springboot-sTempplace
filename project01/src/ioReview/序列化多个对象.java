package ioReview;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @date 2021/4/11 -13:09
 * 序列化多个对象
 * 将多个对象放到集合中，序列化对象
 * 提示：
 * 参与序列化的ArrayList集合以及集合中的元素都需要实现序列化接口
 */
public class 序列化多个对象 {
    public static void main(String[] args) {
//        创建list集合存放对象
        List<user> list = new ArrayList<>();
        list.add(new user(1, "zhang", 20));
        list.add(new user(2, "xiaobai", 30));
        list.add(new user(3, "lin", 21));
        list.add(new user(4, "xiao", 22));
        list.add(new user(5, "bai", 21));
//        创建序列化对象
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("user"));
            oos.writeObject(list);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

//实现序列化接口
class user implements Serializable {
    private static final long serialVersionUID = 481083759847116898L;
    //    固定序列化版本号
//    自动生成的序列化版本号，一旦代码确定之后，不能进行后续的修改，因为只要修改，必然会重新编译，此时生成全新的序列化版本号，这个时候java虚拟机会认为这是一个全新的类
//    手动固定序列化版本号
//private static final long serialVersionUID = -849794470754667710L;
    transient int no;
    String name;
    int age;

    public user(int no, String name, int age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "user{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
