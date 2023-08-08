
public class DogRunner {

	public static void main(String[] args) {
		Dog d1=new Dog("Fido");
		System.out.println(d1.speak());
		//doesnt work because casting down: BigDog d2=(BigDog)d1;
		BigDog bd1=new BigDog("Biggy");
		System.out.println(bd1.speak());
		Dog bd2=(Dog)bd1;
		System.out.println(bd2.speak());
		HuskyDog h1=new HuskyDog("Snow");
		System.out.println(h1.speak());
		Dog h2=(Dog)h1;
		System.out.println(h2.speak());
		HuskyDog h3=(HuskyDog)h2;
		System.out.println(h3.speak());
		//doesnt work because casting across: BigDog h4=(BigDog)h1;
		SmallDog sm=new SmallDog("Tiny");
		System.out.println(sm.speak());
		Dog d3=(Dog)sm;
		System.out.println(d3.speak());
		//doesnt work because casting across: BigDog bd3=(BigDog)sm;

	}

}
