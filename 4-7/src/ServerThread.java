import java.net.*;
import java.io.*;
public class ServerThread implements Runnable{	
	private Socket clientSocket;
	public ServerThread(Socket clientSocket){
		this.clientSocket = clientSocket;
	}

	public void run(){
		System.out.println(Thread.currentThread().getName() + ": connection opened.");
		try{
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            int[] nums = new int[]{0,1,2};
            for (int i = 0;i<nums.length;i++) {
                int temp= nums[i];
                int randex = (int)(Math.random()*3);
                nums[i]=nums[randex];
                nums[randex]=temp;
            }
            //Faroe Islands - 0
            //South Africa - 1
            //Monaco - 2
            for (int i = 0;i<nums.length;i++) {
                out.println(nums[i]);
                String ans = in.readLine().toUpperCase();
                if (nums[i]==0 && ans.equals("FAROE ISLANDS")) {
                    out.println("correct");
                }
                else if (nums[i]==1&&ans.equals("SOUTH AFRICA")) {
                    out.println("correct");
                }
                else if (nums[i]==2&&ans.equals("MONACO")) {
                    out.println("correct");
                }
                else {
                	out.println("incorrect");
                }
            }


			//Clears and close the output stream.
			out.flush();
			out.close();
			System.out.println(Thread.currentThread().getName() + ": connection closed.");
		} catch (IOException ex){
			System.out.println("Error listening for a connection");
			System.out.println(ex.getMessage());
		}
	}
}
	



