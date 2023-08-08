
public class ArrayTest {
	private int[] numArray;
	private String[] stringArray;
	public ArrayTest() {
		numArray=new int[10];
		for(int i=0;i<numArray.length;i++) {
			numArray[i]=(int)(Math.random()*20)+1;
		}
		stringArray=new String[5];
		stringArray[0]="Dog";
		stringArray[1]="Cat";
		stringArray[2]="Fish";
		stringArray[3]="Dolphin";
		stringArray[4]="Panda";
	}
	public void printNumArray() {
		for(int n:numArray) {
			System.out.print(n+" ");
		}
		System.out.println();
	}
	public void printStringArray() {
		for(String s:stringArray) {
			System.out.print(s+" ");
		}
		System.out.println();
	}
	public void swapNumArray(int a,int b) {
		int temp1=numArray[a];
		int temp2=numArray[b];
		numArray[a]=temp2;
		numArray[b]=temp1;
	}
	public void swapStringArray(int a,int b) {
		String temp1=stringArray[a];
		String temp2=stringArray[b];
		stringArray[a]=temp2;
		stringArray[b]=temp1;
	}
	public int searchString(String s) {
		for(int i=0;i<stringArray.length;i++) {
			if(stringArray[i].equals(s)) {
				return i;
			}
		}
		return -1;
	}
	public int countLetter(char c) {
		int counter=0;
		for(String s:stringArray) {
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)==c) {
					counter++;
				}
			}
		}
		return counter;
	}
}
