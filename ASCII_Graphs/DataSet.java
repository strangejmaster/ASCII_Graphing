package ASCII_Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
 * Types of DataSets:
 * 1 - 1 Dimensional
 * 2 - 2 Dimensional
 * 3 - 3 Dimensional
 */
public class DataSet {
    public String title;
    public String xLabel;
    public String yLabel;
    public String zLabel;
    private ArrayList<Integer[]> set = new ArrayList<Integer[]>();
    private int type;

    public DataSet(Integer[] set) {
        type = 1;
        for (int i = 0; i < set.length; i++){
            this.set.add(new Integer[]{set[i]} );
        }
    }

    public DataSet(Integer[][] set, int type) {
        this.type = type;
        for (int i = 0; i < set.length; i++){
            this.set.add(set[i]);
        }
    }

    public DataSet(ArrayList<Integer> set) {
        type = 1;
        for (int i = 0; i < set.size(); i++){
            this.set.add(new Integer[]{set.get(i)} );
        }
    }

    public DataSet(ArrayList<Integer[]> set, int type) {
        this.type = type;
        this.set = set;
    }
    
    //Returns a certain dimension of the set as an ArrayList, i.e. dimension 0 will return all X-values in the set in an ArrayList
    public ArrayList<Integer> getDataArray(int dimension) {
        ArrayList<Integer> vals = new ArrayList<Integer>();
        for (int i = 0; i < set.size(); i++) {
            vals.add(set.get(i)[dimension]);
        }
        return vals;
    }

    // *Warning* This action is irriversible but it does not cause any data loss
    // Sorts the set based on a certain dimension i.e. X-Values from smallest to largest
    public void sortOnDimension(int dimension) {
        // int[][] test = new int[][]{{0,0,0},{1,5,2},{-1,2,4}};
        // Arrays.sort(test);
        set = Arrays.sort(set, ( (a, b) -> Integer.compare(a.get(0)[0].intValue(), b.get(0)[0].intValue()) ) ) ;
    }

    public int type() {
        return type;
    }

    public void setInfo(String title, String xLabel, String yLabel, String zLabel) {
        this.title = title;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        this.zLabel = zLabel;
    }

    public ArrayList<Integer[]> getData() {
        return set;
    }

    public Integer[] getDataPoint(int position) {
        return set.get(position);
    }

    public void addData(Integer[] coordinate) throws ASCII_Exception {
        if (coordinate.length == 1) {
            set.add(coordinate);
        } else {
            throw new ASCII_Exception("Error - Type Mistmatch: Incorrect number of values in a point for DataSet");
        }
    }

    public void removeData(int position) {
        set.remove(position);
    }

    public void editData(int position, Integer[] point) throws ASCII_Exception {
        if(point.length == type) {
            set.set(position, point);
        } else {
            throw new ASCII_Exception("Error - Type Mistmatch: Incorrect number of values in a point for DataSet");
        }
    }
}