package springmvc.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springmvc.restful.Bean.Employee;
import springmvc.restful.dao.EmployeeDao;

import java.util.Collection;
import java.util.Date;

/**
 * @date 2021/9/13 -21:25
 */
//控制器
@Controller
public class employeeController {
//    将依赖注入交给spring管理
//将实例化操作交给spring的IOC容器 管理
//    默认根据byType，如果byType不行，那就根据byName
//    在IOC容器里面找到一个对象/bean，为属性赋值
//    通过注解+扫描后 在IOC容器中存在EmployeeDao这个bean，所以能够为employeeDao自动转配
    @Autowired //对EmployeeDao自动装配
//    相当于private EmployeeDao employeeDao==new EmployeeDao();
    private EmployeeDao employeeDao;

//    查看所有人的信息
    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
//        Collection接口 Java集合类的顶级接口 有list map 都可以接收
        Collection<Employee> employeesList = employeeDao.getAll();
//        每一次请求,就得重新获取,所以没必要将信息放在 较大的域

//        通过模块将员工的信息保存在model请求域中
        model.addAttribute("employeesList",employeesList);
        return "employeeinfo";
    }

//    在控制器编写删除页面
//    即 ：根据id值进行删除操作  访问路径中存在一个 id属性值，以辨别删除的数据
//    访问路径中前端还传来一个id值
//    前端传来的id值 使用占位符{}进行接收 使用{属性名}接收
//    method = RequestMethod.DELETE:设置请求的方法为 delete
    @RequestMapping(value = "/employee/{id}",method = {RequestMethod.DELETE})
//    占位符表示的数据需要：在形参位置设置一个形参，
//    通过注解@PathVariable 将占位符所表示的值 与形参 进行绑定
    /*

     */
    public String deleteEmployee(@PathVariable("id")Integer id){
//      将id属性值放入到dao层中delete方法 进行真正的删除操作
       employeeDao.delete(id);
//        删除成功后需要跳转到列表页面
//        列表页面的数据是通过 getAllEmployee控制器 进行请求的
//        如果是通过请求方式进行访问的，会保留之前操作前的访问路径，so need to ask 以重定向的方式进行ask again
//       方法：通过重定向的方法访问getAllEmployee控制器的 /employee页面

//       让浏览器重新通过重定向的方式to asking again。
//    默认 get‘s request
        return  "redirect:/employee";
    }

//    添加功能
    @RequestMapping(value = "/empoyee",method = RequestMethod.POST)
//    当前提交一个 employee对象（名称、性别、邮箱属性值）
//    这三个属性可以单独获取，只需要在 形参的位置上 设置与表单上name属性名一样的属性
//    或者设置一个与属性名相同的实体类
    public String addEmpoyee(Employee employee){
//        在 dao类执行添加功能  因为属性中id在添加的时候是自动增值的，所以不需要设置一个id属性
        employeeDao.save(employee);
        return  "redirect:/employee";
    }

//    修改  先查询 后修改 功能所以是get请求
    @RequestMapping(value = "/employee/{id}",method = {RequestMethod.GET})
//    占位符{id}与形参绑定  查询到的信息需要进行共享，所以需要将数据放到域中
//    @PathVariable("id")作用：获取访问路径中与id属性名 相同的属性值
    public String getEmployeeById(@PathVariable("id")Integer id,Model model){
//        get方法返回值是一个对象 通过id查询employee对象的属性值
        Employee employee = employeeDao.get(id);
//        将数据放在域中，方便前端回显数据  是key和value类型
        model.addAttribute("employee",employee);
        return "employee_update";
    }
//    修改
    @RequestMapping(value="/employee",method = RequestMethod.PUT)
    public  String update(Employee employee){
//        在方法中如果有id值则会自动将对象的属性值覆盖
        employeeDao.save(employee);
        return "employee_update";
    }
    @RequestMapping(value = "/handle/{id}",method = {RequestMethod.DELETE})
    public ModelAndView handleDelete(@PathVariable("id") Integer id) {
        Date date = new Date();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("date",date);
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
