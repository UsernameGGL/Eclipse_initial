package com.advice;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLogAdvice implements MethodBeforeAdvice {

	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(arg2.getClass().getName()+"��"+arg0.getName()+"������ʼ��ִ�У�������");
	}
}
















