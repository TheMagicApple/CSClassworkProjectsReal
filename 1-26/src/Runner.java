import java.util.ArrayList;

public class Runner {

	public static void main(String[] args) {
		ArrayList<Card> cards=new ArrayList<>();
		cards.add(new Card(5,"Hearts"));
		cards.add(new Card(7,"Clubs"));
		cards.add(new Card(3,"Hearts"));
		for(Card card:cards) {
			System.out.println(card);
		}
	}

}
