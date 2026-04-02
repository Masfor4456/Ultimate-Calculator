/**
 * Name: Mason Ford
 * Date: 2026
 * Assignment: Combined Calculator Application
 * Description: This program is a menu-driven calculator that performs
 * basic math operations and includes memory features. It also handles
 * invalid input using exception handling.
 */

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Scanner for user input
        Scanner input = new Scanner(System.in);

        // Create memory calculator object
        MemoryCalculator memory = new MemoryCalculator();

        // Controls program loop
        boolean running = true;

        // Program title
        System.out.println("=== Ultimate Calculator ===");
        System.out.println("By Mason Ford\n");

        // Main loop (keeps program running until user exits)
        while (running) {
            try {
                // Display menu
                System.out.println("\n--- MAIN MENU ---");
                System.out.println("1. Add");
                System.out.println("2. Subtract");
                System.out.println("3. Multiply");
                System.out.println("4. Divide");

                System.out.println("5. Store single value");
                System.out.println("6. Retrieve single value");
                System.out.println("7. Clear single value");

                System.out.println("8. Add value to list");
                System.out.println("9. Display values");
                System.out.println("10. Sum of values");
                System.out.println("11. Average of values");

                System.out.println("0. Exit");

                // Get user choice
                System.out.print("Enter choice: ");
                int choice = Integer.parseInt(input.nextLine());

                switch (choice) {

                    // ===== BASIC CALCULATOR =====
                    case 1:
                    case 2:
                    case 3:
                    case 4:

                        // Get numbers safely using helper method
                        double num1 = getDouble(input, "Enter first number: ");
                        double num2 = getDouble(input, "Enter second number: ");

                        double result = 0;

                        // Perform selected operation
                        switch (choice) {
                            case 1: // Addition
                                result = num1 + num2;
                                break;

                            case 2: // Subtraction
                                result = num1 - num2;
                                break;

                            case 3: // Multiplication
                                result = num1 * num2;
                                break;

                            case 4: // Division
                                // Prevent divide by zero
                                if (num2 == 0) {
                                    System.out.println("Error: Cannot divide by zero.");
                                    continue; // skip rest and go back to menu
                                }
                                result = num1 / num2;
                                break;
                        }

                        // Display result
                        System.out.println("Result: " + result);
                        break;

                    // ===== SINGLE MEMORY FEATURES =====
                    case 5:
                        // Store a single value
                        int value = (int) getDouble(input, "Enter value: ");
                        memory.storeSingle(value);
                        break;

                    case 6:
                        // Retrieve stored value
                        System.out.println("Stored value: " + memory.retrieveSingle());
                        break;

                    case 7:
                        // Clear stored value
                        memory.clearSingle();
                        System.out.println("Value cleared.");
                        break;

                    // ===== LIST MEMORY FEATURES =====
                    case 8:
                        // Add value to list
                        int listValue = (int) getDouble(input, "Enter value: ");
                        memory.addValue(listValue);
                        break;

                    case 9:
                        // Display all stored values
                        memory.displayValues();
                        break;

                    case 10:
                        // Show sum of values
                        System.out.println("Sum: " + memory.sumValues());
                        break;

                    case 11:
                        // Show average of values
                        System.out.println("Average: " + memory.averageValues());
                        break;

                    case 0:
                        // Exit program
                        running = false;
                        System.out.println("\nThank you for using the calculator!");
                        break;

                    default:
                        // Invalid menu option
                        System.out.println("Invalid option.");
                }

            } catch (NumberFormatException e) {
                // Handles invalid number input (letters, symbols, etc.)
                System.out.println("Invalid input! Please enter numbers only.");
            }
        }

        // Close scanner to prevent resource leak
        input.close();
    }

    // Helper method to safely get a double from user
    public static double getDouble(Scanner input, String message) {

        while (true) {
            try {
                System.out.print(message);

                // Parse input as double
                return Double.parseDouble(input.nextLine());

            } catch (NumberFormatException e) {
                // If input is not a number, ask again
                System.out.println("Invalid number. Try again.");
            }
        }
    }
}