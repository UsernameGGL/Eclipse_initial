package testTwo;

public class Bank {
	double interest;
	int year;
	int savedMoney;
	Bank(int money){savedMoney=money;}
	double computerInterest(){
		interest=year*0.035*savedMoney;
		return interest;
	}
}
