
public class Test {
	public int factorial(int x) {
		int f=x;
		while(x>1) {
			f*=x-1;
			x-=1;
		}
		return f;
	}
}
