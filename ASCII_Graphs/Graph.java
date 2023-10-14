package ASCII_Graphs;

import java.util.ArrayList;

//Converts a DataSet object into a Frame object
public class Graph {
    // Test Graph
    /*
     * Description: A simple test graph which displays the title of a set along with each of its points in an extra set of braces
     * 
     * Parameters:
     * Set - A dataset to be used
     */
    public static Frame test(DataSet set) {
        ArrayList<String> lines = new ArrayList<String>();

        // Add title to the first line
        lines.add(set.title);
        
        // Loop through each point in the DataSet
        for (int i = 0; i < set.getData().size(); i++) {
            // String to store what each array contains
            String data = "";
            
            // Get the point at the i position
            Integer[] arr = set.getDataPoint(i);

            // Loop through each element in the point
            for (int j = 0; j < arr.length; j++) {
                data += arr[j] + " ";
            }
            
            // Throw the point elements between some brackets
            lines.add("[ " + data + "]");
        }
        return new Frame(lines, set);
    }

    // Bar Graph
    /*
     * Description - Creates a bar graph
     * 
     * Parameters:
     * Set - DataSet of values to graph
     * Sort -
     *      False - Display Y-values in order of index
     *      True - Display Y-values in order of X-values
     * Mode - How the lines of the graph should be made, normally provides vertical spacing i.e. distance between each Y-value
     *      -1 will use Efficient Mode (Check readme)
     *      -2 it'll use Scaled Mode (Check readme)
     * Spacing - Distance between each pillar/column
     * Top - What each bar will be topped with
     *      0 - Bars will be topped with a `_` character
     *      1 - Bars will be topped with a `-` character
     *      2 - Bars will be topped with the Y-value
     * Labeling - What labels are displayed
     *     -1 - Nothing Displayed
     *      0 - Title and Labels Displayed
     *      1 - Title Displayed
     *      2 - X and Y Labels Displayed
     */
    public static Frame bar(DataSet set, boolean sort, int mode, int spacing, int top, int labeling) { 
        // Define ArrayLists
        ArrayList<String> lines = new ArrayList<String>();
        ArrayList<Integer> xValues = set.getDataArray(0);
        ArrayList<Integer> yValues = set.getDataArray(1);

        // 
        int columns = (3 + spacing) * xValues.size() + 1;
        int height;
        if (spacing >= 0) {
            height = yValues.size() * (spacing + 1);
        } else if (spacing == -1) {
            height = yValues.size();
        } else if (spacing == -2) {
            
        }

        return new Frame(new ArrayList<String>(), new DataSet(new Integer[]{}));
    }
}
