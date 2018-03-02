package com.baidu.usevehicle;
import java.lang.String;
public class User {
	
	
	public static void main(String[] args){
		Vehicle vehicle1=new Vehicle();
		vehicle1.setPower(100);
		System.out.println("now power is "+vehicle1.getPower());
		vehicle1.speedUp(50);
		System.out.println("now speed is "+vehicle1.getSpeed());
		vehicle1.setPower(80);
		System.out.println("now power is "+vehicle1.getPower());
		vehicle1.speedDown(10);
		System.out.println("now speed is "+vehicle1.getSpeed());
	}
	

}
