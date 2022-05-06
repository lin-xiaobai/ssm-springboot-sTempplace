import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * @date 2021/10/22 -20:16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test {

//    测试连接redist
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void testOps() {
        //简化对String类型的操作对象
        ValueOperations<String,String> ops = redisTemplate.opsForValue();
        ops.set("company", "天宇");
        String company = ops.get("text");
        System.out.println(company);

        //设置过期的时间： 键，多久，单位
        redisTemplate.expire("company", 50, TimeUnit.SECONDS);
    }

}
