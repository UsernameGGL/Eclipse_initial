package testTwo;

import java.util.Scanner;

public class MainClass {

	/**
	 * @param args
	 */
	//��Ҫ������������Ǯ���ڽ������д��ʱ����ڴ������д��ʱ��
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
		System.out.println(money+"Ԫ���ڽ�������"+yearintct+"����"+daydl+"�����Ϣ��"+moneyct+"Ԫ");
		System.out.println(money+"Ԫ���ڴ�������"+yearintdl+"����"+dayct+"�����Ϣ��"+moneydl+"Ԫ");
		System.out.println("����������Ϣ���"+(moneydl-moneyct)+"Ԫ");
	}

}
