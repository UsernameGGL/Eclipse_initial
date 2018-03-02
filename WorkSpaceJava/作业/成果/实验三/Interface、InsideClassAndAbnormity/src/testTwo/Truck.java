package testTwo;

public class Truck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sum=0;
		ComputerWeight[] computeTotalSales=new ComputerWeight[3];
		computeTotalSales[0]=new Television();
		computeTotalSales[1]=new Computer();
		computeTotalSales[2]=new WashMachine();
		for(int i=0;i<3;i++){
			sum+=computeTotalSales[i].computeWeight();
			System.out.println("货车装载的货物总量"+sum+" kg");
		}
	}

}
