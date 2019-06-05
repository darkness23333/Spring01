package net.wanho.exceptionResolver;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by fenzx on 2019/6/4.
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver{

    private Logger logger= Logger.getLogger(GlobalExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //异常处理逻辑
        logger.error("发生了异常，异常为"+e.getMessage());
        e.printStackTrace();

        //发邮件
        //发信息

        //分不同的异常类型去处理
        if(e instanceof IndexOutOfBoundsException){

        }

        //处理异常，展示错误页面
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg","服务器正忙");
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
