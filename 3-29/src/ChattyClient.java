import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
public class ChattyClient {
	Socket server;
	BufferedReader read;
	PrintWriter write;
	
	public ArrayList<String[]> history=new ArrayList<>();
	public void connect() throws IOException {
		String host="10.210.113.163";
		int port=9000;
		try {
			server=new Socket(host,port);
			read=new BufferedReader(new InputStreamReader(server.getInputStream()));
			write=new PrintWriter(server.getOutputStream(),true);
			(new Thread() {
				  public void run() {
					  while(true) {
						  try {
								String s=read.readLine();
								
								history.add(new String[] {"Other user",s});
						  } catch (Exception e) {
								return;
						}
					  }
				  }
				 }).start();
			
		}catch(IOException e) {
			throw(new IOException()); //:)
		}
	}
	public void send(String message) {
		write.println(message);
		history.add(new String[] {"Me",message});
	}
	
}