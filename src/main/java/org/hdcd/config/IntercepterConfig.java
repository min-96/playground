package org.hdcd.config;


import org.hdcd.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration 어노테이션은 환경구성을 돕는다.
@Configuration
public class IntercepterConfig implements WebMvcConfigurer {

    //인터셉터의 경우 스프링에서 관리하기 때문에 스프링내의 모든 객체에서 접근이 가능하다
    //특정 객체동작의 사전혹은 사푸처리는 AOP기능을 활용할수는 있지만
    //컨트롤러의 처리는 인터셉터를 활용하는경우가 더 많다
    //인터셉터는 필터랑 비슷하게 HttpServeletRequest,HttpServletResponee를 파라미터로 받는구조


    public void addInterceptors(InterceptorRegistry registry){
        //원하는 URI에 적절한 패턴을 적용하여 인터셉터를 지정한다
      //  registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/login");


        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/resource/**");

        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
