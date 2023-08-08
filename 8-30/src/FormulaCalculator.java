import java.util.Scanner;
public class FormulaCalculator{
 public static void main(String[] args){
   Scanner s=new Scanner(System.in);
   System.out.println("The base of the triangle is ");
   double triangleBase=s.nextDouble();
   System.out.println("The height of the triangle is ");
   double triangleHeight=s.nextDouble();
   System.out.println("The area of the triangle is " + 0.5 * (triangleBase * triangleHeight));
   System.out.println("One side of the square is ");
   double squareSide=s.nextDouble();
   System.out.println("The area of the square is " + (squareSide * squareSide));
   System.out.println("The base of the rectangle is ");
   double baseSize=s.nextDouble();
   System.out.println("The height of the rectangle is ");
   double rectHeight=s.nextDouble();
   System.out.println("The area of the rectangle is " + (rectHeight * baseSize));
   System.out.println("Side of hexagon is ");
   double hexSide=s.nextDouble();
   System.out.println("The area of the hexagon is " + (3*Math.sqrt(3)/2*(hexSide*hexSide)));
   System.out.println("The side of the dodecahedron is ");
   double doSide=s.nextDouble();
   System.out.println("Volume of dodecahedron: "+( 15+(7*Math.sqrt(5)))*(doSide*doSide*doSide));
 }
}

