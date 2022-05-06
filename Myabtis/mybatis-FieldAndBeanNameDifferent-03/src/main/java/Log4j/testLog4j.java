package Log4j;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @date 2021/10/15 -16:19
 * 简单使用Log4j 自定义异常信息
 * 1.在要使用Log4j类中导入包
 * 2.日志对象，参数为当前类的class
 * 3.日志级别
 */
public class testLog4j {
    static Logger logger=Logger.getLogger(testLog4j.class);
    @Test
    public void testLog4jByDIY(){
//        输出日志
        logger.info("info:进入testLog4jByDIY");
        logger.debug("debug:进入testLog4jByDIY");
//        错误信息
        logger.error("error:进入testLog4jByDIY");
    }

}
