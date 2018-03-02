package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext cpxl = new ClassPathXmlApplicationContext("applicationContext.xml");
		IHelloWorld hw1 = (IHelloWorld)cpxl.getBean("hw1129");
		((HelloWorldImpl)hw1).printHW1("abc1129");
	}

}
