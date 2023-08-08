import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Manager {
	ArrayList<ServerThread> clients=new ArrayList<>();
	public void add(ServerThread client) {
		clients.add(client);
	}
	public void broadcast(String message,String username) {
		String host="10.210.113.163";
		int port=9000;
		for(ServerThread client:clients) {
			client.send(username+": "+message);
		}
	}
}
