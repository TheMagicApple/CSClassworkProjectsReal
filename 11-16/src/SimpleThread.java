
public class SimpleThread implements Runnable{
	private Manager manager;
	public SimpleThread(Manager manager) {
		this.manager=manager;
		
	}
	@Override
	public void run() {
		manager.doubleIt();
		
		
	}
	
}
