import com.dao.UserMapper;
import com.domain.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonArray;
import com.service.UserService;
import com.utils.JsonUntils;
import okhttp3.Route;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2021/10/25 -9:51
 */
/*
测试mybatis的分页查询
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class testmybatis {
    @Autowired
    private  UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Test
    public  void  test(){
        List<User> allUserByPageF = userService.findAllUserByPageF(1, 2);

        for (User user:allUserByPageF) {
            System.out.println(user);
        }
        System.out.println("总条数"+allUserByPageF.size());
    }
    @Test
    public void  test2() throws IOException {
        int num=1;
        PageHelper.startPage(num, 3);
        List<User> users = userMapper.selectByLimte();
        for (User user:users) {
            System.out.println(user);
        }
//        使用工具类
        String json=new JsonUntils().objectToJson(users);
        System.out.println(json);



////        将对象转为json数据
//        String json = new ObjectMapper().writeValueAsString(users);
//        System.out.println(json);
////        将json数据转为对象
//        List<User> users1 = new ObjectMapper().readValue(json, List.class);
//        int size = users1.size();
//        System.out.println(size);

    }

}
