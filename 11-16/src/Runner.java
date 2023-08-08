import java.util.Scanner;

public class Runner {

	public static void main(String[] args) throws InterruptedException {
		Scanner s=new Scanner(System.in);
		Thread thread=new Thread(new Count(),"Counter1");
		Thread threadthread=new Thread(new Count(),"Counter2");
		Thread threadthreadthread=new Thread(new Count(),"Counter3");
		thread.start();
		threadthread.start();
		threadthreadthread.start();
		try {
			thread.join();
			threadthread.join();
			threadthreadthread.join();
		}catch(Exception e) {
			
		}
		
		CountingStars c=new CountingStars();
		Thread threa=new Thread(c);
		threa.start();
		Thread.sleep(5000);
		threa.interrupt();
		System.out.println("Radius: ");
		int radius=s.nextInt();
		System.out.println("Height: ");
		int height=s.nextInt();
		AreaCircle a=new AreaCircle(radius);
		Thread t=new Thread(a);
		t.run();
		System.out.println(a.getArea());
		VolCylinder v=new VolCylinder(a.getArea(),height);
		Thread tt=new Thread(v);
		tt.run();
		System.out.println(v.getVolume());
	}

}
