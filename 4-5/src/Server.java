import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		int port=9000;
		try {
			ServerSocket server=new ServerSocket(port);
			while(true) {
				Socket client=server.accept();
				
				Thread thread=new Thread(new ServerThread(client));
				thread.start();
			}
		}catch(Exception e) {
			System.out.println("bro");
		}

	}

}
