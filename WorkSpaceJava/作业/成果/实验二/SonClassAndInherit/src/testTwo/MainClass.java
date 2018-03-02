package testTwo;

import java.util.Scanner;

public class MainClass {

	/**
	 * @param args
	 */
	//需要依次输入存入的钱，在建设银行村的时间和在大连银行存的时间
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int money;
		Scanner in=new Scanner(System.in);
		money=in.nextInt();
		BankOfDalian dlbank=new BankOfDalian(money);
		ConstructionBank ctbank=new ConstructionBank(money);
		ctbank.year=in.nextDouble();
		dlbank.year=in.nextDouble();
		in.close();
		int yearintdl=(int) dlbank.year;
		int yearintct=(int) ctbank.year;
		int daydl=(int) ((dlbank.year-yearintdl)*1000);
		int dayct=(int) ((ctbank.year-yearintct)*1000);
		double moneydl=dlbank.computerInterest();
		double moneyct=ctbank.computerInterest();
		System.out.println(money+"元存在建设银行"+yearintct+"年零"+daydl+"天的利息："+moneyct+"元");
		System.out.println(money+"元存在大连银行"+yearintdl+"年零"+dayct+"天的利息："+moneydl+"元");
		System.out.println("两个银行利息相差"+(moneydl-moneyct)+"元");
	}

}
