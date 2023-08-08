
public class Runner2 {

	public static void main(String[] args) {
		Manager m=new Manager();
		System.out.println(m);
		SimpleThread st=new SimpleThread(m);
		Thread[] threadList=new Thread[5];
		for(int i=0;i<5;i++) {
			threadList[i]=new Thread(st);
			threadList[i].start();
			
		}
		threadList[0].join();
		threadList[1].join();
		threadList[2].join();
		threadList[3].join();
		threadList[4].join();
		System.out.println(m);
		

	}

}
