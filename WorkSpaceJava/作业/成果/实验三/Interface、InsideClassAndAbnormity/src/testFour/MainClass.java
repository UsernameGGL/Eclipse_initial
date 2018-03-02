package testFour;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MobileShop mobileShop=new MobileShop(20000,10000);
		int m=30;
		mobileShop.setMobileAmount(m);
		mobileShop.showMobileAmount();
		System.out.printf("用价值%d的内部购物券购买了6部手机\n",mobileShop.purchaseMoneyOne.showPrice());
		m-=6;
		System.out.printf("用价值%d的内部购物券购买了3部手机\n",mobileShop.purchaseMoneyTwo.showPrice());
		m-=3;
		mobileShop.setMobileAmount(m);
		mobileShop.showMobileAmount();
	}

}
