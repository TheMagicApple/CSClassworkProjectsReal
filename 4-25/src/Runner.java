public class Runner {
	public static void main(String[] args){
		
		System.out.println("Testing Part A:");
		int[][] arr =  {{2, 1, 0}, 
						{1, 3, 2}, 
						{0, 0, 0}, 
						{4, 5, 6}}; 
		
		System.out.println("ArrayResizer.isNonZeroRow(arr, 0): " + ArrayResizer.isNonZeroRow(arr, 0) );
		System.out.println("ArrayResizer.isNonZeroRow(arr, 1): " + ArrayResizer.isNonZeroRow(arr, 1) );
		System.out.println("ArrayResizer.isNonZeroRow(arr, 2): " + ArrayResizer.isNonZeroRow(arr, 2) );
		System.out.println("ArrayResizer.isNonZeroRow(arr, 3): " + ArrayResizer.isNonZeroRow(arr, 3) );
		
		
		System.out.println("\nTesting Part B:");
		int[][] smaller = ArrayResizer.resize(arr); 
		for(int r=0; r<smaller.length; r++){
			for(int c=0; c<smaller[r].length; c++){
				System.out.print( smaller[r][c] + "\t" );
			}
			System.out.println();
		}
	}
}
