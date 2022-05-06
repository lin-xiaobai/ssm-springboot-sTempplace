package com.example.boot.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date 2021/11/20 -20:57
 */
@RestController
public class indexController {
    @RequestMapping("/indexs")
    public  String indexa(){
        return "indexNum";
    }
}
