import java.util.ArrayList;
import java.util.Collections;

public class Schedule {
	private ArrayList<Pair<Integer,String>> mySchedule;
	public Schedule() {
		mySchedule=new ArrayList<>();
	}
	public void addClass(int period,String name) {
		boolean periodOverlap=false;
		for(Pair pair:mySchedule) {
			if(Integer.parseInt( pair.getA().toString())==period) {
				periodOverlap=true;
			}
		}
		if(!periodOverlap) {
			Pair<Integer,String> newClass=new Pair<Integer,String>(period,name);
			mySchedule.add(newClass);
			for(int i=0;i<mySchedule.size();i++) {
				for(int k=0;k<mySchedule.size()-1;k++) {
					if(mySchedule.get(k).getA()>mySchedule.get(k+1).getA()) {
						Pair<Integer,String> temp=mySchedule.get(k);
						mySchedule.set(k, mySchedule.get(k+1));
						mySchedule.set(k+1, temp);
					}
				}
			}
				
				
		}
	}
	public ArrayList<String> toList() {
		ArrayList<String> myList=new ArrayList<>();
		
		for(Pair pair:mySchedule) {
			String s="";
			s+=pair.getA();
			s+=" : ";
			s+=pair.getB();
			myList.add(s);
		}
		return myList;
	}
	
}
