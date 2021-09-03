package org.hdcd.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfiguration {


    protected void configure(HttpSecurity http)throws Exception{
        log.info("security config...");
    //폼 기반 인증기능을 사용한다.
        http.formLogin();
    }

}
