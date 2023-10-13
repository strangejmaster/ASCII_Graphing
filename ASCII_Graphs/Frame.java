package ASCII_Graphs;

import java.util.ArrayList;

// Frame Object - Stores a rendered graph
public class Frame {
    private ArrayList<String> lines = new ArrayList<String>();
    private String title;
    private String xLabel;
    private String yLabel;
    private String zLabel;
    private DataSet set;

    public Frame(ArrayList<String> lines, String title, String xLabel, String yLabel, String zLabel, DataSet set) {
        this.lines = lines;
        this.title = title;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        this.zLabel = zLabel;
        this.DataSet = set;
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
    public String getZLabel() {
        return zLabel;
    }
    public DataSet getDataSet() {
        return set;
    }

    // Prints out lines ArrayList to display graph in terminal
    public void display() {
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
    }
}
    

