package org.hdcd.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {
    //유저정보 세션 공유
    private static final String USER_INFO = "userInfo";

    //지정된 컨트롤러의 동작이전에 가로채는 역할로 사용
    public boolean  preHandle(HttpServletRequest request, HttpServletResponse response ,Object handler) throws  Exception{

        log.info("preHandle");
        String requestURL = request.getRequestURI();

        log.info("requestURl : "+requestURL);

        HandlerMethod method = (HandlerMethod) handler;
        Method methodObj = method.getMethod();

        log.info("Bean : "+method.getBean());
        log.info("Method :"+methodObj);

        HttpSession session =request.getSession();

        if(session.getAttribute(USER_INFO)!=null){
            session.removeAttribute(USER_INFO);
        }



        return true;
    }

    //지정된 컨트롤러의 동작 이후에 처리 DispatcherServlet이 화면을 처리하기 전에 동작한다.
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
        log.info("posHandle");
        String requestURL = request.getRequestURI();

        log.info("requestURL:"+requestURL);

        HandlerMethod method = (HandlerMethod) handler;
        Method methodObj = method.getMethod();

        log.info("Bean : "+method.getBean());
        log.info("Method :"+methodObj);

        HttpSession session = request.getSession();

        //Model, ModelMap Vs ModelAndView 차이점
        //
        //데이터만 저장한다 vs 데이터와 이동하고자 하는 View Page를 같이 저장한다

        ModelMap modelMap = modelAndView.getModelMap();
        Object user= modelMap.get("user");
        log.info("User : "+user);

        if(user != null){
            log.info("user!=null");
            session.setAttribute(USER_INFO,user);
           // 특정 처리 후, 또는 특정 조건일 때에 지정한 페이지로 이동하고 싶은 경우 많이 사용되는 것이 response.sendRedirect() 메소드이다.
            response.sendRedirect("/");
        }


        log.info("Bean : "+method.getBean());
        log.info("Method :"+methodObj);
        log.info("postHandle");
    }
    //DispatherSevlet의 화면처리가 완료된 상태에서 처리한다.
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
        log.info("afterCompletion");
        String requestURL = request.getRequestURI();

        log.info("requestURL:"+requestURL);

        HandlerMethod method = (HandlerMethod) handler;
        Method methodObj = method.getMethod();

        log.info("Bean : "+method.getBean());
        log.info("Method :"+methodObj);

    }
}
