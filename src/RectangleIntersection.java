/**
 * @author Joseph Brooksbank
 * Programming Project 2
 * Oct 10, 2017
 *
 * Draws two rectangles, and changes their color depending
 * on if they are intersecting or not.
 */
import java.util.Scanner;

public class RectangleIntersection {
    private static Scanner userInput = new Scanner(System.in);
    private static Rectangle rectangle1 = new Rectangle();
    private static Rectangle rectangle2 = new Rectangle();

	public static void main(String[] args) {

	    getData(rectangle1, "Square 1");
        getData(rectangle2, "Square 2");




	}

    private static void getData(Rectangle rectangle, String square){

	    // GETTING THE CENTER COORDINATES

        // center coordinates
        int centerArray[] = new int[2];
        // String array to store the temporarily split user inputted string
        String strArray[];

        // Asking the user for input
        System.out.println("enter the center coordinates in format X,Y for " + square + "?");
        // Storing the user's data
        String user_data = userInput.nextLine();
        // manipulating the user's data into an String array to be converted to an int array
        strArray = user_data.split(",");

        // For each string object in the string array, convert to an int and store in an int array
        for (int i = 0; i < centerArray.length ; i++) {
            centerArray[i] = Integer.parseInt(strArray[i]);
        }
        // assigning the center coordinates to the rectangle object
        rectangle.centerCoords = centerArray;


        // GETTING HEIGHT
        System.out.println("What is the height of " + square + "?");
        rectangle.height = userInput.nextInt();

        // GETTING WIDTH
        System.out.println("What is the width of " + square + "?");
        rectangle.width = userInput.nextInt();

        //Sanitizing scanner for next use
        userInput.nextLine();
    }

}

class Rectangle{
    int[] centerCoords;
    int height;
    int width;



}