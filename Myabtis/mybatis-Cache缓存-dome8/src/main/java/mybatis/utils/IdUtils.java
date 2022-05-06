package mybatis.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * @date 2021/10/17 -12:11
 */
//当uuid出现“-”时出报出 警告信息
//    解决方法
@SuppressWarnings("all")//抑制警告 即忽略所有警告信息
public class IdUtils {
//    将数据库中id设置为uuid
//    获取uuid uuid具有唯一性
    public static String getUUId(){
//        产生一个uuid 并且将uuid中的“-”替换成 空
        return UUID.randomUUID().toString().replaceAll("-","");
    }
//    测试
    @Test
    public void test(){
        System.out.println(IdUtils.getUUId());
        System.out.println(IdUtils.getUUId());
        System.out.println(IdUtils.getUUId());
    }

}
