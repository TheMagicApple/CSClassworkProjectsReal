
import java.net.*;
import java.io.*;
public class ServerThread implements Runnable{
private Socket clientSocket;
    public String username;
    private Manager manager;
    private boolean isSelected;
    PrintWriter out;
public ServerThread(Socket clientSocket, Manager manager){
this.clientSocket = clientSocket;
        this.manager = manager;
        isSelected=false;
       
}
    public void changeSelection(boolean b) {
        isSelected = b;
    }
    public void send( String message) {
    	try {
			out = new PrintWriter(clientSocket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	out.println(message);
    }
    public String getUsername() {
        return username;
    }
public void run(){
System.out.println(Thread.currentThread().getName() + ": connection opened.");
try{
out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            send("username|");
            username = in.readLine();
            System.out.println("USERNAME IS: "+username);
            while(true) {
                if (!isSelected) {
                    manager.broadcast("guess|"+username+": "+ in.readLine(),this);
                }
                else {
                    manager.broadcast("grid|" + in.readLine(),this);
                }
            }
        }
        catch(Exception e ) {
            System.out.println("EXCEPTION: error in ServerThread");
        }

}
}
