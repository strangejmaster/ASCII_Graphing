/* Example 1: Basic Functionality
 * This example shows how to:
 * 1. Import the ASCII_Graphs library
 * 2. Create a DataSet object
 * 3. Use a test Graph function to convert a DataSet into a Frame object
 * 4. Display the Frame object
 */

import ASCII_Graphs.*;

public class example1 {
    public static void main(String args[]) {
        // Basic int array for use in test function
        int[] arr = {0,2,4,6,8};

        // Declare a Frame2D object
        Frame frame;

        // Initialize the frame object using the test Graph
        frame = Graph.test(arr, "MyFrame");

        // Use the display function to quickly output the graph of a frame 
        frame.display();
    }
}
