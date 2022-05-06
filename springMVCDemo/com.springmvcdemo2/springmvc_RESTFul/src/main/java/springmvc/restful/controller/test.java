package springmvc.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @date 2021/10/1 -10:40
 */
@Controller
public class test {
    @RequestMapping("/test01")
    public String ex(){
        return "test01";
    }
    @RequestMapping(value = "/test",method = RequestMethod.DELETE)
    public String test(){
        return "success";
    }
}
