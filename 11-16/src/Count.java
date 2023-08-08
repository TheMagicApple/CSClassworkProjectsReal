public class Count implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName());
        for(int i = 1; i <= 10; i++){
            System.out.println(i);
            try{
                Thread.sleep(1000); //millisecond
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }  
        }          
    }
}