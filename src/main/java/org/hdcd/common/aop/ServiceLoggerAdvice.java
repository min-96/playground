package org.hdcd.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Slf4j
//스프링빈등록
@Component
//관심사모듈화클래스 지정
@Aspect
    //advice - 횡단 관심에 해당하는 공통 기능의 코드
public class ServiceLoggerAdvice {



    //JoinPoint-메소드가 호출되는 부분 또는 리턴되는부분 //비지니스메소드
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
    //afterRunning - 조인포인트가 정상적으로 종료한 후에 실행된다 예외가 발생하면 실행되지 않음
    @AfterReturning("execution(* org.hdcd.service.BoardService*.*(..))")
    public void  logRunning(JoinPoint jp){
        log.info("logRunning");
        log.info("logRunning:"+jp.getSignature());
    }

    //조인포인트에서 예외가 발생했을때 실행된다.
    @AfterThrowing(pointcut = "execution(* org.hdcd.service.BoardService*.*(..))",throwing = "e")
    public void logException(JoinPoint jp,Exception e){
        log.info("logException");
        log.info("logException :" + jp.getSignature());
        log.info("logException :"+e);

    }
    //조인포인트에서 처리가 완료된 후 실행 예외발생이나 정상종료 여부와 상관없이 실행됨
    @After("execution(* org.hdcd.service.BoardService*.*(..))")
    public void endLog(JoinPoint jp){
        log.info("endLog");
        log.info("endLog : "+ jp.getSignature());
        log.info("endLog :" + Arrays.toString(jp.getArgs()));
    }
    //조인포인트 전후에 실행됨
    @Around("execution(* org.hdcd.service.BoardService*.*(..))")
    public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
    //around 어드바이스 경우는 클라이언트 호출을 가로챈다 따라서 막바로 리턴을 해버리면
        //비지니스메소드 자체가 실행이안 around 메소드에서 책임을 져야됨
        //비지니스메소드에 대한 정보를 around 메소드가 알려면 ProceedongJoingPoint 객체
        long startTime = System.currentTimeMillis();

        log.info(Arrays.toString(pjp.getArgs()));


        Object result = pjp.proceed();

        long endTime = System.currentTimeMillis();

        log.info(pjp.getSignature().getName()+":"+(endTime-startTime));

        return result;
    }

    @Before("execution(* org.hdcd.service.BoardService*.*(..))")
    public void log(JoinPoint jp){
        //프락시가 입혀지기 전에 원본대상 객체를 가져옴
        Object targetObject  = jp.getTarget();
        log.info("targetObject : "+targetObject);

        //프락시를 가져옴
        Object thisObject = jp.getThis();

        log.info("thisObject : "+ thisObject);

        //인수를 가져옴

        Object[] args = jp.getArgs();

        log.info("args.legth=" + args.length);


    }

}
