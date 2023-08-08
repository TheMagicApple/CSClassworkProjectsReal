import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Client {
	Socket server;
	BufferedReader read;
	PrintWriter write;
	public String username="USER";
	public ArrayList<String> history=new ArrayList<>();
	public String grid="0000000000000000;0000000000000000;0000000000000000;0000000000000000;0000000000000000;0000000000000000;0000000000000000;0000000000000000;0000000000000000;0000000000000000;0000000000000000;0000000000000000;0000000000000000;0000000000000000;0000000000000000;0000000000000000";
	public boolean drawer;
	public String word;
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
							String[] reg=s.split("|");
							if(reg[0].equals("artist")) {
								System.out.println(reg[1]);
								System.out.println(username);
								if(reg[1].equals(username)) {
									drawer=true;
								}else {
									drawer=false;
								}
							}
							if(reg[0].equals("username")) {
								//username=reg[1];
								
								//write.println(username);
							}
							if(reg[0].equals("word")) {
								word=reg[1];
								System.out.println("WORD: "+word);
							}
							if(reg[0].equals("guess")) {
								history.add(reg[1]);
							}
							if(reg[0].equals("grid")) {
								grid=reg[1];
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
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
		
	}
	
}