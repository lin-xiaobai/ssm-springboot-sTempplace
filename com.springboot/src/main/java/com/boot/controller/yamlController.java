package com.boot.controller;

import com.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @date 2021/11/14 -17:37
 */
@Controller
@ResponseBody
public class yamlController {
    @Autowired
    Person person;
    @RequestMapping("/person")
    public Person p(){
        String userName = person.getUserName();
        System.out.println(userName);
        return person;
    }
}
