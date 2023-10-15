package ASCII_Graphs;

import java.util.ArrayList;

//Converts a DataSet object into a Frame object
public class Graph {
// Helpful utilities which are used in graphing
    /*
     * Description: While making graphs some functions may come up often so it's best to make some utilities that can be reused
     * (This is to adhere to DRY)
     */

    // Returns the # of digits in the specified int
    private static int digits(int value) {
        // Flip sign to prevent it from being counted
        if (value < 0) {
            value = -value;
        }
        return String.valueOf( value ).length(); // Credit - https://www.baeldung.com/java-number-of-digits-in-int
    }

    private static String fill(int value, char filler) {
        return new String(new char[value]).replace('\0', filler); // Credit - https://stackoverflow.com/questions/2804827/create-a-string-with-n-characters
    }

// Test Graph
    /*
     * Description: A simple test graph which displays the title of a set along with each of its points in an extra set of braces
     * 
     * Parameters:
     * Set - A dataset to be used
     */
    public static Frame test(DataSet set) {
        ArrayList<String> lines = new ArrayList<String>();

        // Add title to the first line
        lines.add(set.title);
        
        // Loop through each point in the DataSet
        for (int i = 0; i < set.getData().size(); i++) {
            // String to store what each array contains
            String data = "";
            
            // Get the point at the i position
            Integer[] arr = set.getDataPoint(i);

            // Loop through each element in the point
            for (int j = 0; j < arr.length; j++) {
                data += arr[j] + " ";
            }
            
            // Throw the point elements between some brackets
            lines.add("Point " + i + " - [ " + data + "]");
        }
        return new Frame(lines, set);
    }


// Bar Graph
    /*
     * Description - Creates a bar graph
     * 
     * Parameters:
     * Set - DataSet of values to graph
     * Mode - How the lines of the graph should be made, normally provides vertical spacing i.e. distance between each Y-value
     *      (Recommended) -1 will use Efficient Mode (Check readme)
     *      -2 it'll use Scaled Mode (Check readme)
     * Spacing - Distance between each pillar/column
     * Top - What each bar will be topped with
     *      0 - Bars will be topped with a `_` character
     *      1 - Bars will be topped with a `-` character
     *      2 - Bars will be topped with the Y-value
     * Labeling - What labels are displayed
     *     -1 - Nothing Displayed
     *      0 - Title and Labels Displayed
     *      1 - Title Displayed
     *      2 - X and Y Labels Displayed
     */
    public static Frame bar(DataSet set, int mode, int spacing, int top, int labeling) { 
        // Define ArrayLists
        ArrayList<String> lines = new ArrayList<String>();


        //Sort the set! (Based on X values)
        set.sortOnIndex(0); 
    

        // Get the X and Y values to be plotted
        ArrayList<Integer> xValues = set.getDataArray(0);
        ArrayList<Integer> yValues = set.getDataArray(1);
    
        int height = 0;

        // Set the height value depending on which mode is used
        switch (mode) {
            case -1:
                height = yValues.size();
                break;
            case -2:
            // Not yet implemented
                break;
            default:
                height = mode;
                break;
        }

        // Select the correct topper
        String topper;
        switch(top) {
            case 0:
                topper = "_";
                break;
            case 1:
                topper = "-";
                break;
            case 2:
                topper = null;
            default:
                topper = "_";
                break;
        }

        // This is how the bars/columns are seperated, it changes at 0.
        String spacer = " ";

        // String that seperates bars
        String distance = fill(spacing, ' ');

        // Gets the # of decimal places in the largest 
        int deci = digits(set.getDataPoint(yValues.size())[1].intValue());
    // Make the graph!
        // Add title if title is one of the labels expected
        if (labeling == 0 || labeling == 1) {
            lines.add(set.title);
        }

        // The graph is created by running through loops until every single thing that needs to get graphed is graphed
        boolean isGraphDone = false;

        // Set values according to whether or not labels need to be created
        boolean isYLabelDone = (labeling == 0 || labeling == 1) ? false : true;
        boolean isXLabelDone = (labeling == 0 || labeling == 1) ? false : true;

        int i = height; 
        while (!isGraphDone || !isYLabelDone || !isXLabelDone) {
            String line = "";

            if (!isYLabelDone) {
                // Get the character of the Y-label at the height-i index
                line += set.yLabel.charAt( height - i ) + "  ";
                // If the label is at the last index then don't add it next time
                if ((height - i) == set.yLabel.length() - 1) {
                    isYLabelDone = true;
                }
            }

            // Only work on the graph if it's... not done
            if (!isGraphDone) {
                // Adds spaces before the number
                line += fill(deci-digits(i), ' ')  + i + " - ";

                // Start of the graph on the line
                line += "|";

                
                // If this is the line at 0 then make the spaces with underscores
                if (i == 0) {
                    spacer = "_";
                } else {
                    spacer = " ";
                }

                int j = 0;
                while (j < yValues.size()) {
                    int header = yValues.get(j).intValue();
                    if (header >= i) {
                        line += distance + "|" + spacer + "|";
                        continue;
                    } 

                    if (header <= i) {
                        line += distance + "   ";
                    }

                    if (header == i) {
                        if (topper == null) {
                            line += spacer + " " + header + " ";
                        } else {
                            line += spacer + " " + topper + " ";
                        }
                        continue;
                    }
                } 
            }
        
            // Add the line and continue on
            lines.add(line);
            i--;
        }
        
        // Alas the graph is complete
        return new Frame(lines, set);
    }
}
