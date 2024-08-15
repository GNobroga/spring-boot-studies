package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAOP {
//     @Before: Executa o código antes do método alvo ser chamado.
// @After: Executa o código depois que o método alvo foi concluído, independentemente do resultado.
// @AfterReturning: Executa o código após o método alvo retornar um valor com sucesso.
// @AfterThrowing: Executa o código se o método alvo lançar uma exceção.
// @Around: Executa o código antes e depois do método alvo. Também permite modificar o comportamento do método alvo, como alterar os parâmetros ou o valor de retorno.
     @Before("execution(* com.example.services.*.*(..))")
    public void logBefore() {
        System.out.println("Log before method execution");
    }

    @AfterReturning(pointcut = "execution(* com.example.services.*.*(..))", returning = "result")
    public void logAfterReturning(Object result) {
        System.out.println("Log after method returned: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.example.aop.services.*.*(..))", throwing = "error")
    public void logAfterThrowing(RuntimeException error) {
        System.out.println("Log after method threw an exception: " + error); 
    }

    @Around("execution(* com.example.service.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Log around method execution: Before");
        Object result = joinPoint.proceed(); // Proceed to the original method
        System.out.println("Log around method execution: After");
        return result;
    }
}
