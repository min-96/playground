package org.hdcd.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    protected void configure(HttpSecurity http)throws Exception{
        log.info("security config...");


        //URI 패턴으로 접근제한을 설정한다
        http.authorizeRequests()
                .antMatchers("/board/list")
                .permitAll();
    //Member권한시 접근가능
        http.authorizeRequests()
                .antMatchers("/board/register")
                .hasRole("MEMBER");

        http.authorizeRequests()
                .antMatchers("/notice/list")
                .permitAll();

        http.authorizeRequests()
                .antMatchers("/notice/register")
                .hasRole("ADMIN");

    //폼 기반 인증기능을 사용한다.
        http.formLogin();
    //접근 거부 처리자의 URI를 지정
       http.exceptionHandling()
                .accessDeniedPage("/accessError");

        //등록한 CustomAccressDeniendHandler를 접근거부 처리자로 지정



    }

    //지정된 아이디와 패스워드로 로그인이 가능하게 설정한다
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.inMemoryAuthentication()
                .withUser("member")
                .password("{noop}1234")
                .roles("MEMBER");

        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}1234")
                .roles("ADMIN");
    }

}
