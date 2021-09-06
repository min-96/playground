package org.hdcd.controller;

import lombok.extern.slf4j.Slf4j;
import org.hdcd.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class LoginController {
    @RequestMapping("/login")
    public String LoginForm(String error,String logout,Model model){
    //에러메세지와 로그아웃메세지를 파라미터로 사용
        log.info("error :" +error);
        log.info("logout : "+logout);


        if(error !=null){
            model.addAttribute("error","Lgoin Error!");
        }
        if(logout !=null){
            model.addAttribute("logout","logout!");
        }

        return "loginForm";
    }


    @GetMapping("/logout")
    public String logoutForm(){
        log.info("logoutForm");
        return "logoutForm";
    }

//    @PostMapping("/login")
//    public String login(User user, Model model){
//     log.info("login");
//     log.info("login userId = "+user.getUserId());
//     log.info("lpgin userPw ="+user.getUserPw());
//
//     model.addAttribute("user",user);
//
////     model.addAttribute("result","로그인이 되었스빈다.");
//             return "home";
//    }
}
