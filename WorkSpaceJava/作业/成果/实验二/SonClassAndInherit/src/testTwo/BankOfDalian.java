package testTwo;

public class BankOfDalian extends Bank {

	BankOfDalian(int money) {
		super(money);
		// TODO Auto-generated constructor stub
	}
	double year;
	double computerInterest(){
		double rate=(2466.56-8000*8*0.035)/(8000*0.236);
		super.year=(int) year;
		interest=super.computerInterest();
		interest+=(year-super.year)*rate*savedMoney;
		return interest;
	}

}
