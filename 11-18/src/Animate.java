
public class Animate implements Runnable{
	private Screen s;
	public Animate(Screen s) {
		this.s=s;
	}
	@Override
	public void run() {
		while(true) {
			s.repaint();
			try {
				Thread.sleep(9);
			} catch (InterruptedException e) {
				System.out.println("i was interrupted :(");
				return;
			}
			if(Thread.currentThread().isInterrupted()) {
				return;
			}
		}
		
	}
	
}
