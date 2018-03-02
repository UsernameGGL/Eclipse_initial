package com.advice;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

public class AfterLogAdvice implements AfterReturningAdvice {

	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(arg3.getClass().getName()+"µÄ"+arg1.getName()+"Ö´ÐÐ½áÊø");
	}

}
