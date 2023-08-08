
public class Item {
	private String name;
	private String store;
	public Item(String name,String store) {
		this.name=name;
		this.store=store;
	}
	public String toString() {
		return name+" "+store;
	}
	public String getName() {
		return name;
	}
	public String getStore() {
		return store;
	}
	public boolean equals(Object other) {
		return ((Item)other).getName().equals(name) && ((Item)other).getStore().equals(store);
	}
}
