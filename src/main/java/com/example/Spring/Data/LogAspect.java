package com.example.Spring.Data;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Before("@annotation(TrackUserAction)")
    public void getInformation(JoinPoint joinPoint){
        System.out.println("Метод: " + joinPoint.getSignature().getName());

        Object[] args = joinPoint.getArgs();


        if(args.length > 1) {
            System.out.print("Аргументы: ");
        }
        else if(args.length == 1){
            System.out.print("Аргумент: ");
        }

        for (Object obj:args)
        {
            System.out.print(obj);
        }
        System.out.println();
        System.out.println("Откуда вызван: " + joinPoint.getTarget().getClass().getSimpleName());


    }
}
