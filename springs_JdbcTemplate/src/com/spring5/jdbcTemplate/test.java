package com.spring5.jdbcTemplate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2021/7/22 -18:20
 */
public class test {
    @Test
//    测试spring中jdbc
    public void testJdbcTemplate() {
//        加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcConntection.xml");
        service user = context.getBean("service", service.class);
        entity use = new entity();
//        Scanner scanner=new Scanner(System.in);
//       String id= scanner.next();
//        String name= scanner.next();
//        String stuat= scanner.next();
//        use.setId(id);
//        use.setName(name);
//        use.setStatus(stuat);
        int id = 11;


        String idd = id + "";

        use.setId("1111");
        use.setName("xiaoming");
        use.setStatus("bad");


//       user.addUser(use);
//       user.updateuser(use,idd);
//       user.deleteUser("1111");
//        user.selectCount();
//        user.findUserByid("1111");
//        user.finUSerByList();

//        批量添加
        List<Object[]> list = new ArrayList<>();
//        Object的值需要跟字段中的名字一样
        Object[] o1 = {"11", "java", "anem"};
        Object[] o2 = {"22", "java", "anem"};
        Object[] o3 = {"33", "java", "anem"};

//        添加到list集合中
        list.add(o1);
        list.add(o2);
        list.add(o3);
//        user.batchAdd(list);

//        批量修改
        List<Object[]> lists = new ArrayList<>();
//        Object的值需要跟字段中的名字一样
        Object[] o10 = {"10", "javax", "anem", "11"};
        Object[] o20 = {"20", "javax", "anem", "22"};
        Object[] o30 = {"30", "javax", "anem", "33"};

//        添加到list集合中
        lists.add(o10);
        lists.add(o20);
        lists.add(o30);
        user.batchUpdate(lists);
//        批量删除
        List<Object[]> listss = new ArrayList<>();
//        Object的值需要跟字段中的名字一样
        Object[] n2 = {"10"};
        Object[] n1 = {"20"};
        Object[] n3 = {"30"};

//        添加到list集合中
        listss.add(n1);
        listss.add(n2);
        listss.add(n3);
        user.batchDelde(listss);
    }
}
