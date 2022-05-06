package com.SparseArray;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @date 2021/8/15 -17:19
 * 当一个数组中大部分元素为０，或者为同一个值的数组时，可以使用稀疏数组来保存该数组
 * 稀疏数组第一行记录的是二维数数组的行 类条数 有多少个不同的值。
 *
 * 二维数组  转 稀疏数组 的思路
 * 1.遍历  原始的二维数组 得到有效的数据的个数sum
 * 2.根据 sum 创建 稀疏数组sparseArray  int[sum+1][3] 从0开始的 sum+1行  4列
 * 3.将二维数组的 有效数据 存入到 稀疏数组
 *
 */
public class sparseArray {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("e:\\567.TXT",true);

//        创建一个二维数组 11*11
//        0表示没有棋子  1表示黑子 2表示篮子
//        定义一个行 列都为11
        int row=11;
        int col=11;
        int chessArr1[][] =new int[row][col];
//        为第二行第三列赋值1 为第三行第四列赋值2
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
//        输出原始的二维数据
        System.out.println("原始的数据");

        for (int i = 0; i < chessArr1.length ; i++) {

            for (int j=0;j<chessArr1.length;j++){
//                "%d\t"初始化
                System.out.printf("%d\t",chessArr1[i][j]);

//                将chessArr1二维数组中的值转变为string类型
                String num= String.valueOf(chessArr1[i][j]);
//                将string类型转变为byte数组并且写入到硬盘上
                fos.write(num.getBytes());
            }
            System.out.println();

        }
        fos.close();


        //    将二维数组  转 稀疏数组
//    1遍历二维数组，得到非0的个数
//    记录非0个数
        int sum=0;
        for (int i = 0; i <chessArr1.length ; i++) {
            for (int j = 0; j <chessArr1.length ; j++) {
                if(chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
//        System.out.println(sum);

//        2.创建对应的稀疏数组
        int sparseArray[][]= new int[sum+1][3];
//        为稀疏数组的第一行赋值
//        第一列为原始二维数组的行数 第二列为原始二维数组的列数 第三列为原始二维数组有效数据个数
        sparseArray[0][0]=row;
        sparseArray[0][1]=col;
        sparseArray[0][2]=sum;
//        遍历原始的二维数组，将非0的值的第n 行 m列存入到稀疏数组中
        int count=0;//记录是第几个非0数据
        for (int i = 0; i <chessArr1.length ; i++) {
            for (int j = 0; j <chessArr1.length; j++) {
                if (chessArr1[i][j]!=0){
                    count++;
//  代码：遍历到非0时，count++  然后稀疏数组的第2行第1列存放 有效数据第i行
// 第2行第2列存放 有效数据第j列 第2行第3列存放 有效数据的值
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=chessArr1[i][j];
                }
            }
        }
//        输出稀疏数组
        System.out.println();//换行
        System.out.println("得到稀疏数组为");
        for(int[]rows :sparseArray){
            for(int data: rows){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

//   将稀疏数组  -》恢复成  原始的二维数组
//  1.读取稀疏数据第一行，根据一行数据，创建原始的二维数组
//   2.再读取稀疏数组的后几行，并且赋给原始的二维数组

    int chessArr2[][]=new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i <sparseArray.length ; i++) {
//            因为稀疏数组的第二行第一列和第二列是记录有效数据的坐标
                chessArr2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }
//        输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");
        for (int[] rows:chessArr2){
            for (int data:rows){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
