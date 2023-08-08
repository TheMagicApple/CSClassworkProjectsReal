import java.util.ArrayList;
public class WarmUp {

	public static void main(String[] args) {
		ArrayList<Integer> a=new ArrayList<>();
		for(int i=0;i<10;i++) {
			a.add((int)(Math.random()*999)+1);
		}
		System.out.println(a);
	}

}
