package 日期类;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @date 2021/3/31 -19:25
 */
public class test01 {
    public static void main(String[] args) throws ParseException {
//        创建一个日期对象
        Date d1 = new Date();
//        date类中的toString()方法已经重写了
        System.out.println(d1);

//        将日期格式化
//        将日期类型date，按照指定的格式进行转换
//            Date-----转换成具有一定格式的日期字符串---》String
//        SSS表示毫秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss  SSS");
//       调用format会返回一个字符串
        String renqi = sdf.format(d1);
        System.out.println(renqi);

//        将日期字符串String类型--->Date类型
//        888毫秒
        String time = "2008-08-08 08:08:08 888";
//        传参的类型必须与上面的time变量的格式一样
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss sss");
//        parse会返回一个Date类型
        Date date2 = sd.parse(time);
        System.out.println(date2);


    }
}
