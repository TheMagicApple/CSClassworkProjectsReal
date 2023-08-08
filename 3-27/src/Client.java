import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
	public static void main(String[] args) throws IOException {
		String host="localhost";
		int port=1024;
		Scanner s=new Scanner(System.in);
		try {
			Socket server=new Socket(host,port);
			BufferedReader read=new BufferedReader(new InputStreamReader(server.getInputStream()));
			PrintWriter write=new PrintWriter(server.getOutputStream(),true);
			for(int i=0;i<5;i++) {
				String question=read.readLine();
				System.out.println(question);
				write.println(s.next());
				String response=read.readLine();
				System.out.println(response);
			}
		}catch(IOException e) {
			throw(new IOException());
		}
	}
}