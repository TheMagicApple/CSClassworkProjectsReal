import java.util.ArrayList;
public class Range implements NumberGroup{
	private ArrayList<Integer> group=new ArrayList<>();
	public Range(int start,int end){
		int i=start;
		while(i<=end){
			group.add(i);
			i++;
		}
	}
	
	public boolean contains(int n){
		for(int i:group){
			if(i==n){
				return true;
			}
		}
		return false;
	}

}
