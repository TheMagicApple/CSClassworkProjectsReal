
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
	public int sum() {
		int total=0;
		for(int a=0;a<numMatrix.length;a++) {
			for(int b=0;b<numMatrix[a].length;b++) {
				total+=numMatrix[a][b];
			}
		}
		return total;
	}
}
