package testFour;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MobileShop mobileShop=new MobileShop(20000,10000);
		int m=30;
		mobileShop.setMobileAmount(m);
		mobileShop.showMobileAmount();
		System.out.printf("�ü�ֵ%d���ڲ�����ȯ������6���ֻ�\n",mobileShop.purchaseMoneyOne.showPrice());
		m-=6;
		System.out.printf("�ü�ֵ%d���ڲ�����ȯ������3���ֻ�\n",mobileShop.purchaseMoneyTwo.showPrice());
		m-=3;
		mobileShop.setMobileAmount(m);
		mobileShop.showMobileAmount();
	}

}
