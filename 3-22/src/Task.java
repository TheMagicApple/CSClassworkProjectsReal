public class Task implements Comparable<Task> {
	private String name;
	private int num;
	public Task(String name, int num) {
		this.name = name;
		this.num = num;
	}
	public int getPriority() {
		return num;
	}
	public int compareTo(Task object) {
		if (object.getPriority()-this.getPriority()==0) {
			return 0;
		}
		return Math.max(Math.min(this.getPriority() - object.getPriority(),1),-1);
	}
	public String toString() {
		return num+": "+name;
	}
}
