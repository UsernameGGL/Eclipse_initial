package com.baidu.TVInMyHouse;

public class Family {
		TV homeTV;
		String signal="shut down";
		void buyTV(TV TV){
			homeTV=TV;
		}
		void remoteControl(int signal){
			if(signal==0){
				this.signal="shut down";
			}
			else
				this.signal="on";
		}
		void setTV(){
			if(signal=="shut down")
				System.out.println("Television has shut down.");
			else{
				System.out.println("Someone has opened the TV.");
				System.out.println("Television is on.");
			}
		}
}
