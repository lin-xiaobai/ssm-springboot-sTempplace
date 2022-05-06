package demo.student.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import demo.student.bean.ContactsBean;
import demo.student.bean.StudentBean;

/**
 * @date 2021/10/3 -16:37
 * Gson框架的使用
 * 将JSON字符串-->Java对象
 * 将Java对象-->JSON字符串
 * 将数组-->JSON
 */
public class StudentGson {
    public static void main(String[] args) {
//       创建Gson对象的两种方式：
//        方式一：
        GsonBuilder gb = new GsonBuilder();
//      如果不设置serializeNulls,序列化时默认忽略NULL
//      设置支持NULL的序列化
        gb.serializeNulls();
        Gson gson = gb.create();
////        方式二：
//        Gson gson1=new Gson();
//      给StudentBean的属性赋值
//        StudentBean stu = new StudentBean();
//        stu.setId("201955337**");
//        stu.setName("王五");
//        stu.setGrade("19级");
//        stu.setMajor("软件专业");
//        stu.setClassname("JAVA3班");
////        将Java对象转化为JSON字符串，并且用string类型接收
//        String str = gson.toJson(stu);
////        打印输出json格式的数组
//        System.out.println(str);
////         2. JSON字符串-->Java对象
////        Gson gson1=new Gson();////        StudentBean stu=gson1.fromJson(str,StudentBean.class);
////        System.out.println(stu);
////        System.out.println("========");
//       为学生关联一位紧急联系人
        StudentBean stu1=new StudentBean();
        stu1.setId("201955337**");
        stu1.setName("张三");
        stu1.setGrade("19级");
        stu1.setMajor("软件专业");
        stu1.setClassname("JAVA3班");
//        紧急联系人并且使用有参构造生成属性
        ContactsBean person=new ContactsBean("李四","1008611");
        stu1.setPerson(person);
//        将学生类中属性转换为json格式数据
        String str2=gson.toJson(stu1);
//        System.out.println(str2);
//        将学生数据使用数组存储，并将数据内容转换成JSON显示
//        将学生的数据添加到数组中
        StudentBean[] StuArray=new StudentBean[]{stu1,stu1,stu1};
//        将数组中的数据转换为json格式
        String str3=gson.toJson(StuArray);
        System.out.println("学生数组："+str3);
    }
    }
