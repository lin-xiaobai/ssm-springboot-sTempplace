package 内部类;

/**
 * @date 2021/3/16 -14:49
 */
public class test01 {
    public static void main(String[] args) {
        myMath m1 = new myMath();
        m1.myMath3(new computer03(), 100, 200);
//        使用内部类方法
//        m1.myMath3(new  computer(){
//            public  int sum(int x,int y){
//                return  x+y;
//            }
//        },100,200);
    }
}
