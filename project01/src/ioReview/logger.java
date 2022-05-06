package ioReview;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @date 2021/4/10 -18:44
 */
public class logger {
    public static void log(String msg) {
//        定义一个printstream对象(字节流）
//        指定一个日志文件
        try {
            PrintStream out = new PrintStream(new FileOutputStream("log.TXT", true));
//            修改输出方向
            System.setOut(out);
//            当前时间，重置时间格式
            Date nowTime = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            String strTime = sdf.format(nowTime);
            System.out.println(strTime + ":" + msg);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
