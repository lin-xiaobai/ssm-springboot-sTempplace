package ioReview;

import java.io.File;

/**
 * @date 2021/4/10 -19:38
 */
public class file类 {
    public static void main(String[] args) throws Exception {
//        创建对象，参数为文件或者目录的路径
        File f1 = new File("E:\\a\\b\\c");
        System.out.println(f1.exists());

        if (!f1.exists()) {
//            如果文件不存在则重新创建一个文件
//            f1.createNewFile();
//            f1.delete();
        }
//        if (!f1.exists()){
////            如果a单目录不存在则重新创建一个目录
//            f1.mkdir();
//        }
        if (!f1.exists()) {
//            多重目录
            f1.mkdirs();
        }
        String s = f1.getParent();
        //获取文件的父路径
        System.out.println(s);
        File f2 = new File("data");
        System.out.println("绝对路径" + f2.getAbsolutePath());


    }
}
