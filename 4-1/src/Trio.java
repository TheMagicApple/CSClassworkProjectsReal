
public class Trio implements MenuItem{
	private Sandwich sandwich;
	private Salad salad;
	private Drink drink;
	public Trio(Sandwich sandwich,Salad salad,Drink drink) {
		this.sandwich=sandwich;
		this.salad=salad;
		this.drink=drink;
	}
	@Override
	public String getName() {
		return sandwich.getName()+"/"+salad.getName()+"/"+drink.getName()+" Trio";
	}
	@Override
	public double getPrice() {
		double lowestPrice=sandwich.getPrice();
		if(salad.getPrice()<lowestPrice) {
			lowestPrice=salad.getPrice();
		}
		if(drink.getPrice()<lowestPrice) {
			lowestPrice=drink.getPrice();
		}
		return sandwich.getPrice()+salad.getPrice()+drink.getPrice()-lowestPrice;
	}
	
	
}
