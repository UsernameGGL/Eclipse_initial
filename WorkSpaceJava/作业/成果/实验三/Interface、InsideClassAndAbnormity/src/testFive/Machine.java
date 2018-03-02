package testFive;

public class Machine {
	void checkBag(Goods goods) throws DangerException{
		if(goods.isDanger==true){
			throw new DangerException();
		}
	}
}
