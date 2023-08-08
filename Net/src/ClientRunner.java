import java.io.IOException;
import java.util.Scanner;

public class ClientRunner {

	public static void main(String[] args) throws IOException {
		Client c=new Client();
		c.go();
		Scanner s=new Scanner(System.in);
		while(true) {
			String ss=s.nextLine();
			c.write(ss);
		}

	}

}
