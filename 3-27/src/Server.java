import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	public static void main(String[] args) throws IOException {
		int port=1024;
		try {
			ServerSocket server=new ServerSocket(port);
			Socket client=server.accept();
			BufferedReader read=new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter write=new PrintWriter(client.getOutputStream(),true);
			String[][] questions=new String[][] {{"What is the capital of California","Sacramento"},{"Which country is above America?","Canada"},{"Which country is Niagara falls in?","Canada"},{"Which state has the most people?","California"},{"How many capitals does South Africa have?","3"}};
			for(int i=0;i<5;i++) {
				write.println(questions[i][0]);
				String answer=read.readLine();
				if(answer.equals(questions[i][1])) {
					write.println("Correct!");
				}else {
					write.println("Incorrect :(");
				}
			}
		}catch(IOException e) {
			throw(new IOException());
		}
	}
}