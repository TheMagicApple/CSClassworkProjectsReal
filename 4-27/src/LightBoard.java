public class LightBoard
{
 /** The lights on the board, where true represents on and false represents off.
 */
 private boolean[][] lights;
 
 public LightBoard()
 { 
	lights = new boolean[7][5];
	lights[0][0] = true; 
	lights[0][1] = true; 
	lights[0][2] = false; 
	lights[0][3] = true; 
	lights[0][4] = true; 
	
	lights[1][0] = true; 
	lights[1][1] = false; 
	lights[1][2] = false; 
	lights[1][3] = true; 
	lights[1][4] = false; 
	
	lights[2][0] = true; 
	lights[2][1] = false; 
	lights[2][2] = false; 
	lights[2][3] = true; 
	lights[2][4] = true; 
	
	lights[3][0] = true; 
	lights[3][1] = false; 
	lights[3][2] = false; 
	lights[3][3] = false; 
	lights[3][4] = true; 
	
	lights[4][0] = true; 
	lights[4][1] = false; 
	lights[4][2] = false; 
	lights[4][3] = false; 
	lights[4][4] = true; 
	
	lights[5][0] = true; 
	lights[5][1] = true; 
	lights[5][2] = false; 
	lights[5][3] = true; 
	lights[5][4] = true; 
	
	lights[6][0] = false; 
	lights[6][1] = false; 
	lights[6][2] = false; 
	lights[6][3] = false; 
	lights[6][4] = false; 
 }
 
 /** Constructs a LightBoard object having numRows rows and numCols columns.
 * Precondition: numRows > 0, numCols > 0
 * Postcondition: each light has a 40% probability of being set to on.
 */
 public LightBoard(int numRows, int numCols)
 { /* to be implemented in part (a) */ 
	lights=new boolean[numRows][numCols];
	for(int i=0;i<numRows;i++) {
		for(int k=0;k<numCols;k++) {
			int choice=(int)(Math.random()*5);
			if(choice==0 || choice==1) {
				lights[i][k]=true;
			}else {
				lights[i][k]=false;
			}
		}
	}
 }
 
 
 
 
 /** Evaluates a light in row index row and column index col and returns a status
 * as described in part (b).
 * Precondition: row and col are valid indexes in lights.
 */
 public boolean evaluateLight(int row, int col)
 { /* to be implemented in part (b) */ 
	 int numOn=0;
	 for(int i=0;i<lights.length;i++) {
		 if(lights[i][col]==true) {
			 numOn++;
		 }
	 }
	 if(lights[row][col]==true) {
		 if(numOn%2==0) {
			 return false;
		 }else {
			 return lights[row][col];
		 }
	 }else {
		 if(numOn%3==0) {
			 return true;
		 }else {
			 return lights[row][col];
		 }
	 }

 
 }
 // There may be additional instance variables, constructors, and methods not shown.
 
 public double percentOn(){
	 double total = lights.length * lights[0].length;
	 double count = 0;
	 for(int r=0; r<lights.length; r++){
		for(int c=0; c<lights[0].length; c++){
			if( lights[r][c])
				count++;
		}
	}
	return (count/total*100);
 }
} 
