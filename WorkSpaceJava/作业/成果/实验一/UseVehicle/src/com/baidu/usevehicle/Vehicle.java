package com.baidu.usevehicle;

public class Vehicle {
	double speed;
	int power;
	void speedDown(int s){
		speed-=s;
	}
	void speedUp(int s){
		speed+=s;
	}
	void setPower(int p){
		power=p;
	}
	double getSpeed(){
		return speed;
	}
	int getPower(){
		return power;
	}
	
	
}
