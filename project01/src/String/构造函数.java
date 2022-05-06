package String;

/**
 * @date 2021/3/20 -17:45
 */
public class 构造函数 {
    public static void main(String[] args) {
//        定义byte数组并且静态初始化
        byte[] b = {97, 98, 99};
//        97是a，将byte数组转换成字符串类型，说明toString已经改写了
        String s = new String(b);
        System.out.println(s);

//        第一个参数表示数组，第二个参数表示数组中元素的下标，第三个参数表示长度
//        这句话表示从b数组的下标为1长度为2，转换成字符串类型
        String s1 = new String(b, 1, 2);
        System.out.println(s1);

        System.out.println("==================");
        //将char数组转换成字符串类型
        char[] c = {'我', '是', 'S', 'b'};
        String c1 = new String(c);
        System.out.println(c1);
//        第一个参数表示数组名称，第二个参数表示数组第n个下标，第三个表示长度
//        意思是：将c数组下的第1个下标元素，开始转换2个长度的字符串类型
//        将一部份的char类型转换成字符串类型
        String c2 = new String(c, 1, 2);
        System.out.println(c2);


    }
}
