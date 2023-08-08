
public class Trigger {
	private boolean on=false;
	private int secondsOn;
	public Trigger(int secondsOn) {
		this.secondsOn=secondsOn;
	}
	public void activate() {
		on=true;
		Thread t=new Thread() {
			public void run() {
				try {
					Thread.sleep(secondsOn*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				on=false;
			}
		};
		t.run();
	}
	public boolean isOn() {
		return on;
	}
}
