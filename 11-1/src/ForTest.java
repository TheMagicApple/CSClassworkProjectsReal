
public class ForTest {
	public void printCount() {
		for(int i=1;i<=100;i++) {
			System.out.println(i);
		}
	}
	public void printCount(int n) {
		for(int i=1;i<=n;i++) {
			System.out.println(i);
		}
	}
	public void printCount(int n,int n2) {
		for(int i=n;i<=n2;i++) {
			System.out.println(i);
		}
	}
	public int getFactorial(int n) {
		int f=1;
		for(int i=n;i>=1;i--) {
			f*=i;
		}
		return f;
	}
}
