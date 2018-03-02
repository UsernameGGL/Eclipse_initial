package java_two;

import java.io.File;
import java.io.IOException;
 class Class_one{
	void f(double d1){System.out.println("daxie!");}
	void f(float d2){System.out.println("xiaoxie!");}
}
public class Class_two {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("111");
		File file_one=new File("11.docx");
		try {
			file_one.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis());
		Class_one c1 = new Class_one();
		c1.f(1.0);
	}

}
