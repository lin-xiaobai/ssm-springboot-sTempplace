package ioReview;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @date 2021/4/10 -20:02
 */
public class File类常用方法 {
    public static void main(String[] args) {
        File f1 = new File("789.TXT");
//        获取名字
        System.out.println(f1.getName());
//        获取文件绝对路径
        System.out.println(f1.getAbsolutePath());
//        判断是否为目录或者文件
        System.out.println(f1.isDirectory());
        System.out.println(f1.isFile());
//        判断文件最后一次修改时间
        long ss = f1.lastModified();//获取1970年到文件最后一次修改时间的毫秒数
        System.out.println(ss);
//        重构时间格式
        Date date = new Date(ss);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String time = sdf.format(date);
        System.out.println(time);
        //获取文件大小
        System.out.println(f1.length());

//        获取当前目录下的所有子文件
        File f5 = new File("E:\\软件安装包");
        File[] files = f5.listFiles();
        for (File f : files) {
            System.out.println(f.getAbsolutePath());
            System.out.println(f.getName());
        }
    }
}
