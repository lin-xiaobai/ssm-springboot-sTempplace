package com.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @date 2021/9/8 -20:40
 */
@Controller
public class ScopeController {
    @RequestMapping("testRequestByServletAPI")
//    通过servlet的api向请求域共享数据
    public String testRequestByServletAPI(HttpServletRequest request){
        request.setAttribute("testRequestByServletAPI","heelowAPI");
        return "success";
    }

//    通过ModelAndView向请求域中共享数据
//    返回的值是ModelAndView的对象
//    可以通过形参或者实例化
//    返回的是视图名称和域对象的key和value
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(ModelAndView mav){
//        ModelAndView mav=new ModelAndView();
//        处理模型数据，即向请求域中共享数
//        key and value
        mav.addObject("testModelAndView","ModelAndView");
//        设置视图名称
        mav.setViewName("success");

        System.out.println(mav);
        return mav;
    }

//    通过Model向请求域中共享数据,在形参中添加Model对象
    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testModel","testModel");
        return  "success";
    }
//    使用map集合向request域对象·共享数据
//    在形参中添加map对象
//    key和value属性
//    往map中的数据就是请求域的数据和类型
    @RequestMapping("/testmap")
    public String testmap(Map<String,Object> map){
        map.put("testmap","testmap");
        return "success";
    }

//    使用modelmap向request域对象·共享数据
    @RequestMapping("/testmodelmap")
    public String testmodelmap(ModelMap modelMap){
        modelMap.addAttribute("testmodelmap","hello,modelmap");
        return "success";
    }


//  通过servlet的api向session域共享数据
    @RequestMapping("/testsessionAPI")
    public String testsessionAPI(HttpSession session){
        session.setAttribute("testsessionAPI","hello,session");
        return "success";
    }
    //  通过servlet的api向application域共享数据
    @RequestMapping("/testapplication")
    public String test(HttpSession session){
//        获取application对象可以通过 ServletContext（servlet的上下文）
        ServletContext app=session.getServletContext();
        app.setAttribute("testapplication","heelo,application");
        return  "success";
    }
}
