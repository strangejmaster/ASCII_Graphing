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
        // Declare basic Integer array
        Integer[] arr = {0,2,4,6,8};

        //Create the DataSet that will be graphed
        DataSet set1 = new DataSet(arr);

        //Updates basic info stored inside DataSets
        set1.setInfo("MyDataSet", null, null, null);

        // Declare a new Frame object
        Frame frame;

        // Initialize the Frame object using the test Graph
        frame = Graph.test(set1);

        // Use the display function to quickly output the graph of a frame 
        frame.display();
    }
}
