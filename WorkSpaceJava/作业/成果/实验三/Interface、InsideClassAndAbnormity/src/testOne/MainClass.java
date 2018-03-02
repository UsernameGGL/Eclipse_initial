package testOne;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gymnastics gymnastics=new Gymnastics();
		School school=new School();
		double[] a=new double[100];
		double[] b=new double[10];
		for(int i=0;i<100;i++)a[i]=73.09;
		for(int i=0;i<10;i++)b[i]=9.668;
		System.out.println("体操选手最后得分："+gymnastics.computeAverage(b));
		System.out.printf("班级考试平均分数：%.2f\r\n",school.computeAverage(a));

	}

}
