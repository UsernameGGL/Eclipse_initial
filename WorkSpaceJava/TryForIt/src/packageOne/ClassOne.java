package packageOne;

public class ClassOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String stringOne=new String("abc");
		String stringTwo="abc";
		String stringThree="abc";
		System.out.println(stringOne==stringTwo);
		System.out.println(stringOne.equals(stringTwo));
		System.out.println(stringThree==stringTwo);
		System.out.println(stringOne=="abc");
		System.out.println("abc"==stringTwo);

	}

}
