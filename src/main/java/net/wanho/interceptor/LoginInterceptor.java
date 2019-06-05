package net.wanho.interceptor;

import net.wanho.pojo.Admin;
import net.wanho.service.AdminServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fenzx on 2019/6/4.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private AdminServiceI adminServiceI;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //从session中获取用户信息
        Admin admin= (Admin) request.getSession().getAttribute("admin");
        //如果用户信息存在，直接跳转成功页面
        if (admin!=null){
            response.sendRedirect("/stu/AllStuList");
            return false;
        }
        //如果不存在，去cookie中查询
        Cookie cookie=getCookieByName(request.getCookies(),"admin");
        //如果cookie中有值
        if (cookie!=null){
            String name=cookie.getValue().split("#")[0];
            String password=cookie.getValue().split("#")[1];
            System.out.println(name+"<---->"+password);
            Admin admin1=adminServiceI.LoginCheck(name,password);
            if (admin1==null){
                System.out.println("账号或密码错误");
                return true;
            }
           /* if (!adminName.equals(name) && adminPassword.equals(password)){
                System.out.println("账号或密码错误");
                return true;
            }*/
            //验证成功，seession中重新存一遍值，跳转成功页面
            request.getSession().setAttribute("admin",new Admin(null,name,password));
            response.sendRedirect("/stu/AllStuList");
            return false;
        }
        //cookie中没有值
        return true;

    }

   private Cookie getCookieByName(Cookie[] cookies,String cookieName){
        if (cookies!=null){
            for (Cookie cookie : cookies){
                if (cookie.getName().equals(cookieName)){
                    return cookie;
                }
            }
        }
        return null;
   }
}
