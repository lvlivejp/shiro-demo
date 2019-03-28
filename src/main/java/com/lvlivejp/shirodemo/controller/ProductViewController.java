package com.lvlivejp.shirodemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductViewController {

    @GetMapping("/view")
    public String view(){
        return "productInfo";
    }

}
