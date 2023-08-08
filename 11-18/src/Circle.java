import java.awt.*;

public class Circle implements Runnable{
    private int x,y;

    public Circle(int xdimension,int ydimension){
        x = (int)(Math.random()*xdimension);
        y = (int)(Math.random()*ydimension);

    }

    public void drawMe(Graphics g){
        g.fillOval(x,y,20,20);
    }

    public void run(){
        while(true){
            x += 1;
            if(x>500) {
            	x=-50;
            }
            try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            if(Thread.interrupted())
                return;
        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}