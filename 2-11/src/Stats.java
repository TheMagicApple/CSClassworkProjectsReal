import java.util.ArrayList;

public class Stats
{
	private ArrayList<ScoreInfo> scoreList;
	
	// listed in increasing score order; no two ScoreInfo objects contain the same score
	
	public Stats(char type)
	{
		scoreList = new ArrayList<ScoreInfo>();
		
		if( type == 'a' )
		{
			for(int i=10; i < 110; i+=10)
				scoreList.add(new ScoreInfo(i));
		}
	}
	
	/** Records a score in the database, keeping the database in increasing score order. If no other
	* ScoreInfo object represents score, a new ScoreInfo object representing score
	* is added to the database; otherwise, the frequency in the ScoreInfo object representing
	* score is incremented.
	* @param score a score to be recorded in the list
	* @return true if a new ScoreInfo object representing score was added to the list;
	* false otherwise
	*/
	public boolean record(int score)
	{ /* to be implemented in part (a) */
		boolean found=false;
		for(ScoreInfo s:scoreList) {
			if(s.getScore()==score) {
				s.increment();
				found=true;
			}
			for(int i=0;i<scoreList.size()-1;i++) {
				if(scoreList.get(i).getScore()>scoreList.get(i+1).getScore()) {
					ScoreInfo temp=scoreList.get(i);
					scoreList.set(i, scoreList.get(i+1));
					scoreList.set(i+1, temp);
				}
			}
		}
		if(!found) {
			ScoreInfo s=new ScoreInfo(score);
			scoreList.add(s);
			return false;
		}else {
			return true;
		}
	}

	public void recordScores(int[] stuScores)
	{ /* to be implemented in part (b) */
		for(int i:stuScores) {
			record(i);
			for(int a=0;a<scoreList.size()-1;a++) {
				if(scoreList.get(a).getScore()>scoreList.get(a+1).getScore()) {
					ScoreInfo temp=scoreList.get(a);
					scoreList.set(a, scoreList.get(a+1));
					scoreList.set(a+1, temp);
				}
			}
		}
		for(int i=0;i<scoreList.size()-1;i++) {
			if(scoreList.get(i).getScore()>scoreList.get(i+1).getScore()) {
				ScoreInfo temp=scoreList.get(i);
				scoreList.set(i, scoreList.get(i+1));
				scoreList.set(i+1, temp);
			}
		}
	}
	
	
	public void printScores()
	{
		for(ScoreInfo each : scoreList)
		{
			System.out.println("Score: " + each.getScore() + " Frequency: " + each.getFrequency() );
		}
	}
	// There may be instance variables, constructors, and methods that are not shown.
}
