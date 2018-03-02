package testTwo;

public class ConstructionBank extends Bank {
	ConstructionBank(int money) {
		super(money);
		// TODO Auto-generated constructor stub
	}
	double year;
	double computerInterest(){
		double rate=(2428.8-8000*8*0.035)/(8000*0.236);
		super.year=(int) year;
		interest=super.computerInterest();
		interest+=(year-super.year)*rate*savedMoney;
		return interest;
	}
}