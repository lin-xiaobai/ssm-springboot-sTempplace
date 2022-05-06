package ioReview;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @date 2021/4/11 -13:18
 */
public class 反序列化多个对象读 {
    public static void main(String[] args) {

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("user"));
//            强转obejct类型为list集合
            List<user> list = (List<user>) ois.readObject();
            for (user u : list) {
                System.out.println(u.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
