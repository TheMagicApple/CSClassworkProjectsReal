import java.util.List;
import java.util.ArrayList;

public class MultipleGroups
{
	private List<NumberGroup> groupList;
	
	public MultipleGroups()
	{
		groupList = new ArrayList<NumberGroup>();
		groupList.add( new Range(5,8) );
		groupList.add( new Range(10,12) );
		groupList.add( new Range(1,6) );
	}
	
	
	public boolean contains(int num)
	{
		for(NumberGroup group:groupList){
			if(group.contains(num)){
				return true;
			}
		}
		return false;
	
	}
}
