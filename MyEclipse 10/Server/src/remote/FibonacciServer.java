package remote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class FibonacciServer {
	public static void main(String[] args) {
		try {
			FibImp f = new FibImp();
			// ×¢²áµ½ registry ÖÐ
			Naming.rebind("fib", f);
			System.out.println("fib server ready");
		} catch (RemoteException re) {
			System.out.println("Exception in FibonacciImpl.main: " + re);
		} catch (MalformedURLException e) {
			System.out.println("MalformedURLException " + e);
		}
	}
}
