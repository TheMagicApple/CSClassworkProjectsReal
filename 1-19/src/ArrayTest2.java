
public class ArrayTest2 {
	public void printArray(int[] in) {
		for(int i:in) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public void printArray(String[] st) {
		for(String s:st) {
			System.out.print(s+" ");
		}
		System.out.println();
	}
	public int search(int s,int[] in) {
		for(int i=0;i<in.length;i++) {
			if(in[i]==s) {
				return i;
			}
		}
		return -1;
		
	}
	public void scramble(int[] in) {
		for(int i=0;i<in.length;i++) {
			int index=(int)((Math.random())*in.length);
			
			int temp=in[i];
			in[i]=in[index];
			in[index]=temp;
		}
	}
	public void scramble(String[] st) {
		for(int i=0;i<st.length;i++) {
			int index=(int)((Math.random())*st.length);
			
			String temp=st[i];
			st[i]=st[index];
			st[index]=temp;
		}
	}
	public void sort(int[] in) {
		for(int i=0;i<in.length;i++) {
			for(int k=0;k<in.length-1;k++) {
				if(in[k]>in[k+1]) {
					int temp=in[k];
					in[k]=in[k+1];
					in[k+1]=temp;
				}
			}
		}
	}
	
}
