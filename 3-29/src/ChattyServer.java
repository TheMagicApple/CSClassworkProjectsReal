import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class ChattyServer {
	public static void main(String[] args) throws IOException {
		int port=1024;
		try {
			ServerSocket server=new ServerSocket(port);
			Socket client1=server.accept();
			BufferedReader read1=new BufferedReader(new InputStreamReader(client1.getInputStream()));
			PrintWriter write1=new PrintWriter(client1.getOutputStream(),true);
			System.out.println("CLIENT 1 CONNECTED");
			Socket client2=server.accept();
			BufferedReader read2=new BufferedReader(new InputStreamReader(client2.getInputStream()));
			PrintWriter write2=new PrintWriter(client2.getOutputStream(),true);
			System.out.println("CLIENT 2 CONNECTED");
			(new Thread() {
				  public void run() {
					  while(true) {
						  try {
								String read=read1.readLine();
								//System.out.println("CLIENT 1:"+read);
								write2.println(read);
								
								} catch (Exception e) {
									return;
						}
					  }
				  }
				 }).start();
			(new Thread() {
				  public void run() {
					  while(true) {
						  try {
								String read=read2.readLine();
								//System.out.println("CLIENT 2:"+read);
								write1.println(read);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									return;
						}
					  }
				  }
				 }).start();
		}catch(IOException e) {
			throw(new IOException());
		}
	}
}