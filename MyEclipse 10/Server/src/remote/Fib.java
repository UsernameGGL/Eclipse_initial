package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.math.BigInteger;

public interface Fib extends Remote {
	public BigInteger getFib(int n) throws RemoteException;

	public BigInteger getFib(BigInteger n) throws RemoteException;
}
