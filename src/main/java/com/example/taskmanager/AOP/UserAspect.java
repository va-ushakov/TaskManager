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
public class UserAspect {

    @Before("within(com.example.taskmanager.Service.UserService)")
    public void addLoggingBeforeUserService(){
        log.info("* UserService starts operating");
    }

    @After("within(com.example.taskmanager.Service.UserService)")
    public void addLoggingAfterUserService(){ log.info("* UserService stops operating");
    }






}
