package ASCII_Graphs;

import java.util.ArrayList;
import java.util.Arrays;


// DataSet - An object which contains data, background information, and helpful functions
public class DataSet {
    // DataSet information
    public String title;
    public String xLabel;
    public String yLabel;
    public String zLabel;

    // Actual set of data that the DataSet is storing, each value is stored as an Integer[]
    private ArrayList<Integer[]> set = new ArrayList<Integer[]>();

    /*
    * Types of DataSets:
    * 1 - 1 Dimensional
    * 2 - 2 Dimensional
    * 3 - 3 Dimensional
    */
    private int type;

// Constructors and Quick SetUp
    // DataSets can be made with plain Integer arrays (Whether 1 or 2 dimensional)
    // These will be converted into the ArrayList<Integer[]> type of the 'set'
    public DataSet(Integer[] set) {
        type = 1;
        for (int i = 0; i < set.length; i++){
            this.set.add(new Integer[]{set[i]} );
        }
    }

    // Type must be specified as the number of indexes inside the Integer[][]'s 2nd dimension Array can't be assumed
    public DataSet(Integer[][] set, int type) {
        this.type = type;
        for (int i = 0; i < set.length; i++){
            this.set.add(set[i]);
        }
    }

    // Once again the main 'set' can be created from Integer ArrayLists
    public DataSet(ArrayList<Integer> set) {
        type = 1;
        for (int i = 0; i < set.size(); i++){
            this.set.add(new Integer[]{set.get(i)} );
        }
    }

    // Type must be specified as the number of indexes inside the Integer[] Array can't be assumed
    public DataSet(ArrayList<Integer[]> set, int type) {
        this.type = type;
        this.set = set;
    }
    
    // Quickly set properties of the DataSet
    public void setInfo(String title, String xLabel, String yLabel, String zLabel) {
        this.title = title;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        this.zLabel = zLabel;
    }

// Getter Methods
    // Returns the type of DataSet this set is
    public int getType() {
        return type;
    }

    // Returns the main 'set'
    public ArrayList<Integer[]> getData() {
        return set;
    }

    // Returns an Integer[] that holds 1 point of data
    public Integer[] getDataPoint(int position) {
        return set.get(position);
    }

    // This function will get all values inside the set based on an index 
    // E.g. all points' 0th index
    public ArrayList<Integer> getDataArray(int index) {
        ArrayList<Integer> vals = new ArrayList<Integer>();
        for (int i = 0; i < set.size(); i++) {
            vals.add(set.get(i)[index]);
        }
        return vals;
    }

// Data Manipulation (add, remove, edit, sort)
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

    // *Warning* This action is irriversible, it does not remove data but it changes its ordering within the main 'set'
    // Sorts the set based on a certain index
    // E.g. if ArrayList<Integer[]> arr = {{0,2,3}, {1,-25,6}, {-1, 12, -5}} then arr.sortOnIndex(1) would make arr = {{1, -25, 6}, {0, 2, 3}, {-1, 12, -5}} (The 1st index is being sorted {-25, 2, 12})
    // Credit - https://stackoverflow.com/questions/67125741/how-to-use-arrays-sort-method-to-sort-a-2d-integer-array-in-java
    public void sortOnIndex(int index) {
        // Converts the set to an Object Array (The objects are actually Integer[])
        Object[] arr = set.toArray();

        // Creates a new clamped index int that will bottom out at 0
        final int clampIndex = (index >= 0) ? index  : 0;

        // Sorts the array based on the dimension provided
        Arrays.sort(arr, (a,b) -> ((Integer[]) a)[clampIndex].intValue() == ((Integer[]) b)[clampIndex].intValue() ? ((Integer[]) b)[clampIndex].intValue() - ((Integer[]) a)[clampIndex].intValue() : ((Integer[]) a)[clampIndex].intValue() - ((Integer[]) b)[clampIndex].intValue() );
        
        // Adds newly sorted array back to the set after clearing it
        set.clear();
        for (int i = 0; i < arr.length; i++) {
            set.add((Integer[]) arr[i]);
        }
    }

}