
public class ArrayTest {
	private String[] words;
	public ArrayTest() {
		words=new String[5];
		words[0]="Dog";
		words[1]="Cat";
		words[2]="Fish";
		words[3]="Penguin";
		words[4]="Bear";
	}
	public void printWords() {
		for(String w:words) {
			System.out.print(w+" ");
		}
		System.out.println();
	}
	public void swapWords(int a,int b) {
		String t=words[a];
		words[a]=words[b];
		words[b]=t;
	}
}
