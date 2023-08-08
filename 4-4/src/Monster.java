
public abstract class Monster {
	private String name;
	private static int count;
	private static int coins;
	public Monster(String name) {
		this.name=name;
		count++;
	}
	public abstract String getFavFood();
	public String getName() {
		return "My name is "+name;
	}
	public static int getCount() {
		return count;
	}
	public static void addCoins(int newcoins) {
		coins+=newcoins;
	}
	public static int getCoins() {
		return coins;
	}
	public void getInfo() {
		System.out.println(getName()+" "+getFavFood());
	}
}
