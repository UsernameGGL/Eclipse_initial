package remote;

import java.math.BigInteger;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class FibImp implements Fib {
	public FibImp() throws RemoteException {
		UnicastRemoteObject.exportObject(this);
	}

	@Override
	public BigInteger getFib(int n) throws RemoteException {
		return this.getFib(new BigInteger(Long.toString(n)));
	}

	@Override
	public BigInteger getFib(BigInteger n) throws RemoteException {
		System.out.println("Calculating the " + n + "th Fibonacci number");
		BigInteger zero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		if (n.equals(zero))
			return zero;
		if (n.equals(one))
			return one;
		BigInteger i = one;
		BigInteger a = zero;
		BigInteger b = one;
		while (i.compareTo(n) == -1) {
			BigInteger temp = b;
			b = b.add(a);
			a = temp;
			i = i.add(one);
		}
		return b;
	}
}
