package testFour;

public class MobileShop {
	class InnerPurchaseMoney{
		private int price;
		public InnerPurchaseMoney(int price) {
			// TODO Auto-generated constructor stub
			this.price=price;
		}
		int showPrice(){
			return price;
		}
	}
	InnerPurchaseMoney purchaseMoneyOne;
	InnerPurchaseMoney purchaseMoneyTwo;
	private int mobileAmount;
	MobileShop(int price1,int price2){
		purchaseMoneyOne=new InnerPurchaseMoney(price1);
		purchaseMoneyTwo=new InnerPurchaseMoney(price2);
	}
	void setMobileAmount(int m){
		mobileAmount=m;
	}
	void showMobileAmount(){
		System.out.println("�ֻ�ר����Ŀǰ��"+mobileAmount+"���ֻ�");
	}
}
