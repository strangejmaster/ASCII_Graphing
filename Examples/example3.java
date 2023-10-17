/* Example 3: Using the bar graph!!!!
 * This example shows how to:
 * 1. Use the bar graph to create a nice little graph
 */

import ASCII_Graphs.*;

public class example3 {
    public static void main(String args[]) {
        // The array that will be made into a bar graph
        Integer[][] arr = {{15, -3}, {-6,-12}, {0, 2}, {0, 13}, {-5,-10}};

        DataSet set = new DataSet(arr, 2);

        // set.setInfo("The Coolest Bar Graph these titles can be super long but no matter they'll get truncated and added to the next line cause this is super awesome", "This is the X-axis", "This is the Y-axis!", null);
        set.setInfo("Graph Bar", "Graph", "Bar", null);
        
        System.out.println("Creating bar graph, going dark\n");

        /*
        * Set - DataSet of values to graph
        * 
        * Mode - How the lines of the graph should be made, normally provides vertical spacing i.e. distance between each Y value
        *      (Recommended) -1 will use Efficient Mode (Check readme)
        *      -2 it'll use Scaled Mode (Check readme)
        * 
        * Margin - Distance between each pillar/column
        * 
        * Width - Distance inbetween each pillar/column, 
        * to create graphs with a "middle" the width must be odd, 
        * therefore the width parameter actually increases the spread by 2, if set to 0 the width will equal 1
        * 
        * Top - What each bar will be topped with
        *      (If a value is negative then brackets will be added around it)
        *      0 - Bars will be topped with the Y value
        *      1 - Bars will be topped with `_`
        *      2 - Bars will be topped with `-`
        *      3 - Bars will be topped with ` `
        *      4 - Bars will be topped with `=`
        *      
        * Labeling - What labels are displayed
        *     -1 - Nothing Displayed
        *      0 - Title and Labels Displayed
        *      1 - Title Displayed
        *      2 - X and Y Labels Displayed
        */
        Frame frame = Graph.bar(set, -2, 2, 2, 1, 1);

        System.out.println("The Bar graph is complete!! \n");

        frame.display();
    }
}
