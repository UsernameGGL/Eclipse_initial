package testOne;

public class Gymnastics implements ComputerAverage {

	@Override
	public double computeAverage(double[] score) {
		// TODO Auto-generated method stub
		int n=score.length;
		if(n<=0)return 0;
		else if(n==1){
			return score[0];
		}
		else if(n==0)return (score[0]+score[1])/2;
		else{
			double max=score[0],sum=score[0],min=score[0];
			for(int i=1;i<n;i++){
				if(score[i]>max)max=score[i];
				if(score[i]<min)min=score[i];
				sum+=score[i];
			}
			return (sum-max-min)/(n-2);
		}
	}

}
