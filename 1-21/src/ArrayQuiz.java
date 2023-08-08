
public class ArrayQuiz {
	private int[] numList;
	public ArrayQuiz() {
		numList=new int[5];
		numList[0]=2;
		numList[1]=4;
		numList[2]=6;
		numList[3]=8;
		numList[4]=10;
	}
	public void printList() {
		for(int i:numList) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public int search(int s) {
		for(int i=0;i<numList.length;i++) {
			if(numList[i]==s) {
				return i;
			}
		}
		return -1;
	}
	public void scramble() {
		for(int i=0;i<numList.length;i++) {
			int choice=(int)(Math.random()*numList.length);
			
			int temp=numList[i];
			numList[i]=numList[choice];
			numList[choice]=temp;
		}
	}
	public void sort() {
		for(int i=0;i<numList.length;i++) {
			for(int k=0;k<numList.length-1;k++) {
				if(numList[k]>numList[k+1]) {
					int temp=numList[k];
					numList[k]=numList[k+1];
					numList[k+1]=temp;
				}
			}
		}
	}
}
