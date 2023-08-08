
public class Menu {
	public String selectMenu1(int n) {
		if(n==1) {
			return "A";
		}else if(n==2) {
			return "B";
		}else if(n==3) {
			return "C";
		}else {
			return "not valid";
		}
	}
	public String selectMenu2(int n) {
		String result;
		switch(n) {
		case 1:
			result="X";
			break;
		case 2:
			result="Y";
			break;
		case 3:
			result="Z";
			break;
		default:
			result="not valid";
			break;
		}
		return result;
	}
}
