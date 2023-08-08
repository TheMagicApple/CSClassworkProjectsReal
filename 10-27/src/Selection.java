
public class Selection {
	public String zipCode1(int zipCode) {
		if(zipCode==94040) {
			return "Mountain View";
		}else if(zipCode==94115) {
			return "San Francisco";
		}else if(zipCode==95051) {
			return "Santa Clara";
		}else {
			return "Not Valid";
		}
	}
	public String zipCode2(int zipCode) {
		String city;
		switch(zipCode) {
		case 95129:
			city="San Jose";
			break;
		case 94607:
			city="Oakland";
			break;
		case 95035:
			city="Milpitas";
			break;
		default:
			city="Not Valid";
		}
		return city;
	}
	public String zipCode3(int zipCode) {
		 if(zipCode==94301) {
			 return "Palo Alto";
		 }
		 if(zipCode==94086) {
			 return "Sunnyvale";
		 }
		 if(zipCode==95037) {
			 return "Morgan Hill";
		 }
		 return "Not Valid";
	}
	
}
