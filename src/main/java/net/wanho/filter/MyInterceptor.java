package net.wanho.filter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fenzx on 2019/6/4.
 */
public class MyInterceptor implements HandlerInterceptor{

   /*执行handler方法之前执行*/
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("方法执行前====preHandle");
        return true;
    }
    /*执行handler方法之后执行*/
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("方法执行后====preHandle");
    }
    /*在modelandview返回之后执行*/
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("返回视图后====preHandle");
    }
}
