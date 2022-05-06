package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @date 2021/10/28 -15:23
 * //二维码的使用
 */
@Controller
public class QrcodeController {
    @RequestMapping("/qr")
    public String qr(){
        return "qrcode";
    }
}
