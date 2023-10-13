package ASCII_Graphs;

class ASCII_Exceptions extends Exception {
    public valueMismatch() {
        super("Error - Type Mistmatch: Incorrect number of values in a point for DataSet");
    }
}