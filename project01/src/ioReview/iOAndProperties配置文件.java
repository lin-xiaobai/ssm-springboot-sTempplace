package ioReview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @date 2021/4/11 -14:40
 * IO+Properties的联合使用
 * <p>
 * 2021年4月11日
 * 14:30
 * <p>
 * 1.Properties是一个Map集合，key和value都是String类型。
 * <p>
 * 可以将硬盘上的文件数据加载到Properties对象当中。
 * <p>
 * <p>
 * 设计理念：
 * 经常改变的数据，单独写到一个文件中，使用程序动态读取。
 * 将来只需要修改这个文件的内容，java代码不需要改动，不需要重新编译，服务器也不需要重启，就可以拿到动态的信息。
 * <p>
 * 类似于以上机制的文件被称为配置文件。
 * 并且当配置文件中的内容格式是：
 * key1=value//key1:value
 * key2=value//key2:value
 * 的时候，这种配置文件叫做属性配置文件
 * <p>
 * java规范中有要求：属性配置文件建议以.properties结尾，但不是必要。
 * 这种以.properties结尾的文件在java中被称为：属性配置文件
 * 其中Properties是专门存放属性配置文件内容的一个类。
 */
public class iOAndProperties配置文件 {
    public static void main(String[] args) {
//            创建一个Map集合中的properties，泛型都是string类型
        Properties properties = new Properties();
//        新建一个输入流对象
        FileInputStream fis = null;
        try {

            fis = new FileInputStream("userinfo.properties");
//            将userinfo文件的数据加载到Properties对象中
//            调用properties对象的load方法将文件中的数据加载到map集合中
            properties.load(fis);//文件中的数据顺着管道加载到map集合中，其中等号=左边做key，右边做value
//            通过key获取value
            String name = properties.getProperty("user");
            System.out.println(name);
            String user = properties.getProperty("password");
            System.out.println(user);
            String date = properties.getProperty("date");
            System.out.println(date);
            long time = Long.valueOf(date);
            Date date1 = new Date(time);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            String nowtime = sdf.format(date1);
            System.out.println(nowtime);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
