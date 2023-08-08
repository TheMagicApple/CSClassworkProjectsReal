import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
	Socket server;
	BufferedReader read;
	PrintWriter write;
	public ArrayList<String[]> images=new ArrayList<>();
	public int location;
	String guess;
	public void connect() throws IOException {
		images.add(new String[] {"faroe1.png","faroe2.png","faroe3.png"});
		images.add(new String[] {"southafrica1.png","southafrica2.png","southafrica3.png"});
		images.add(new String[] {"monaco1.png","monaco2.png","monaco3.png"});
		images.add(new String[] {"win.jpg","win.jpg","win.jpg"});
		String host="localhost";
		int port=9000;
		try {
			server=new Socket(host,port);
			write = new PrintWriter(server.getOutputStream(), true);
			read=new BufferedReader(new InputStreamReader(server.getInputStream()));
			
			(new Thread() {
				  public void run() {
					  for(int i=0;i<3;i++) {
						 try {
							location=Integer.parseInt(read.readLine());
							while(guess==null) {
								//...
							}
							write.println(guess);
							String response=read.readLine();
							System.out.println(response);
							guess=null;
							System.out.println(i);
							if(!response.equals("correct")) {
								System.exit(0);
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					  }
					  System.out.println("YOU WIN!!!");
					  location=3;
				  }
				 }).start();
			
		}catch(IOException e) {
			throw(new IOException()); //:)
		}
	}
	public void guess(String s) {
		this.guess=s;
	}
}
