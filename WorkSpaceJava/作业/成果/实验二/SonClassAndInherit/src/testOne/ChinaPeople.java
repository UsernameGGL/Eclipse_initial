package testOne;

public class ChinaPeople extends People{
	public void chinaGongFu(){
		System.out.println("坐如钟，站如松，睡如弓");
	}
	public void speakHello(){
		System.out.println("您好");
	}
	public void averageHeight(){
		height=168.78;
		System.out.println("中国人的平均身高:"+height+" 厘米");
	}
	public void averageWeight(){
		weight=65.0;
		System.out.println("中国人的平均体重:"+weight+" 千克");
	}
}
