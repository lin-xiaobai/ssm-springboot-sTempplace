package com.controller;

import com.dao.UserMapper;
import com.domain.ResultInfo;
import com.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @date 2021/10/23 -17:35
 */
@Controller
public class UserController {
//    注入service
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

//    首页
    @RequestMapping("/user")
    public String index(){
        return "UserRegister";
    }
    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    public String  addUser(User user,Model model){
        ResultInfo reg = userService.register(user);
        System.out.println("======"+userService);
        model.addAttribute("register",reg);
        return "success";

    }
    @RequestMapping("/user/checkName")
    @ResponseBody
    public String checkName(@RequestParam("name")String name) throws JsonProcessingException {
        User user = userMapper.selectByName(name);
        ResultInfo resultInfo = new ResultInfo();
        if (user!=null){
            resultInfo.setSuccess(true);
            resultInfo.setMessage("用户名已被使用");
        }else{
            resultInfo.setSuccess(false);
            resultInfo.setMessage("用户名可以使用");
        }
        ObjectMapper objectMapper=new ObjectMapper();
        String ms = objectMapper.writeValueAsString(resultInfo);
        return ms;
    }
    @RequestMapping("/user/checkTelephone")
    @ResponseBody
    public String checktelephone(@RequestParam("telephone")String telephone) throws JsonProcessingException {
        User user = userMapper.selectByTelephone(telephone);
        ResultInfo resultInfo = new ResultInfo();
        if (user!=null){
            resultInfo.setSuccess(true);
        }else{
            resultInfo.setSuccess(false);
        }
        ObjectMapper objectMapper=new ObjectMapper();
        String ms = objectMapper.writeValueAsString(resultInfo);
        return ms;
    }

}
