package ASCII_Graphs;

import java.util.ArrayList;

/*
 * DataSetD1 objects store sets of data
 * D1 indicates 1 dimension, each data point in the set has only 1 value
 */
public class DataSetD1 {
    private ArrayList<Integer[]> set = new ArrayList<Integer[]>();

    public void add(Integer[] coordinate) {
        if (coordinate.length == 1) {
            set.add(coordinate);
        } else {
            throw new ASCII_Exceptions.valueMismatch();
        }
    }
}