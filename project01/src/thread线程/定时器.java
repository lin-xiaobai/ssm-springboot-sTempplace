package thread线程;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @date 2021/4/14 -22:56
 */
public class 定时器 {
    public static void main(String[] args) throws ParseException {
//        创建定时器对象
        Timer t = new Timer();
//       创建定时器任务
//        第一个参数为：定时任务
//        第二个参数为：开启第一次任务的时间
//        第三个参数为：每次开启任务的时间（单元：毫秒）
//        获取时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstTime = sdf.parse("2021-04-14 23:04:20");
        t.schedule(new logTimerTask(), firstTime, 1000);
    }
}

//定时任务：记录日志
class logTimerTask extends TimerTask {

    @Override
    public void run() {
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date=sdf.format(new Date());
        System.out.println(new Date() + "完成操作");
    }
}