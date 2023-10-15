/* Example 3: Using the bar graph!!!!
 * This example shows how to:
 * 1. Use the bar graph to create a nice little graph
 */

import ASCII_Graphs.*;

public class example3 {
    public static void main(String args[]) {
        // The array that will be made into a bar graph
        Integer[][] arr = {{-6,-12}, {-5,-10}, {0, 2}, {5, 4}, {1, -3}};

        DataSet set = new DataSet(arr, 2);

        set.setInfo("The Coolest Bar Graph", "This is the X-axis", "This is the Y-axis! What happens when I make this extra long?", null);

        System.out.println("Creating bar graph, going dark\n");
        Frame frame = Graph.bar(set, -1, 1, 1, 2);
        System.out.println("The Bar graph is complete!! \n");

        frame.display();
    }
}
