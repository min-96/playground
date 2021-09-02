package org.hdcd.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static final String USER_INFO = "userInfo";

    //지정된 컨트롤러의 동작이전에 가로채는 역할로 사용
    public boolean  preHandle(HttpServletRequest request, HttpServletResponse response ,Object handler) throws  Exception{

        log.info("preHandle");

        return true;
    }

    //지정된 컨트롤러의 동작 이후에 처리 DispatcherServlet이 화면을 처리하기 전에 동작한다.
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);

        log.info("postHandle");
    }
    //DispatherSevlet의 화면처리가 완료된 상태에서 처리한다.
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
        log.info("afterCompletion");
    }
}
