import java.util.Scanner;
import java.util.Random;
public class Runner {

	public static void main(String[] args) {
		int mathscore=0;
		int geographyscore=0;
		Scanner s=new Scanner(System.in);
		Random r=new Random();
		System.out.println("1. Math or 2. Geography");
		int choice=s.nextInt();
		if(choice==1) {
			System.out.println("Welcome to MATH");
			int x=r.nextInt(10);
			System.out.println("Find the area of a square with side length "+x);
			int answer=s.nextInt();
			if(answer==x*x) {
				System.out.println("correct :)");
				mathscore++;
			}else {
				System.out.println("incorrect :(");
			}
			x=r.nextInt(10);
			int y=r.nextInt(10);
			System.out.println("Find the area of a rectangle with length "+x+" and width "+y);
			answer=s.nextInt();
			if(answer==x*y) {
				System.out.println("correct :)");
				mathscore++;
			}else {
				System.out.println("incorrect :(");
			}
			x=r.nextInt(10);
			System.out.println("Find the perimeter of a square with side length "+x);
			answer=s.nextInt();
			if(answer==4*x) {
				System.out.println("correct :)");
				mathscore++;
			}else {
				System.out.println("incorrect :(");
			}
			if(mathscore==3) {
				System.out.println("good job");
				x=r.nextInt(10);
				y=r.nextInt(10);
				System.out.println("(ROUND HUNDREDTHS) Find the volume of a cylinder with radius "+x+" and height "+y);
				double decimalanswer=s.nextDouble();
				double realanswer=x*x*y*Math.PI;
				realanswer=Math.round(realanswer*100.0)/100.0;
				if(decimalanswer==realanswer) {
					System.out.println("correct :)");
					mathscore++;
				}else {
					System.out.println("incorrect :(");
				}
				x=r.nextInt(10);
				y=r.nextInt(10);
				System.out.println("(ROUND HUNDREDTHS) Find the volume of a sphere with radius "+x);
				decimalanswer=s.nextDouble();
				realanswer=x*x*x*Math.PI*(4/3.0);
				realanswer=Math.round(realanswer*100.0)/100.0;
				if(decimalanswer==realanswer) {
					System.out.println("correct :)");
					mathscore++;
				}else {
					System.out.println("incorrect :(");
				}
				x=r.nextInt(10);
				System.out.println("(ROUND HUNDREDTHS) Find the area of an equalateral triangle with side length "+x);
				decimalanswer=s.nextDouble();
				realanswer=(x*x*Math.sqrt(3))/4;
				realanswer=Math.round(realanswer*100.0)/100.0;
				if(decimalanswer==realanswer) {
					System.out.println("correct :)");
					mathscore++;
				}else {
					System.out.println("incorrect :(");
				}
				
			}else {
				System.out.println("bad");
				x=r.nextInt(10);
				
				System.out.println("Find the perimeter of a triangle with side length "+x);
				answer=s.nextInt();
				
				if(answer==3*x) {
					System.out.println("correct :)");
					mathscore++;
				}else {
					System.out.println("incorrect :(");
				}
				x=r.nextInt(10);
				
				System.out.println("Find the side length of a square with area "+x*x);
				answer=s.nextInt();
				
				if(answer==x) {
					System.out.println("correct :)");
					mathscore++;
				}else {
					System.out.println("incorrect :(");
				}
				x=r.nextInt(10);
				y=r.nextInt(10);
				System.out.println("Find the perimeter of a rectangle with length "+x+" and height "+y);
				answer=s.nextInt();
				
				if(answer==(2*x)+(2*y)) {
					System.out.println("correct :)");
					mathscore++;
				}else {
					System.out.println("incorrect :(");
				}
			}
			if(mathscore<=2) {
				System.out.println("You got an F");
			}else if(mathscore==3) {
				System.out.println("You got a D");
			}else if(mathscore==4) {
				System.out.println("You got a C");
			}else if(mathscore==5) {
				System.out.println("You got a B");
			}else {
				System.out.println("You got an A! Wow! ");
			}
			
				
		}
		if(choice==2) {
			System.out.println("Welcome to GEOGRAPHY");
			System.out.println("What continent is the US located in? North America, South America, or Asia");
			s.nextLine();
			String geoanswer=s.nextLine();
			if(geoanswer.equals("North America")) {
				System.out.println("correct :)");
				geographyscore++;
			}else {
				System.out.println("incorrect :(");
			}
			System.out.println("What continent is China located in? North America, Asia, or Europe");
			
			geoanswer=s.nextLine();
			if(geoanswer.equals("Asia")) {
				System.out.println("correct :)");
				geographyscore++;
			}else{
				System.out.println("incorrect :(");
			}
			System.out.println("What continent is Australia located in? North America, South America, or Australia");
			
			geoanswer=s.nextLine();
			if(geoanswer.equals("Australia")) {
				System.out.println("correct :)");
				geographyscore++;
			}else {
				System.out.println("incorrect :(");
			}
			if(geographyscore==3) {
				System.out.println("good job");
				System.out.println("What is the capital of Belgium? Brussels, Sprouts, or Flanders");
				
				geoanswer=s.nextLine();
				if(geoanswer.equals("Brussels")) {
					System.out.println("correct :)");
					geographyscore++;
				}else {
					System.out.println("incorrect :(");
				}
				System.out.println("In what state is the Miracle Village located in? California, Florida, or Alaska ");
				
				geoanswer=s.nextLine();
				if(geoanswer.equals("Florida")) {
					System.out.println("correct :)");
					geographyscore++;
				}else {
					System.out.println("incorrect :(");
				}
				System.out.println("What is the southernmost city in the world? Ushuaia, Texas, or Hawaii");
				
				geoanswer=s.nextLine();
				if(geoanswer.equals("Ushuaia")) {
					System.out.println("correct :)");
					geographyscore++;
				}else {
					System.out.println("incorrect :(");
				}
			}else {
				System.out.println("bad");
				System.out.println("Where is California located? US, Mexico, or Europe");
				
				geoanswer=s.nextLine();
				if(geoanswer.equals("US")) {
					System.out.println("correct :)");
					geographyscore++;
				}else {
					System.out.println("incorrect :(");
				}
				System.out.println("What is the capital of the US? Washington DC, Maryland, or Texas ");
				
				geoanswer=s.nextLine();
				if(geoanswer.equals("Washington DC")) {
					System.out.println("correct :)");
					geographyscore++;
				}else {
					System.out.println("incorrect :(");
				}
				System.out.println("Where is Mexico located compared to the US? South, North, or West");
				
				geoanswer=s.nextLine();
				if(geoanswer.equals("South")) {
					System.out.println("correct :)");
					geographyscore++;
				}else {
					System.out.println("incorrect :(");
				}
			}
			
			if(geographyscore<=2) {
				System.out.println("You got an F");
			}else if(geographyscore==3) {
				System.out.println("You got a D");
			}else if(geographyscore==4) {
				System.out.println("You got a C");
			}else if(geographyscore==5) {
				System.out.println("You got a B");
			}else {
				System.out.println("You got an A! Wow! ");
			}
			
		}

	}

}
