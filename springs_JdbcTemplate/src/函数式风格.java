import org.junit.Test;
import com.spring5.jdbcTemplate.entity;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @date 2021/8/1 -16:28
 * 函数式风格创建对象，交给spring进行管理
 */
public class 函数式风格 {
    @Test
    public void testGenericApplicationContext() {
//    1.创建GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
//        2.调用context方法中对象注册
        context.refresh();
        context.registerBean("bank", entity.class, () -> new entity());
//    3.获取在spring注册的对象
        entity entity = (entity) context.getBean("bank");
        System.out.println(entity);
    }

}
