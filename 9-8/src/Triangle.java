import java.util.Scanner;
public class Triangle {
    public void printArea(){
        Scanner s = new Scanner(System.in);
        System.out.println("What is the base of the triangle?");
        int triangleBase = s.nextInt();
        System.out.println("What is the height of the triangle?");
        int triangleHeight=s.nextInt();
        double area = (0.5 * triangleBase * triangleHeight);
        System.out.println("Triangle Area: "+area);
    }

}
