package org.hdcd.controller;


import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class CommonController {
    @RequestMapping("/accessError")
    public void accessDenind(Authentication auth, Model model){
        //유효한 인증인지 확인하기.
    //AuthenticationManager ->유효한인증인 처리하는 곳
        //인자로 받은 Authentication이 유효한 인증인지 확인하고,  "Authentication" 객체를 리턴

        log.info("accress Denined :"+auth);
        model.addAttribute("msg","Access Denind");

    }
}
