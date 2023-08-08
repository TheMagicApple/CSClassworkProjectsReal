
public class BinarySearch {
	private int pass;
	public void resetPass() {
		pass=0;
	}
	public int getPass() {
		return pass;
	}
	public int search(int[] a,int search,int start,int end) {
		if(a[start]==search)return start;
		if(start<end) {
			pass++;
			search(a,search,start+1,end);
		}
		pass++;
		return -1;
	}
}
