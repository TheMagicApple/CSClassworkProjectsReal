
public class ArrayTest {
	public void printArray(int[] a) {
		for(int i:a) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public int search(int s,int[] a) {
		for(int i=0;i<a.length;i++) {
			if(a[i]==s) {
				return i;
			}
		}
		return -1;
	}
	public void scramble(int[] a) {
		for(int i=0;i<a.length;i++) {
			int r=(int)(Math.random()*a.length);
			
			int temp=a[i];
			a[i]=a[r];
			a[r]=temp;
		}
	}
	public void sort(int[] a) {
		for(int i=0;i<a.length;i++) {
			for(int k=0;k<a.length-1;k++) {
				if(a[k]>a[k+1]) {
					int temp=a[k];
					a[k]=a[k+1];
					a[k+1]=temp;
				}
			}
		}
	}
}
