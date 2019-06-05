package net.wanho.controller;

import net.wanho.pojo.Admin;
import net.wanho.service.AdminServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by fenzx on 2019/6/4.
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminServiceI adminServiceI;

    @RequestMapping("ToAdminLogin")
    public String ToAdminLogin(){
        return "adminlogin";
    }

    @RequestMapping("login")
    public String adminLogin(String adminName, String adminPassword, String loginToken, HttpSession session, HttpServletResponse response){
        Admin admin=adminServiceI.LoginCheck(adminName,adminPassword);
        if(admin==null){
            /*throw new RuntimeException("参数有误");*/
            return "redirect:/admin/ToAdminLogin";
        }

        //登录验证
        if (!adminName.equals(admin.getAdminName()) && adminPassword.equals(admin.getAdminPassword())){
            System.out.println("账号或密码错误");
            return "redirect:/admin/ToAdminLogin";
        }

        //登录成功
        session.setAttribute("admin",admin);

        //判断是否勾选了免登录
        if("loginToken".equals(loginToken)){
            Cookie cookie =new Cookie("admin",admin.getAdminName()+"#"+admin.getAdminPassword());
            cookie.setMaxAge(60*60*24*5);
            response.addCookie(cookie);
        }
        return "redirect:/stu/AllStuList";
    }


    //账号的注销（退出账号删除session和cookie）
    @RequestMapping("LoginOut")
    public String adminMainToLoginOut(HttpServletRequest request,HttpServletResponse response){
        //注销session
        request.getSession().removeAttribute("admin");
        //设置cookie寿命时间为0达到消除cookie
        Cookie cookie =new Cookie("admin",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/admin/ToAdminLogin";
    }
}
