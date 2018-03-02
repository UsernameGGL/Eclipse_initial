package testFive;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods[] goods=new Goods[6];
		goods[0]=new Goods("苹果",false);
		goods[1]=new Goods("炸药",true);
		goods[2]=new Goods("西服",false);
		goods[3]=new Goods("硫酸",true);
		goods[4]=new Goods("手表",false);
		goods[5]=new Goods("硫磺",true);
		
		for(int i=0;i<goods.length;i++){
			Machine machine=new Machine();
			try{
				machine.checkBag(goods[i]);
				System.out.println(goods[i].name+"不是危险品！"+goods[i].name+"检查通过");
			}
			catch(DangerException e){
				e.toShow();
				System.out.println("!"+goods[i].name+"被禁止！");
			}
		}

	}

}
