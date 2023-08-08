import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class ServerThread implements Runnable{
	HashMap<String,String> questions=new HashMap<>();
	Socket client;
	ArrayList<String> keys=new ArrayList<>();
	public ServerThread(Socket client) {
		this.client=client;
		questions.put("Name the capital(s) of South Africa in alphabetical order (no spaces)", "BloemfonteinCapetownPretoria");
		questions.put("Which side of the war was the leader that the largest city in Vietnam is named after?", "North");
		questions.put("What color is the vermont license plate?", "Green");
		questions.put("What country is Monaco in?", "France");
		questions.put("This city's name is a five letter word that sounds extremely similar to the first part of its country name?","Porto");
		questions.put("This island is below iceland and above Britain? (no spaces)", "Faroeislands");
		questions.put("This is the only country in South America that does not have google street coverage?", "Venezuela");
		questions.put("This country in South America has crosses on the back of all of their stop signs?", "Columbia");
		questions.put("The city of Malmo is located on the border of what 2 countries (name both countries, alphabetical order, no staces)?", "Denmarksweden");
		questions.put("This city in the UK is the only one whose name is three words long? (no spaces)", "Southendonsea");
		
		for(String question:questions.keySet()) {
			keys.add(question);
		}
		
	}
	public void run() {
		try {
			PrintWriter write=new PrintWriter(client.getOutputStream(),true);
			BufferedReader read=new BufferedReader(new InputStreamReader(client.getInputStream()));
			for(int i=0;i<10;i++) {
				String question=keys.get((int)(Math.random()*keys.size()));
				keys.remove(question);
				write.println(question);
				String answer=read.readLine();
				if(!answer.toLowerCase().equals(questions.get(question).toLowerCase())) {
					write.close();
					read.close();
					client.close();
					
				}
			}
			write.println("\r\n"
					+ "      _____                   _______                   _____                            _____                    _____                    _____          \r\n"
					+ "     |\\    \\                 /::\\    \\                 /\\    \\                          /\\    \\                  /\\    \\                  /\\    \\         \r\n"
					+ "     |:\\____\\               /::::\\    \\               /::\\____\\                        /::\\____\\                /::\\    \\                /::\\____\\        \r\n"
					+ "     |::|   |              /::::::\\    \\             /:::/    /                       /:::/    /                \\:::\\    \\              /::::|   |        \r\n"
					+ "     |::|   |             /::::::::\\    \\           /:::/    /                       /:::/   _/___               \\:::\\    \\            /:::::|   |        \r\n"
					+ "     |::|   |            /:::/~~\\:::\\    \\         /:::/    /                       /:::/   /\\    \\               \\:::\\    \\          /::::::|   |        \r\n"
					+ "     |::|   |           /:::/    \\:::\\    \\       /:::/    /                       /:::/   /::\\____\\               \\:::\\    \\        /:::/|::|   |        \r\n"
					+ "     |::|   |          /:::/    / \\:::\\    \\     /:::/    /                       /:::/   /:::/    /               /::::\\    \\      /:::/ |::|   |        \r\n"
					+ "     |::|___|______   /:::/____/   \\:::\\____\\   /:::/    /      _____            /:::/   /:::/   _/___    ____    /::::::\\    \\    /:::/  |::|   | _____  \r\n"
					+ "     /::::::::\\    \\ |:::|    |     |:::|    | /:::/____/      /\\    \\          /:::/___/:::/   /\\    \\  /\\   \\  /:::/\\:::\\    \\  /:::/   |::|   |/\\    \\ \r\n"
					+ "    /::::::::::\\____\\|:::|____|     |:::|    ||:::|    /      /::\\____\\        |:::|   /:::/   /::\\____\\/::\\   \\/:::/  \\:::\\____\\/:: /    |::|   /::\\____\\\r\n"
					+ "   /:::/~~~~/~~       \\:::\\    \\   /:::/    / |:::|____\\     /:::/    /        |:::|__/:::/   /:::/    /\\:::\\  /:::/    \\::/    /\\::/    /|::|  /:::/    /\r\n"
					+ "  /:::/    /           \\:::\\    \\ /:::/    /   \\:::\\    \\   /:::/    /          \\:::\\/:::/   /:::/    /  \\:::\\/:::/    / \\/____/  \\/____/ |::| /:::/    / \r\n"
					+ " /:::/    /             \\:::\\    /:::/    /     \\:::\\    \\ /:::/    /            \\::::::/   /:::/    /    \\::::::/    /                   |::|/:::/    /  \r\n"
					+ "/:::/    /               \\:::\\__/:::/    /       \\:::\\    /:::/    /              \\::::/___/:::/    /      \\::::/____/                    |::::::/    /   \r\n"
					+ "\\::/    /                 \\::::::::/    /         \\:::\\__/:::/    /                \\:::\\__/:::/    /        \\:::\\    \\                    |:::::/    /    \r\n"
					+ " \\/____/                   \\::::::/    /           \\::::::::/    /                  \\::::::::/    /          \\:::\\    \\                   |::::/    /     \r\n"
					+ "                            \\::::/    /             \\::::::/    /                    \\::::::/    /            \\:::\\    \\                  /:::/    /      \r\n"
					+ "                             \\::/____/               \\::::/    /                      \\::::/    /              \\:::\\____\\                /:::/    /       \r\n"
					+ "                              ~~                      \\::/____/                        \\::/____/                \\::/    /                \\::/    /        \r\n"
					+ "                                                       ~~                               ~~                       \\/____/                  \\/____/         \r\n"
					+ "                                                                                                                                                          \r\n"
					+ "");
		}catch(Exception e) {
			System.out.println("bro");
		}
	}
	
}
