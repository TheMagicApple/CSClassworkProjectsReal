import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) throws IOException {

        String hostName = "localhost";
        int portNumber = 1024 ;
        Socket serverSocket = new Socket(hostName, portNumber);
        BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                //Waiting for input from the server
                String fromServer = in.readLine();
                System.out.println("Server: " + fromServer);
   
            } catch (UnknownHostException e) {
                System.err.println("Don't know about host " + hostName);
                System.exit(1);
                out.close();
                in.close();
            } catch (IOException e) {
                System.err.println("Error connecting to " + hostName);
                System.exit(1);
                out.close();
                in.close();
            }

            sc.nextLine();
            out.println(sc.nextLine());
        }
    }
}
