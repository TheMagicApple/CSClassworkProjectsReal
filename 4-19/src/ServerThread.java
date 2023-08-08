import java.net.*;
import java.io.*;
public class ServerThread implements Runnable{	
	private Socket clientSocket;
    private String username;
   
    private Manager manager;
    PrintWriter out;
	public ServerThread(Socket clientSocket, Manager manager){
		this.clientSocket = clientSocket;
        username ="USER";
        this.manager = manager;
	}
    public void send( String message) {
        out.println(message);
    }
	public void run(){
		System.out.println(Thread.currentThread().getName() + ": connection opened.");
		try{
			out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            username=in.readLine();
            while(true) {
                manager.broadcast(in.readLine(), username);
            }
        }
        catch(Exception e ) {
            System.out.println("EXCEPTION: error in ServerThread");
        }

	}
}
	



