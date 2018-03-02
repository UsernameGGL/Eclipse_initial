package com.baidu.TVInMyHouse;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV hairTV=new TV();
		Family zhangSanFamily=new Family();
		zhangSanFamily.buyTV(hairTV);
		zhangSanFamily.setTV();
		zhangSanFamily.remoteControl(1);
		zhangSanFamily.setTV();
		zhangSanFamily.homeTV.setChannel(36);
		System.out.println(zhangSanFamily.homeTV.getChannel()+".");
		zhangSanFamily.homeTV.showProgram();

	}

}
