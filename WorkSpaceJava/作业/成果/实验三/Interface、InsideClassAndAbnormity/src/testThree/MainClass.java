package testThree;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog=new Dog();
		String[] state={"狗在主人面前：","狗遇到敌人：","狗遇到朋友：","狗遇到同伴："};
		for(int i=0;i<state.length;i++){
			if(state[i].equals("狗在主人面前："))dog.state=new DogOne();
			else if(state[i].equals("狗遇到敌人："))dog.state=new DogTwo();
			else if(state[i].equals("狗遇到朋友："))dog.state=new DogThree();
			else if(state[i].equals("狗遇到同伴："))dog.state=new DogFour();
			else
				continue;
			System.out.print(state[i]);
			dog.show();
		}

	}

}
