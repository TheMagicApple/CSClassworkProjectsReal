public class Runner {
	public static void main(String[] args) {
		School mvhs=new School("MVHS",1);
		School lahs=new School("LAHS",2);
		MyHashTable<School,String> table=new MyHashTable<>();
		table.put(mvhs, "Jose");
		table.put(mvhs, "Jen");
		table.put(lahs, "John");
		table.put(lahs, "Jane");
		DLList d=table.keySet().toDLList();
		System.out.println(d);
		System.out.println(table.toString());
		table.remove(mvhs,"Jose");
		System.out.println(table.toString());
		table.remove(lahs);
		System.out.println(table.toString());
	}
}