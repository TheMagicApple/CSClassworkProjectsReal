public class Info{
    public String name;
    private String capital;
    private int population;
    public Info(String name, String capital, int population){
        this.name = name;
        this.population = population;
        this.capital = capital;
    }
    public String toString() {
    	return name+" "+population+" "+capital;
    }


}