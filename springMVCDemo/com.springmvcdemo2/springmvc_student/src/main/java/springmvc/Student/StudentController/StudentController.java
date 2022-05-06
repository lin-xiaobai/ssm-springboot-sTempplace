package springmvc.Student.StudentController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springmvc.Student.StudentBean.Student;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2021/11/24 -16:39
 */
@Controller
public class StudentController {
    @RequestMapping(value = "/checkAge",method = RequestMethod.GET)
    @ResponseBody

    public String cheackA(@RequestParam("age")String age) throws JsonProcessingException {
//        定义一个标识，默认为符合
        int flag=0;
//        将string类型转为int类型
        int ageCheack=(int)Integer.parseInt(age);
        System.out.println(ageCheack);
//        创建map集合，保存的是结果信息
        Map<String,Object> map=new HashMap<>();
        if(ageCheack<0 || ageCheack> 200){
            flag=-1;
        }
        String msg=null;
        if(flag==0){
            map.put("exit",true);
            map.put("message","符合");
        }else if(flag==-1){
            map.put("exit",false);
            map.put("message","请输入正确的年龄访问");
        }

        ObjectMapper obj=new ObjectMapper();
//        将map集合转换为json类型的数据
        String s = obj.writeValueAsString(map);
        return s;
    }
    @RequestMapping(value = "/student",produces="application/json;charset = utf-8")
    @ResponseBody
    public String student(Student student) throws JsonProcessingException {
//        创建一个map集合，保存学院信息，通过前端传来的信息转换成中文
        Map map=new HashMap();
        map.put("jsj","计算机学院");
        map.put("ys","艺术学院");
        map.put("cj","财经学院");
        map.put("wy","外语学院");
//        通过键获取value值，并且强转为string类型
        String colleges = (String)map.get(student.getCollege());
//        将真实的college属性值写入带student类
        student.setCollege(colleges);

        ObjectMapper obj=new ObjectMapper();
//        定义一个标识，默认接收不到信息
        int flag=-1;
//        判断信息是否为空
        if(student!=null){
//            将对象转为json格式
            String json = obj.writeValueAsString(student);
            System.out.println(json);
//            将标识改为1，表示结束到了
            flag=1;
        }
        String result=null;
      if(flag==1){
         result="用户"+student.getName()+"已获到信息";
      }else{
         result="使用收不到信息";
      }
        return  result;
    }
}
