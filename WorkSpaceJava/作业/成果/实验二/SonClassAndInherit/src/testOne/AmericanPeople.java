package testOne;

public class AmericanPeople extends People{
	public void americanBoxing(){
		System.out.println("Ö±È­£¬¹´È­£¬×éºÏÈ­");
	}
	public void speakHello(){
		System.out.println("How do you do");
	}
	public void averageHeight(){
		height=176.0;
		System.out.println("American's average height: "+height+" cm.");
	}
	public void averageWeight(){
		weight=75.0;
		System.out.println("American's average weight: "+weight+" kg.");
	}
}
