package ASCII_Graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


// Frame Object
public class Frame2D {
    private ArrayList<String> lines = new ArrayList<String>();
    private String title;
    private String xLabel;
    private String yLabel;

    public Frame2D(ArrayList<String> lines, String title, String xLabel, String yLabel) {
        this.lines = lines;
        this.title = title;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
    }

    // Getter Methods
    public ArrayList<String> getLines() {
        return lines;
    }
    public String getTitle() {
        return title;
    }
    public String getXLabel() {
        return xLabel;
    }
    public String getYLabel() {
        return yLabel;
    }

    // Prints out lines ArrayList to display graph in terminal
    public void display() {
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
    }
}

public class Graph {
    // Test Graph
    public static Frame2D test(int[] values, String title) {
        ArrayList<String> lines = new ArrayList<String>();
        lines.add(title);
        for (int i = 0; i < values.length; i++) {
            lines.add("[" + values[i] + "]");
        }
        return new Frame2D(lines, title, null, null);
    }
}