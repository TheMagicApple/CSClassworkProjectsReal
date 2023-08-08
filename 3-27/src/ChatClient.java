import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) throws IOException {
		String host="localhost";
		int port=1024;
		Scanner s=new Scanner(System.in);
		try {
			Socket server=new Socket(host,port);
			BufferedReader read=new BufferedReader(new InputStreamReader(server.getInputStream()));
			PrintWriter write=new PrintWriter(server.getOutputStream(),true);
			while(true) {
				System.out.println(read.readLine());
				/*
				String send=s.nextLine();
				write.println(send);
				if(send.equals("bye")) {
					break;
				}
				String response=read.readLine();
				System.out.println(response);
				*/
			}
			//read.close();
			//write.close();
			
			
		}catch(IOException e) {
			throw(new IOException());
		}

	}

}
