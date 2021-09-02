package org.hdcd.controller;

import lombok.extern.slf4j.Slf4j;
import org.hdcd.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class LoginController {
    @GetMapping("/login")
    public String LoginForm(){

        log.info("loginform");
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(User user, Model model){
     log.info("login");
     log.info("login userId = "+user.getUserId());
     log.info("lpgin userPw ="+user.getUserPw());

     model.addAttribute("result","로그인이 되었스빈다.");
             return "sucess";
    }
}
