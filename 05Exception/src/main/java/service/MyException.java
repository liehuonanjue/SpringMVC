package service;

import exception.AgeException;
import exception.NameException;
import exception.PwdException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理器
 */
public class MyException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView("/exception/ort");
        if (ex instanceof AgeException) {
            mv.setViewName("/exception/age");
        }
        if (ex instanceof NameException) {
            mv.setViewName("/exception/name");
        }
        if (ex instanceof PwdException) {
            mv.setViewName("/exception/pwd");
        }
        // 讲错误信息 保存到model中
        mv.addObject("exception", ex.getMessage());
        return mv;
    }

}
