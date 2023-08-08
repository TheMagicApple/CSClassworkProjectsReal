import java.util.ArrayList;

public class ClubMembers
{
	private ArrayList<MemberInfo> memberList;
	
	public ClubMembers(){
		memberList = new ArrayList<MemberInfo>();
	}
	
	
	/** Adds new club members to memberList, as described in part (a).
	* Precondition: names is a non-empty array.
	*/
	public void addMembers(String[] names, int gradYear)
	{ /* to be implemented in part (a) */ 
		for(String name:names) {
			memberList.add(new MemberInfo(name,gradYear,true));
		}
	}
	
	
	/** Removes members who have graduated and returns a list of members who have graduated
	* and are in good standing, as described in part (b).
	*/
	public ArrayList<MemberInfo> removeMembers(int year)
	{ /* to be implemented in part (b) */ 
		ArrayList<MemberInfo> goodGraduates=new ArrayList<>();
		for(int i=0;i<memberList.size();i++) {
			if(memberList.get(i).inGoodStanding() && memberList.get(i).getGradYear()<=year) {
				goodGraduates.add(memberList.get(i));
			}
			if(memberList.get(i).getGradYear()<=year) {
				memberList.remove(i);
				i--;
			}
		}
		return goodGraduates;
	}
	
	// There may be instance variables, constructors, and methods that are not shown.
	public String toString(){
		String txt = "";
		for(int i=0; i<memberList.size(); i++){
			txt += memberList.get(i).toString();
		}
		return txt;
		
	}
	
	
	public void setupPartB(){
		memberList.add(new MemberInfo("SMITH, JANE", 2019, false));
		memberList.add(new MemberInfo("FOX, STEVE", 2018, true));
		memberList.add(new MemberInfo("XIN, MICHAEL", 2017, false));
		memberList.add(new MemberInfo("GARCIA, MARIA", 2020, true));
	}
} 