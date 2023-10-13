package ASCII_Graphs;

import java.util.ArrayList;

//Converts a DataSet object into a Frame object
public class Graph {
    // Test Graph
    public static Frame test(int[] values, String title) {
        ArrayList<String> lines = new ArrayList<String>();
        lines.add(title);
        for (int i = 0; i < values.length; i++) {
            lines.add("[" + values[i] + "]");
        }
        return new Frame(lines, title, null, null, null);
    }
}
