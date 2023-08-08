public class Runner {
	public static void main(String[] args) {
		DLList<Food> f=new DLList<>();
		f.add(new Food("Milk",2.99));
		f.add(new Food("Cereal",3.99));
		f.add(new Food("Juice",2.99));
		f.add(new Food("Peanut Butter",2.50));
		System.out.println(f);
		int random=(int)(Math.random()*f.size());
		System.out.println(random);
		System.out.println(f.get(random));
		f.remove(new Food("Juice",2.99));
		System.out.println(f);
		
	}
}