import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;

public class ArrayTest {
	public void printList(ArrayList<Card> deck) {
		for(Card card:deck) System.out.println(card);
	}
	public int findTotal(ArrayList<Card> deck) {
		return deck.stream().mapToInt(i->i.getValue()).sum();
	}
	public void searchAndDelete(ArrayList<Card> deck,int a) {
		deck.removeIf(c->(c.getValue()==a));
	}
	public void scramble(ArrayList<Card> deck) {
		Collections.shuffle(deck);
	}
	public void searchAndReplace(ArrayList<Card> deck,int a) {
		for(int i=0;i<deck.size();i++) {
			if(deck.get(i).getValue()==a) {
				deck.set(i, new Card(99));
			}
		}
	}
	public void sort(ArrayList<Card> deck) {
		for(int i=0;i<deck.size();i++) {
			for(int k=0;k<deck.size()-1;k++) {
				if(deck.get(k).getValue()>deck.get(k+1).getValue()) {
					Card temp=deck.get(k);
					deck.set(k, deck.get(k+1));
					deck.set(k+1, temp);
				}
			}
		}
	}
	
}
