package com.codegym.cms.concern;

import com.codegym.cms.service.exception.DuplicateNameException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Aspect
public class Logger {
    public void error() {
        System.out.println("[CMS] ERROR!");
    }

    @AfterThrowing(pointcut = "execution(public * com.codegym.cms.service.*.*(..))", throwing = "e")
    public void log(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
    }

    @ExceptionHandler(DuplicateNameException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("customer/inputs-not-acceptable");
    }
}
