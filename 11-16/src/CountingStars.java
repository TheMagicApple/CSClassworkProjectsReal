public class CountingStars implements Runnable{
    public void run(){
        int num = 1;
        while(true){
            System.out.println(num);
            num++;
            if(Thread.interrupted()) {
            	System.out.println("I am not done");
            	return;
            }
        }
    }
}