
public class WarmUp {
	private int[][] numMatrix;
	public WarmUp(int[][] i) {
		numMatrix=i;
	}
	public void print() {
		for(int a=0;a<numMatrix.length;a++) {
			for(int b=0;b<numMatrix[a].length;b++) {
				System.out.print(numMatrix[a][b]+"\t");
			}
			System.out.println();
		}
	}
	public int findLargest() {
		int largest=numMatrix[0][0];
		for(int a=0;a<numMatrix.length;a++) {
			for(int b=0;b<numMatrix[a].length;b++) {
				if(numMatrix[a][b]>largest) {
					largest=numMatrix[a][b];
				}
			}
		}
		return largest;
	}
}
