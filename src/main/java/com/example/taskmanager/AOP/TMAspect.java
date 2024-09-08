package com.example.taskmanager.AOP;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Slf4j
@RequiredArgsConstructor
public class TMAspect {

    @Before("within(com.example.taskmanager.Service.TMService)")
    public void addLoggingBeforeTaskService(){
        log.info("* TaskService starts operating");
    }

    @After("within(com.example.taskmanager.Service.TMService)")
    public void addLoggingAfterTaskService(){
        log.info("* TaskService stops operating");
    }

}
