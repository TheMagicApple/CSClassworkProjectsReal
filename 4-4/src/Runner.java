
public class Runner {

	public static void main(String[] args) {
		Vampire v=new Vampire("vampire");
		Mummy m=new Mummy("mummy");
		Witch w=new Witch("witch");
		v.getInfo();
		m.getInfo();
		w.getInfo();
		v.addCoins(5);
		m.addCoins(10);
		w.addCoins(7);
		System.out.println(Monster.getCount());
		System.out.println(Monster.getCoins());

	}

}
