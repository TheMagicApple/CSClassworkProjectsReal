public class Runner {
	public static void main(String[] args) {
		Item<ToDo> i1=new Item<>(new ToDo("clean room",1));
		Item<ToDo> i2=new Item<>(new ToDo("advcs lab",2));
		Item<String> i3=new Item<>("Bob");
		Item<String> i4=new Item<>("Carl");
		Item<Integer> i5=new Item<>((int)(Math.random()*10+1));
		Item<Integer> i6=new Item<>((int)(Math.random()*10+1));
		System.out.println(i1.get());
		System.out.println(i2.get());
		System.out.println(i3.get());
		System.out.println(i4.get());
		System.out.println(i5.get());
		System.out.println(i6.get());
	}
}