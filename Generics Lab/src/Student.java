import java.awt.image.BufferedImage;

public class Student {
	private String name;
	private BufferedImage image;
	public Student(String name,BufferedImage image) {
		this.name=name;
		this.image=image;
	}
	public String toString() {
		return name;
	}
	public BufferedImage getImage() {
		return image;
	}
}
