package org.hdcd.config;


import lombok.extern.slf4j.Slf4j;
import org.hdcd.config.security.CustomerAccessDeniedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

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
        http.formLogin()

        //사용자가 정의한 로그인페이지 URI를 지정한다
                .loginPage("/login");


    //접근 거부 처리자의 URI를 지정
//       http.exceptionHandling()
//                .accessDeniedPage("/accessError");

        //등록한 CustomAccressDeniendHandler를 접근거부 처리자로 지정
        http.exceptionHandling()
                .accessDeniedHandler(createAccessDeniedHandler());


    }
    //접근거부가 발생한 상황에 단순 메세지 처리 이상의 다양한 처리를 하고싶다면
    //AccessDeniedHandler 직접구현해야됨.
    @Bean
    public AccessDeniedHandler createAccessDeniedHandler() {
        return new CustomerAccessDeniedHandler();
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
