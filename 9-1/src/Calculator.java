import java.util.Scanner;
public class Calculator {
    public static void main (String[] args) throws Exception{
        boolean done = false;
        Scanner s = new Scanner(System.in);
        while (!done) {
            System.out.println("Pick a shape to calculate:");
            System.out.println("1.) Square");
            System.out.println("2.) Rectangle");
            System.out.println("3.) Triangle");
            System.out.println("4.) Hexagon");
            System.out.println("5.) Dodecahedron");
            System.out.println("6.) Rhombisododecahedron");
            System.out.println("7.) Megagon");
            System.out.println("8.) Teragon");
            System.out.println("9.) Ultragon");
            System.out.println("10.) 6-Sphere");
            System.out.println("11.) Done");
            int selection = s.nextInt();
            if (selection == 1) {
                System.out.println("One side of the square is ");
                double squareSide=s.nextDouble();
                System.out.println("The area of the square is " + squareSide * squareSide);
            }
            else if (selection == 2 ) {
                System.out.println("The base of the rectangle is ");
                double baseSize=s.nextDouble();
                System.out.println("The height of the rectangle is ");
                double rectHeight=s.nextDouble();
                System.out.println("The area of the rectangle is " + rectHeight * baseSize);
            }
            else if (selection == 3 ) {
                System.out.println("The base of the triangle is ");
            double triangleBase=s.nextDouble();
            System.out.println("The height of the triangle is ");
            double triangleHeight=s.nextDouble();
            System.out.println("The area of the triangle is " + 0.5 * triangleBase + triangleHeight);
            }
            else if (selection == 4 ) {
                System.out.println("Side of hexagon is ");
            double hexSide=s.nextDouble();
            System.out.println("The area of the hexagon is " + (3*Math.sqrt(3)/2*(hexSide*hexSide)));
            }
            else if (selection == 5 ) {
                System.out.println("The side of the dodecahedron is ");
                double doSide=s.nextDouble();
                System.out.println("Volume of dodecahedron: "+((15+(7*Math.sqrt(5)))/4)*(doSide*doSide*doSide));
            }
            else if (selection == 6 ) {
                System.out.println("Side of rhombicosidodecahedron ");
                double rhomSide=s.nextDouble();
                double surface_area=(rhomSide*rhomSide)*(30+(5*Math.sqrt(3))+(3*Math.sqrt(25+(10*Math.sqrt(5)))));
                System.out.println("Surface area of rhombicosidodecahedron:"+surface_area);
            }
            else if (selection == 7 ) {
                System.out.println("The side length of the megagon is");
                double megagonSide=s.nextDouble();
                System.out.printf("The area of the MEGAGON is %.0f",250000*megagonSide*megagonSide*1/Math.tan(Math.PI/1000000));
                System.out.println();
            }
            else if (selection == 8 ) {
                System.out.println("The side of the TERAGON is ");
                double teragonSide=s.nextDouble();
                System.out.printf("The area of the TERAGON is %.0f",250000000000f*teragonSide*teragonSide*1/Math.tan(Math.PI/1000000000000f));
                System.out.println();
            }
            else if (selection == 9 ) {
                System.out.println("The side of the ULTRAGON is ");
                double ultragonSide=s.nextDouble();
                System.out.printf("The area of the ULTRAGON is %.0f",(9223372036854775807l/4)*ultragonSide*ultragonSide*1/Math.tan(Math.PI/9223372036854775807l));
                System.out.println();
            }
            else if (selection == 10 ) {
                System.out.println("The radius of the 6-sphere is ");
                double radiusSixSphere=s.nextDouble();
                System.out.printf("The volume of the 6-sphere is %.0f",(16*Math.pow(Math.PI,3)*Math.pow(radiusSixSphere,7))/105);
                System.out.println();
            }
            else if (selection == 11 ) {
                done = true;
            }
            
            
        }

    }
}
