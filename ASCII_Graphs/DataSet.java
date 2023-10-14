package ASCII_Graphs;

import java.util.ArrayList;
import java.util.Arrays;

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
    // Sorts the set based on a certain dimension i.e. X-Values from smallest to largest, if two X-values are the same
    // Credit - https://stackoverflow.com/questions/67125741/how-to-use-arrays-sort-method-to-sort-a-2d-integer-array-in-java
    public void sortOnDimension(int dimension) {
        // Converts the set to an Object Array (The objects are actually Integer[])
        Object[] arr = set.toArray();

        // Creates a new dimension int that will bottom out at 0, subtracts 1 since selecting the a dimension (I.e. 1st dimension) needs to access the index below that (I.e. 0th index)
        final int updatedDimension = (dimension > 0) ? dimension - 1 : 0;

        // Sorts the arr based on the dimension provided
        Arrays.sort(arr, (a,b) -> ((Integer[]) a)[updatedDimension].intValue() == ((Integer[]) b)[updatedDimension].intValue() ? ((Integer[]) b)[updatedDimension].intValue() - ((Integer[]) a)[updatedDimension].intValue() : ((Integer[]) a)[updatedDimension].intValue() - ((Integer[]) b)[updatedDimension].intValue() );
        
        // Adds newly sorted array back to the set after clearing it
        set.clear();
        for (int i = 0; i < arr.length; i++) {
            set.add((Integer[]) arr[i]);
        }
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