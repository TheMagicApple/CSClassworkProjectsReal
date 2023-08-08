
public class Runner {

	public static void main(String[] args) {
		String[] strings=new String[] {"one two three two one","1 2 3 4 5 one two three four five","a b c d e f g x y z g f h","racecar is racecar","1 2 3 a b c c b a 3 2 1","chicken is a chicken"};
		Queue<String> q=new Queue<>();
		Stack<String> s=new Stack<>();
		
		for(String string:strings) {
			String[] strin=string.split(" ");
			q.clear();
			s.clear();
			int size=q.size();
			for(String stri:strin) {
				q.add(stri);
				s.push(stri);
			}
			boolean aehrtpehyirtbgndfiniyp5tortjroefjgoe=false;
			while(q.size()+s.size()>size) {
				String sdfrt=q.poll();
				String setrt5g=s.pop();
				if(!sdfrt.equals(setrt5g)) {
					System.out.println("NO");
					aehrtpehyirtbgndfiniyp5tortjroefjgoe=true;
					break;
				}
			}
			if(!aehrtpehyirtbgndfiniyp5tortjroefjgoe) {
				System.out.println("YES");
			}
		}
				

	}

}
