
public class StateInfo {
	private String capital;
	private int population;
	private int size;
	private DLList<String> pictures;
	public StateInfo(String capital,int population,int size,String... picture) {
		this.capital=capital;
		this.population=population;
		this.size=size;
		pictures=new DLList<String>();
		for(String pic:picture) {
			pictures.add(pic);
		}
	}
	public String toString() {
		return capital+" "+population+" people "+size+"m^2";
	}
	public DLList<String> getImages(){
		return pictures;
	}
	public void addImage(String pic) {
		pictures.add(pic);
	}
}
