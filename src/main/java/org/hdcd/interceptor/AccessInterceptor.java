package org.hdcd.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


//접근 로그 저장 인터셉터
@Slf4j
public class AccessInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String requestUrl = request.getRequestURI();

        log.info("requestURL : "+requestUrl);

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Class clazz= method.getDeclaringClass();

        String className = clazz.getName();
        String classSimpleName = clazz.getSimpleName();
        String methodName = method.getName();

       log.info("ACESS CONTROLLER :" + className+"."+methodName);
        log.info("[SUCESS CONTROLLER]{}.{}",method.getDeclaringClass().getSimpleName(),method.getName());

    }
}
