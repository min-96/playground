package org.hdcd.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Slf4j
//스프링빈등록
@Component
//관심사모듈화클래스 지정
@Aspect
public class ServiceLoggerAdvice {


    //JoinPoint-메소드가 호출되는 부분 또는 리턴되는부분
    //advice - 횡단 관심에 해당하는 공통 기능의 코드
    //Before - 조인포인트 전에 실행된다 예외가 발생하는 경우만 제외하고 항상 실행됨
    //org.hdcd.service아래의 패키지 경로의 BoardService 객체의 모든 메서드에 이 Aspect를 적용하겠다는 의미다.
    //포인트컷 표현식 execution 특정 조건에 의해 필터링된 조인포인트, 수많은 조인포인트 중에 특정 메소드에서만 횡단 공통기능을 수행시키기 위해서 사용한다.
    @Before("execution(* org.hdcd.service.BoardService*.*(..))")
    public void startLog(JoinPoint jp){
        log.info("startLog");
        //클라이언트가 호출한 메소드의 시그니처(리턴타입, 이름, 매개변수) 정보가 저장된 Signature 객체 리턴
        log.info("startLog : "+jp.getSignature());
        //클라이언트가 메소드를 호출할 때 넘겨준 인자 목록을 Object 배열 로 리턴
        log.info("startLog :"+ Arrays.toString(jp.getArgs()));


    }
}
