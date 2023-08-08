public class Runner2 {
	public static void main(String[] args){
		
		System.out.println("Testing Part A");
		ReviewCollector rc = new ReviewCollector();
		rc.addReview(new ProductReview("ABC Cereal","It is the best!"));
		rc.addReview(new ProductReview("ABC Cereal","Warning, it contains asbesto!"));
		rc.addReview(new ProductReview("ACME Cola","Best tasting soda."));
		rc.addReview(new ProductReview("ACME Diet Cola","This is not the best soda."));
		System.out.println(rc);
		
		System.out.println("Testing Part B");
		System.out.println("Good Reviews for ABC Cereal: " + rc.getNumGoodReviews("ABC Cereal"));
		System.out.println("Good Reviews for ACME Cola: " + rc.getNumGoodReviews("ACME Cola"));
		System.out.println("Good Reviews for ACME Diet Cola: " + rc.getNumGoodReviews("ACME Diet Cola"));
	}

}