package testOne;

public class School implements ComputerAverage {

	@Override
	public double computeAverage(double[] score) {
		// TODO Auto-generated method stub
		int n=score.length;
		if(n<=0)return 0;
		else { 
			double sum=0;
			for(int i=0;i<n;i++){
				sum+=score[i];
			}
		
			return sum/n;
		}
	}

}
