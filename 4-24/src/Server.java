import java.net.*;
import java.io.*;

public class Server {
public static void main(String[] args) throws IOException {
int portNumber = 9000;
ServerSocket serverSocket = new ServerSocket(portNumber);
        Manager manager = new Manager();
//This loop will run and wait for one connection at a time.
while(true){
System.out.println("Waiting for a connection");

//Wait for a connection.
           Socket clientSocket=null;
try {
   clientSocket = serverSocket.accept();
            }
            catch(Exception e ) {
                System.out.println("ERROR IN SERVER");
            }
//Once a connection is made, run the socket in a ServerThread.
            ServerThread temp =new ServerThread(clientSocket,manager);
            Thread thread = new Thread(temp);
            thread.start();
            manager.add(temp);

}
}
}