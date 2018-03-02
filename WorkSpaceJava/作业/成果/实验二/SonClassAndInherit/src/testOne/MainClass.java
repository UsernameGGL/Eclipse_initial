package testOne;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChinaPeople chinese=new ChinaPeople();
		AmericanPeople american=new AmericanPeople();
		BeijingPeople beijinger=new BeijingPeople();
		chinese.speakHello();
		american.speakHello();
		beijinger.speakHello();
		chinese.averageHeight();
		american.averageHeight();
		beijinger.averageHeight();
		chinese.averageWeight();
		american.averageWeight();
		beijinger.averageWeight();
		chinese.chinaGongFu();
		american.americanBoxing();
		beijinger.beijingOpera();
		beijinger.chinaGongFu();

	}

}
