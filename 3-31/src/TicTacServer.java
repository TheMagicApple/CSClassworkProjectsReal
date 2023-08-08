import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TicTacServer {
	Socket server;
	ObjectInputStream read;
	ObjectOutputStream write;
	String move=null;
	boolean myTurn=true;
	//public int[][] grid=new int[][] {{0,0,0},{0,0,0},{0,0,0}};
		public Game game;
	public void connect() throws IOException {
		game=new Game();
		String host="localhost";
		int port=9000;
		try {
			ServerSocket server=new ServerSocket(port);
			Socket client=server.accept();
			write=new ObjectOutputStream(client.getOutputStream());
			read=new ObjectInputStream(client.getInputStream());
			(new Thread() {
				  public void run() {
					  while(true) {
						  if(myTurn) {
								if(move!=null) {
									  //write.println(move);
									try {
										write.writeObject(game);
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}								 
									move=null;
									  myTurn=false;
									  
								 }else {
									 System.out.print("");
								 }
							 }else {
								 Game hisMove;
									try {
										//System.out.println("WAITING FOR HIS MOVE");
										hisMove =(Game) read.readObject();
										game=hisMove;
										//System.out.println("READ HIS MOVE");
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									 //System.out.println("he played: "+hisMove);
									 catch (ClassNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									myTurn=true;
						 
					  }
				  }
				 }}).start();
			
		}catch(IOException e) {
			throw(new IOException()); //:)
		}
	}
	public void play(int i,int j) {
		if(myTurn) {
			move=i+" "+j;
			game.grid[i][j]=2;
		}
	}
}
