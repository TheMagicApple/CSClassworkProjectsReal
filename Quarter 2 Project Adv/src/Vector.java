
public class Vector {
	public int x;
	public int y;
	public Vector(int x,int y) {
		this.x=x;
		this.y=y;
	}
	@Override
	public int hashCode() {
		return x*29+y*299;
	}
	@Override
	public boolean equals(Object other) {
		return other.hashCode()==hashCode();
	}
}
