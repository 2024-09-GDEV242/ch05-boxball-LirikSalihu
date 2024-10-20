import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * Class BouncingBall - a graphical ball that observes the effect of gravity. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will fall downwards, accelerating with time due to the effect of gravity, and bounce
 * upward again when hitting the ground.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Lirik Salihu
 * @version 2016.10.20
 */

public class BouncingBall
{
    private int xPosition;
    private int yPosition;
    private int diameter;
    private Color color;
    private Canvas canvas;
    private int xSpeed;
    private int ySpeed;
    private int leftWall;
    private int rightWall;
    private int topWall;
    private int bottomWall;

    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos the horizontal coordinate of the ball
     * @param yPos the vertical coordinate of the ball
     * @param ballDiameter the diameter of the ball
     * @param ballColor the color of the ball
     * @param canvas the canvas to draw this ball on
     * @param left the x-coordinate of the left wall
     * @param right the x-coordinate of the right wall
     * @param top the y-coordinate of the top wall
     * @param bottom the y-coordinate of the bottom wall
     */
    public BouncingBall(int xPos, int yPos, int ballDiameter, Color ballColor, Canvas canvas, 
                   int left, int right, int top, int bottom) {
        xPosition = xPos;
        yPosition = yPos;
        diameter = ballDiameter;
        color = ballColor;
        this.canvas = canvas;
        leftWall = left;
        rightWall = right;
        topWall = top;
        bottomWall = bottom;

        // Random speed generation that is not vertical or horizontal
        Random rand = new Random();
        do {
            xSpeed = rand.nextInt(15) - 7;  // random value between -7 and 7
            ySpeed = rand.nextInt(15) - 7;  // random value between -7 and 7
        } while (xSpeed == 0 || ySpeed == 0);
    }

    /**
     * Draw this ball at its current position onto the canvas.
     */
    public void draw() {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     */
    public void erase() {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }

    /**
     * Move this ball and bounce off the walls of the box.
     */
    public void move() {
        erase();
        
        // Update position
        xPosition += xSpeed;
        yPosition += ySpeed;

        // Bounce off the walls
        if (xPosition <= leftWall || xPosition >= (rightWall - diameter)) {
            xSpeed = -xSpeed; // Reverse direction
        }
        if (yPosition <= topWall || yPosition >= (bottomWall - diameter)) {
            ySpeed = -ySpeed; // Reverse direction
        }

        draw();
    }
}
