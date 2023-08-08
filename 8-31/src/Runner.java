import java.util.ArrayList;

public class Runner {
	public static void main(String[] args) {
		ArrayList<MyItem> myItems=new ArrayList<>();
		myItems.add(new MyItem("Hello"));
		myItems.add(new MyItem(5));
		myItems.add(new MyItem(3.1));
		for(MyItem myItem:myItems) {
			System.out.println(myItem.get());
		}
	}
}

