package com.baidu.Static;

public class Village {

	static int waterAmount=100000;
	void changeAmout(int newAmount){
		waterAmount=newAmount;		
	}
	void viewAmount(){
		System.out.println(waterAmount+".");
	}
}
