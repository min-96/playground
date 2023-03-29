package org.hdcd.config.security;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//SavedRequestAwareAuthenticationSuccessHandler는 AuthenticationSuccessHandler 의 구현 클래스이다
@Slf4j
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
//인정 전에 접근을 시도한 URL로 리다이렉트하는 기능을 가지고 있으며
    //스프링 시큐리티에서 기본적으로 사용되는 구현클래스이다.


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        log.info("onAuthenticationSuccess");

        User customerUser =(User) authentication.getPrincipal();
        log.info("customerUser : " + customerUser);

        log.info("userName: " + customerUser.getUsername());
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
