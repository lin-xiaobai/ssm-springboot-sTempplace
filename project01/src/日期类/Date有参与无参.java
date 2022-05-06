package 日期类;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @date 2021/3/31 -20:38
 * Date类中的无参构造方法表示当前系统的时间
 * 有参构造方法表示毫秒
 */
public class Date有参与无参 {
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println(d1);

//        传参为1毫秒
        Date d2 = new Date(1);
//        返回的是一个string类型
//        初始化时间，修改时间的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss sss");
        String strtime = sdf.format(d2);
        System.out.println(strtime);
    }
}
