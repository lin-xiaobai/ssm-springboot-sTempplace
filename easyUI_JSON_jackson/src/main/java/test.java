import Bean.ContactsBean;
import Bean.StudentBean;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @date 2021/10/3 -19:49
 */
public class test {
//    创建ObjectMapper对象
    public static ObjectMapper mapper = new ObjectMapper();
    static {
        // 转换为格式化的json
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // 如果json中有新增的字段并且是实体类类中不存在的，不报错
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
//测试类
    @Test
    public void testjackson() throws JsonGenerationException, JsonMappingException, IOException {
        //        实例化 StudentBean对象和ContactsBean对象
        //       使用有参构造生成属性值
        ContactsBean person=new ContactsBean("李四","1008611");
       StudentBean stu = new StudentBean("201955337**","张三","19级","软件专业","JAVA3班",person);
//        将学生对象转换为json格式数据
       String jsonStu= mapper.writeValueAsString(stu);
        System.out.println("对象转为字符串：" + jsonStu);
//        将学生的数据存放在list集合中，并且将集合转换成json格式
        List<StudentBean> userList = new ArrayList<>();
        userList.add(stu);
        userList.add(stu);
        userList.add(stu);
        userList.add(stu);
        String jsonStr1 = mapper.writeValueAsString(userList);
        System.out.println("集合转为字符串：" + jsonStr1);

    }
}
