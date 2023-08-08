
public class ArrayTest {
	private String[] words;
	public ArrayTest() {
		words=new String[5];
		words[0]="Dog";
		words[1]="Cat";
		words[2]="Fish";
		words[3]="Penguin";
		words[4]="Crab";
	}
	public void printWords() {
		for(String word:words) {
			System.out.print(word+" ");
		}
		System.out.println();
	}
	public void swapWords(int a,int b) {
		String tempA=words[a];
		String tempB=words[b];
		words[a]=tempB;
		words[b]=tempA;
	}
}
