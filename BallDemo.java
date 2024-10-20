import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Lirik Salihu
 * @version 2024.10.20
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private Random rand;

    /**
     * Set up the canvas.
     */
    public BallDemo() {
        myCanvas = new Canvas("Box Ball Demo", 600, 500);
        rand = new Random();
    }

    /**
     * Add balls to bounce inside a box.
     */
    public void boxBounce(int numberOfBalls) {
        myCanvas.setVisible(true);

        // Box boundaries
        int leftWall = 50;
        int rightWall = 550;
        int topWall = 50;
        int bottomWall = 450;

        // Draw the box
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(leftWall, topWall, rightWall, topWall);
        myCanvas.drawLine(leftWall, bottomWall, rightWall, bottomWall);
        myCanvas.drawLine(leftWall, topWall, leftWall, bottomWall);
        myCanvas.drawLine(rightWall, topWall, rightWall, bottomWall);

        // Create balls
        List<BouncingBall> balls = new ArrayList<>();
        for (int i = 0; i < numberOfBalls; i++) {
            int xPos = rand.nextInt(rightWall - leftWall - 20) + leftWall;
            int yPos = rand.nextInt(bottomWall - topWall - 20) + topWall;
            int diameter = rand.nextInt(15) + 10;
            Color color = new Color(rand.nextInt(200), rand.nextInt(200), rand.nextInt(200));
            balls.add(new BouncingBall(xPos, yPos, diameter, color, myCanvas, leftWall, rightWall, topWall, bottomWall));
        }

        // Animate the balls
        boolean finished = false;
        while (!finished) {
            myCanvas.wait(50);  // delay
            for (BouncingBall ball : balls) {
                ball.move();
            }
        }
    }
}
