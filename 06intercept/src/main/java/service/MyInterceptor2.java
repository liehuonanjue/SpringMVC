package service;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 * filter 是所有web项目中具有的，基于serclet
 * 会拦截所有的请求！
 * Interceptoe是mvc框架特有的，是真正的处理者
 */

public class MyInterceptor2 implements HandlerInterceptor {
    /**
     * @param request
     * @param response
     * @param handler  即将执行的Controller
     * @return falese  后续代码都不会执行
     * @throws Exception
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor2===>preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor2===>preHandle");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor2===>preHandle");

    }
}
