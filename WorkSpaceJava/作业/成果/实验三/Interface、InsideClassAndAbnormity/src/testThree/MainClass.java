package testThree;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog=new Dog();
		String[] state={"����������ǰ��","���������ˣ�","���������ѣ�","������ͬ�飺"};
		for(int i=0;i<state.length;i++){
			if(state[i].equals("����������ǰ��"))dog.state=new DogOne();
			else if(state[i].equals("���������ˣ�"))dog.state=new DogTwo();
			else if(state[i].equals("���������ѣ�"))dog.state=new DogThree();
			else if(state[i].equals("������ͬ�飺"))dog.state=new DogFour();
			else
				continue;
			System.out.print(state[i]);
			dog.show();
		}

	}

}
