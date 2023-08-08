import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Manager {
    private ServerThread selected;
    ArrayList<ServerThread> clients=new ArrayList<>();
    private String[] wordList;
    private String currentWord;
    public Manager() {
        wordList = new String[]{"Frog","Cat","Car","Tree","Bird"};
    }
    public void add(ServerThread client) {
        clients.add(client);
        System.out.println(clients);
        if (clients.size()>1&&selected==null) {
            pickClient();
        }
    }
    public void pickClient(){
        int rand=(int)(Math.random()*clients.size());
        selected = clients.get(rand);
        /*
        while (selected== clients.get(rand)) {
            rand=(int)(Math.random()*clients.size());

            selected=clients.get(rand);
        }
        */
        currentWord =wordList[(int)(Math.random()*wordList.length)];
        System.out.println("word|"+currentWord);
        broadcast("word|"+currentWord,null);
        selected.changeSelection(true);
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        broadcast("artist|"+selected.username,null);
    }
    public void broadcast(String message,ServerThread c) {
       System.out.println(message);
        for(ServerThread client:clients) {
            client.send(message);
        }
        String[] messages = message.split("|");
        if (messages[0].equals("guess")&&messages[1].toLowerCase().equals(currentWord)) {
            for(ServerThread client:clients) {
                client.send("winner|"+c.username);
                selected.changeSelection(false);
                pickClient();
            }
        }
    }
}