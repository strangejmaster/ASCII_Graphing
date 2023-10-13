package ASCII_Graphs;

import java.util.ArrayList;

//Converts a DataSet object into a Frame object
public class Graph {
    // Test Graph
    public static Frame test(DataSet set) {
        ArrayList<String> lines = new ArrayList<String>();
        lines.add(set.title);
        for (int i = 0; i < set.getData().size(); i++) {
            lines.add("[" + set.getDataPoint(i) + "]");
        }
        return new Frame(lines, set);
    }
}
