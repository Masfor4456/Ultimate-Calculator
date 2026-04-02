import java.util.ArrayList;

public class MemoryCalculator {

    // Stores a single value (can be null if empty)
    private Integer singleValue = null;

    // Stores multiple values (max 10)
    private ArrayList<Integer> values = new ArrayList<>();

    // Store a single value
    public void storeSingle(int value) {
        singleValue = value;
    }

    // Retrieve stored value
    public Integer retrieveSingle() {
        return singleValue;
    }

    // Clear stored value
    public void clearSingle() {
        singleValue = null;
    }

    // Add value to list (limit of 10 values)
    public void addValue(int value) {
        if (values.size() < 10) {
            values.add(value);
        } else {
            System.out.println("Maximum of 10 values reached.");
        }
    }

    // Display all values in list
    public void displayValues() {
        System.out.println("Values: " + values);
    }

    // Calculate sum of all values
    public int sumValues() {
        int sum = 0;

        for (int val : values) {
            sum += val;
        }

        return sum;
    }

    // Calculate average of values
    public double averageValues() {
        if (values.isEmpty()) return 0;

        return (double) sumValues() / values.size();
    }
}