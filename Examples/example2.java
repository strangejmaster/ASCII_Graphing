/* Example 2: Using the sortOnIndex() method
 * This example shows how to:
 * 1. Use sortOnIndex()
 */

import ASCII_Graphs.*;

public class example2 {
    public static void main(String args[]) {
        // Test array that'll be sorted based on a certain dimension
        Integer[][] arr = {{0,2,3}, {4,1,9}, {-3, 16, 12}};

        // 3 Data Sets are created as the sortOnDimension function changes the entire set
        // Also title each set with the dimension that it is being sorted on (Not required)
        DataSet set1 = new DataSet(arr, 3);
        set1.title = "This set is being sorted based on the First Dimension (0th index)";

        DataSet set2 = new DataSet(arr, 3);
        set2.title = "This set is being sorted based on the Second Dimension (1st index)";

        DataSet set3 = new DataSet(arr, 3);
        set3.title = "This set is being sorted based on the Third Dimension (2nd index)";

        // Sort the DataSets on respective dimensions
        set1.sortOnIndex(0);
        set2.sortOnIndex(1);
        set3.sortOnIndex(2);

        // Use the test graph function which displays a Dataset's set then display the Frame that is returned
        Graph.test(set1).display();
        System.out.println();
        Graph.test(set2).display();
        System.out.println(); 
        Graph.test(set3).display();
    }
}
