package com.controller;

import com.dao.ImgMapper;
import com.domain.img;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @date 2021/10/26 -14:47
 */
@Controller
public class ImageContraller {
    @Autowired
    private ImgMapper img;

    @RequestMapping(value = "/img")
    public String i(){
        return "img";
    }
    @RequestMapping("/img/id")
    public String imgs(@RequestParam("id")int id, Model model){
        img i = img.selectImg(id);
        System.out.println(i);
        model.addAttribute("i",i);
        return "img";
    }
}
