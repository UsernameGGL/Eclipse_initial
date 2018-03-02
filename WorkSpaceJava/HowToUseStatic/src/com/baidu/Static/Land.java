package com.baidu.Static;

public class Land {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Village village1=new Village();
			Village village2=new Village();
			System.out.print("The water amount in village1's sight is ");
			village1.viewAmount();
			System.out.print("The water amount in village2's sight is ");
			village2.viewAmount();
			village1.changeAmout(80000);
			System.out.print("The water amount in village2's sight is ");
			village2.viewAmount();
	}

}
