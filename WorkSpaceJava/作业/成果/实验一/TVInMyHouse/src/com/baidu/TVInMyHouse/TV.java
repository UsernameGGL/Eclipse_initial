package com.baidu.TVInMyHouse;

public class TV {
		int channel;
		void setChannel(int channel){
			this.channel=channel;
		}
		int getChannel(){
			return channel;
		}
		void showProgram(){
			System.out.println("The program now is in "+channel+" channel.");
		}
}
