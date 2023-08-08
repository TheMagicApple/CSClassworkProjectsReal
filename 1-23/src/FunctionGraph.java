import java.awt.*;
import javax.swing.*;

public class FunctionGraph extends JFrame {

    public FunctionGraph(String title) {
        super(title);

        // Set up the x and y axes
        int xMin = -100;
       float xMax = 100;
        int yMin = -10000;
        float yMax = 10000;

        // Create the panel for the graph
        JPanel graphPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Draw the grid lines
                g2d.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
                g2d.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);

                // Draw the function
                for (int x = xMin; x <= xMax; x++) {
                    float y = x * x;
                    int displayX = (int) ((x - xMin) / (xMax - xMin) * getWidth());
                    int displayY = (int) ((y - yMin) / (yMax - yMin) * getHeight());
                    System.out.println(displayX+" "+displayY);
                    g2d.drawLine(displayX, getHeight()/2 - displayY, displayX, (int)(getHeight()/2.0f) - displayY);
                }
            }
        };

        // Add the panel to the frame
        add(graphPanel);

        // Set the size and display the frame
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        FunctionGraph frame = new FunctionGraph("Function Graph");
    }
}
