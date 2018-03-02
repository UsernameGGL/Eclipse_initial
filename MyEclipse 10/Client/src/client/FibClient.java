package client;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import core.Fib;

public class FibClient {
	public static void main(String[] args) {
		String url = "rmi://domainforggl.xin/fib";
		try {
			Fib calc = (Fib) Naming.lookup(url);
			BigInteger f = calc.getFib(10);
			System.out.println(f);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
