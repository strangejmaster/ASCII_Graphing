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
    private static int digits(int value, boolean countNegative) {
        int fixed = value;

        // Print out values
        // System.out.println(fixed + " | " + String.valueOf(fixed) + " | " + String.valueOf(fixed).length());

        // If a value is negative take the opposite value to count it
        if (value < 0 && !countNegative) {
            fixed = -value;
            return String.valueOf( fixed ).length();
        }
        return String.valueOf( fixed ).length(); // Credit - https://www.baeldung.com/java-number-of-digits-in-int
    }

    private static String fill(int value, char filler) {
        int fixed = value;
        if (value < 0) {
            fixed = -value;
        }
        return new String(new char[fixed]).replace('\0', filler); // Credit - https://stackoverflow.com/questions/2804827/create-a-string-with-n-characters
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

        if (set.title != null) {
            // Add title to the first line
            lines.add(set.title);
        }
        
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
     * 
     * Mode - How the lines of the graph should be made, normally provides vertical spacing i.e. distance between each Y value
     *      (Recommended) -1 will use Efficient Mode (Check readme)
     *      -2 it'll use Scaled Mode (Check readme)
     * 
     * Margin - Distance between each pillar/column
     * 
     * Width - Distance inbetween each pillar/column, 
     * to create graphs with a "middle" the width must be odd, 
     * therefore the width parameter actually increases the spread by 2, if set to 0 the width will equal 1
     * 
     * Top - What each bar will be topped with
     *      (If a value is negative then brackets will be added around it)
     *      0 - Bars will be topped with the Y value
     *      1 - Bars will be topped with `_`
     *      2 - Bars will be topped with `-` 
     *      3 - Bars will be topped with ` `
     *      4 - Bars will be topped with `=`  
     *      
     * Labeling - What labels are displayed
     *     -1 - Nothing Displayed
     *      0 - Title and Labels Displayed
     *      1 - Title Displayed
     *      2 - X and Y Labels Displayed
     */
    public static Frame bar(DataSet set, int mode, int margin, int width, int top, int labeling) { 
    // Define all the main things to be used
        // Define ArrayLists
        ArrayList<String> lines = new ArrayList<String>();

        //Sort the set! (Based on X values)
        set.sortOnIndex(0);

        // Get the X and Y values to be plotted
        ArrayList<Integer> xValues = set.getDataArray(0);
        ArrayList<Integer> yValues = set.getDataArray(1);

        Graph.test(new DataSet(yValues)).display();
    
        // Extremes
        // Sorts the set based on Y values
        set.sortOnIndex(1);
        // Create a set of Y-values that has been sorted
        ArrayList<Integer> sortedY = set.getDataArray(1);

        // Get the last (Biggest) and first (Smallest) elements of the Y values
        int max = set.getDataPoint( sortedY.size() - 1 )[1].intValue();
        int min = set.getDataPoint(0)[1].intValue();

        // Reset sorting back to X values
        set.sortOnIndex(0);

        // Set the height value depending on which mode is used
        int height = 0;
        switch (mode) {
            case -1:
                height = max;
                break;
            case -2:
                height = yValues.size();
                break;
            default:
                height = mode;
                break;
        }

        // Select the correct topper (This is the part the fits on top of the bar)
        char[] toppers = {'x', '_', '-', ' ', '='};
        String topper;

        if (top < 0) {
            // If it's negative just throw the topping in between some brackets
            topper = "[" + toppers[-top] + "]";
        }
        if (top > 0) {
            // Fill the topper with the desired topping making sure to cover the edges
            topper = fill(width * 2 + 3, toppers[top]);
        }
        if (top == 0) {
            topper = null;
        }
    

        

        // Gets the number of characters in the largest element of the Y axis set
        int maxDigits = digits(max, true);
        int minDigits = digits(min, true);
        int yMargin = (maxDigits > minDigits) ? maxDigits : minDigits;

        // String that seperates bars
        String barMarginSpace = fill(margin, ' ');
        String barMarginLine = fill(margin, '_');

        // Width of the bar - Must scale evenly so any value is multiplied by 2 so when added to 1 will always be odd
        String barWidthSpace = fill(width*2 + 1, ' ');
        String barWidthLine = fill(width*2 + 1, '_');

    // Render Graph
        // The graph is created by running through loops until every single thing that needs to get graphed is graphed
        boolean isGraphDone = false;

        // Set values according to whether or not labels need to be created
        boolean isYLabelDone = (labeling == 0 || labeling == 2) ? false : true;
        boolean isXLabelDone = isYLabelDone; // These are the same thing to start but they need to be seperated during graphing
        
        // Since the isDones may change the areLabel checks if labels were ever added, needed for formatting
        boolean areLabel = !isYLabelDone;

        // If this isn't set to true then nothing was graphed, end the graphing phase
        boolean pinged = false;


        // Add title if title is one of the labels expected
        if (labeling == 0 || labeling == 1) {
            lines.add(set.title);
        }


        // DELETE THESE WHEN DONE TESTING !!!
        isXLabelDone = true;


        int i = height;  
        while (!isGraphDone || !isYLabelDone || !isXLabelDone) {
            // Line that all graphics will be added to
            String line = "";

        // Graph the Y label
            if (!isYLabelDone) {
                // Get the character of the Y label at the height-i index
                line += set.yLabel.charAt( height - i ) + "  ";

                // If the label is at the last index then don't add it next time
                if ((height - i) == set.yLabel.length() - 1) {
                    isYLabelDone = true;
                }
            }
            // If the Y label is done then make sure to add extra spaces to keep indentation right
            else if (areLabel) {
                line += "   ";
            }
            
        // Works on graph as long as it's not done
            if (!isGraphDone) {
                // Adds spaces before the number
                line += fill(yMargin - digits(i, true), ' ')  + i + " --> |";

                // Reset pinged to false before each run through
                pinged = false;

                // Sets the spacing/margin between the bars based on whether or not it's 0
                String barMargin = (i == 0) ? barMarginLine : barMarginSpace;
                String barWidth = (i == 0) ? barWidthLine : barWidthSpace;

                for (int j = 0; j < yValues.size(); j++) {
                    // The current Y value being graphed
                    int header = yValues.get(j).intValue();

                    // If header ends at the current level then add the topper
                    if (header == i) {
                        if (topper == null) {
                            line += " " + header + " ";
                        } else {
                            line += barMargin + topper;
                        }
                        pinged = true;
                        continue;
                    }

                    // If header topper comes later then just make lines
                    if (header >= i && i > 0  ||  header <= i && i < 0) {
                        line += barMargin + "|" + barWidth + "|";
                        pinged = true;
                        continue;
                    } 

                    // If the bar isn't just graph nothing
                    if (header <= i && i > 0 || header >= i && i < 0) {
                        line += barMargin + " " + barWidth + " ";
                        continue;
                    }
                }
                // Checks if graph is complete by seeing if no variables got graphed and the line is below the start and isn't at 0
                if (!pinged && i < max && i != 0) {
                    // Creates a little bottom bar
                    for (int j = 0; j < yValues.size(); j++) {
                        line += barMarginLine + barWidthLine + "__";
                    }

                    // Stop graphing
                    isGraphDone = true;
                }
            }
    
        // Graph the X label if everything else is done
            if (!isXLabelDone) {
                // Not Yet :(
            }


        // Add the line and continue on
            lines.add(line);
            i--;
        }
        
        // Alas the graph is complete
        return new Frame(lines, set);
    }
}