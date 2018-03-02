package testThree;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] employee=new Employee[30];
		for(int i=0;i<10;i++){
			employee[i]=new YearWorker();
		}
		for(int i=10;i<20;i++){
			employee[i]=new MonthWorker();
		}
		for(int i=20;i<30;i++){
			employee[i]=new WeekWorker();
		}
		double sum=0;
		for(int i=0;i<30;i++){
			if(employee[i].earnings()==80000){
				sum+=80000;
			}
			else if(employee[i].earnings()==5000){
				sum+=5000*12;
			}
			else
				sum+=1000*(365.0/7.0);
		}
		System.out.println("公司薪水总额: "+sum);
	}

}
