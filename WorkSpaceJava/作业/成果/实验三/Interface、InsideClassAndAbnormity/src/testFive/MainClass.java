package testFive;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods[] goods=new Goods[6];
		goods[0]=new Goods("ƻ��",false);
		goods[1]=new Goods("ըҩ",true);
		goods[2]=new Goods("����",false);
		goods[3]=new Goods("����",true);
		goods[4]=new Goods("�ֱ�",false);
		goods[5]=new Goods("���",true);
		
		for(int i=0;i<goods.length;i++){
			Machine machine=new Machine();
			try{
				machine.checkBag(goods[i]);
				System.out.println(goods[i].name+"����Σ��Ʒ��"+goods[i].name+"���ͨ��");
			}
			catch(DangerException e){
				e.toShow();
				System.out.println("!"+goods[i].name+"����ֹ��");
			}
		}

	}

}
