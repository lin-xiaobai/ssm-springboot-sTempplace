package com.SparseArray;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @date 2021/8/15 -19:45
 */
public class 读取数据 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("e:\\567.TXT");
        byte[] b=new byte[15];
        int count=0;
        while ((count=fis.read(b))!=-1){
//            System.out.prinlf("%d\t",new String(b,0,count));
            int num=Integer.valueOf(new String(b,0,count));
            System.out.printf("%d\t",num);
        }
        fis.close();
        System.out.println();
        System.out.println("sucess");
    }
}
