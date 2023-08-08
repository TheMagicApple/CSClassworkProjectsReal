import java.util.ArrayList;
import java.util.Collections;

public class Test {
	private ArrayList<Integer> numList;
	public Test() {
		numList=new ArrayList<>();
		for(int i=0;i<10;i++) numList.add((int)(Math.random()*10+1));
	}
	public void printList() {
		for(int num:numList) {
			System.out.print(num+" ");
		}
		System.out.println();
	}
	public int searchLargest() {
		int largest=0;
		for(int num:numList) {
			if(num>largest) {
				largest=num;
			}
		}
		return largest;
			
	}
	public void searchAndReplace(int a) {
		for(int i=0;i<numList.size();i++) {
			if(numList.get(i)==a) {
				numList.set(i, 1000);
			}
		}
	}
	public void searchAndRemove(int a) {
		for(int i=0;i<numList.size();i++) {
			if(numList.get(i)==a) {
				numList.remove(i);
				i--;
			}
		}
	}
	public void scramble() {
		for(int i=0;i<numList.size();i++) {
			int choice=(int)(Math.random()*numList.size());
			
			int temp=numList.get(i);
			numList.set(i, numList.get(choice));
			numList.set(choice, temp);
		}
	}
	public void sort() {
		Collections.sort(numList);
	}
}
