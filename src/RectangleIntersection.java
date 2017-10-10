/**
 * @author Joseph Brooksbank
 * Programming Project 2
 * Oct 10, 2017
 *
 * Draws two rectangles, and changes their color depending
 * on if they are intersecting or not.
 */
import edu.princeton.cs.introcs.StdDraw;
import java.util.Scanner;

class RectangleIntersection {
    /** Canvas size */
    private final static int CANVAS_SIZE = 300;
    /** Scanner object to get user input */
    private static final Scanner userInput = new Scanner(System.in);
    /** First rectangle object */
    private static final Rectangle rectangle1 = new Rectangle();
    /** Second rectangle object */
    private static final Rectangle rectangle2 = new Rectangle();

    /**
     * Main method for this project, asks user for input and draws rectangles accordingly
     *
     */
	public static void main(String[] args) {
	    /* Setting basic canvas parameters */
        StdDraw.setCanvasSize(CANVAS_SIZE, CANVAS_SIZE);
        StdDraw.setXscale(0, CANVAS_SIZE);
        StdDraw.setYscale(0, CANVAS_SIZE);

        /* Getting the data for the rectangles */
	    getData(rectangle1, "Rectangle 1");
        getData(rectangle2, "Rectangle 2");

        /* Checking if the rectangles overlap using corner logic for setting pen color  */
        if (isOverlapping(rectangle1, rectangle2))
            StdDraw.setPenColor(StdDraw.RED);
        else
            StdDraw.setPenColor(StdDraw.GREEN);

        /* Drawing the rectangles */
        rectangle1.drawRectangle();
        rectangle2.drawRectangle();

	}

    /**
     * Method to ask user for rectangle parameters and assign that data to a rectangle object
     * @param rectangle: The rectangle object which is being populated
     * @param nameOfRectangle: The name of the rectangle (in this case rectangle 1 or 2)
     */
    private static void getData(Rectangle rectangle, String nameOfRectangle){


	     ///// GETTING THE CENTER COORDINATES /////

	    /* array to hold the center coordinates */
        int centerArray[] = new int[2];
        /* String array to store the temporarily split user inputted string */
        String strArray[];

        /* Asking the user for input */
        System.out.println("enter the center coordinates in format X,Y for " + nameOfRectangle + "?");
        /* Storing the user's data */
        String user_data = userInput.nextLine();
        /* Manipulating the user's data into an String array to be converted to an int array */
        strArray = user_data.split(",");

        /* For each string object in the string array, convert to an int and store in an int array */
        for (int i = 0; i < centerArray.length ; i++) {
            centerArray[i] = Integer.parseInt(strArray[i]);
        }

        /* Assigning the center coordinates to the rectangle object */
        rectangle.centerCoords = centerArray;

        ///// GETTING WIDTH /////
        System.out.println("What is the width of " + nameOfRectangle + "?");
        rectangle.width = userInput.nextInt();

        ///// GETTING HEIGHT /////
        System.out.println("What is the height of " + nameOfRectangle + "?");
        rectangle.height = userInput.nextInt();

        /* Sanitizing scanner for next use */
        userInput.nextLine();
    }

    /**
     * Method to determine if two rectangles are overlapping using the top left corner and bottom right corner of each
     * rectangle. We can determine that the rectangle is NOT overlapping if one rectangle is completely to the left or
     * above the other rectangle, and thus if these are not true then the rectangles are overlapping.
     * @param rectangle1overlap: The first rectangle (order does not matter however)
     * @param rectangle2overlap: The second rectangle (could also just be the "other" rectangle)
     * @return whether or not the rectangles are overlapping
     */
    private static boolean isOverlapping (Rectangle rectangle1overlap, Rectangle rectangle2overlap){

        /* If one rectangle is on the left side of the left edge of the other */
        if (rectangle1overlap.topLeft()[0] > rectangle2overlap.bottomRight()[0]
                || rectangle2overlap.topLeft()[0] > rectangle1overlap.bottomRight()[0])
            return false;
        /* If one rectangle is above the top edge of the other */
        if (rectangle1overlap.topLeft()[1] < rectangle2overlap.bottomRight()[1]
                || rectangle2overlap.topLeft()[1] < rectangle1overlap.bottomRight()[1])
            return false;
        /* if neither of these are true, the rectangles are intersecting */
        return  true;
    }

}

/**
 * Rectangle class, holding all of the properties for a rectangle in this project
 */
class Rectangle{

    /** The center coordinates for a rectangle */
    int[] centerCoords;
    /** Half of the height of a rectangle */
    int height;
    /** Half of the width of a rectangle */
    int width;

    /** The coordinate of the top left corner of a rectangle */
    int[] topLeft(){
        int topLeftX = centerCoords[0] - width;
        int topLeftY = centerCoords[1] + height;
        return new int[] { topLeftX, topLeftY};
    }

    /** The coordinate of the bottom right corner of a rectangle */
    int[] bottomRight(){
        int bottomRightX = centerCoords[0] + width;
        int bottomRightY = centerCoords[1] - height;
        return new int[] { bottomRightX, bottomRightY};
    }
    /** a method to draw the rectangle using StdDraw */
    void drawRectangle(){
        StdDraw.rectangle(centerCoords[0], centerCoords[1], width, height);
    }



}
