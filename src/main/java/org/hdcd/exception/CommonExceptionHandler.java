package org.hdcd.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
//스프링컨트롤러에서 발생하는 예외처리하는 핸들러 클래스임을 명시
@ControllerAdvice
public class CommonExceptionHandler {

    //괄호안에 설정한 예외타입을 해당 메서드가 처리한다는것있음 의미
    @ExceptionHandler(Exception.class)
    public String handle(Exception e){
        log.info("error : "+e.toString());

        return "error/errorCommon";
    }
}
