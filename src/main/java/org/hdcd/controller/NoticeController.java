package org.hdcd.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/notice")
@Controller
@Slf4j
public class NoticeController {

    @GetMapping("/list")
    public void list(){
        log.info("list:access to all");
    }

    @GetMapping("/register")
    public void register(){
        log.info("registerForm: access to admin");
    }
}
