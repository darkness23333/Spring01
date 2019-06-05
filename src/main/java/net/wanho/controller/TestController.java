package net.wanho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fenzx on 2019/6/4.
 */
@Controller
public class TestController {


    @RequestMapping("testInterceptor")
    public String testInterceptor(){
        System.out.println("方法执行");
       /* System.out.println(1/0);*/
        return "success";
    }
}
