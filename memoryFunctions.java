import java.util.ArrayList;

/*******************************************************
 * Megan Gerth megger5968 SDC230L
 * Date: 10/16/2025
 * Assignment: Project Java Lab 
 * Memory Functions Class - used to encapsulate memory-related operations
 */
public class memoryFunctions {
    //method to store a number in memory
    public static void memoryStorage(ArrayList<Double> memArr, double num) {
        if (memArr.size() > 9) {
            System.out.println("Sorry, memory full!");
        }    
        else {
            memArr.add(num);
            System.out.printf("%.2f has been stored in memory at location %d%n", memArr.get(memArr.size() - 1), memArr.size() - 1);
        }
    }
    //method to recall numbers in memory
    public static void memoryRecall(ArrayList<Double> memArr) {
        System.out.printf("%nThis is your current memory array's values, organized by their order: %n");
        System.out.printf("%s%8s%n", "Index", "Value");
        System.out.println("-------------------");
        //Print the initial values in the array - should be all zeros
        for (int i = 0; i < memArr.size(); i++) {
            System.out.printf("%5d%8.2f%n", i, memArr.get(i));
        }
        System.out.println("-------------------");
        System.out.printf("The number of values in your array is %d.%n", memArr.size());
    }
    //method to remove a number from memory
    public static void memoryRemove(ArrayList<Double> memArr, double r) {
        boolean removed = memArr.remove(r);
        if (removed) System.out.printf("Removed %.2f%n", r);
        else System.out.printf("Could not find %.2f%n", r);
    }
    //method to perform calculations on memory values
    public static void memoryCalculations(ArrayList<Double> memArr) {
        double total = 0.0;
        double average = 0.0;
        double difference = 0.0;
        //Use for loop to add the array numbers to a running total
        for (double num : memArr) {
            total += num;
        }
        //Print the sum of the ArrayList
        System.out.printf("1. The sum of the values in your current array is %.2f.%n", total);
        //Calculate the average
        average = total / memArr.size();
        //Print the average
        System.out.printf("2. The average of the values in your current array is %.2f.%n", average);
        //if list is greater than 1, find the difference between the first and last value
        if (memArr.size() > 1) {
            double first = memArr.get(0);
            double last = memArr.get(memArr.size() - 1);
            difference = first - last;
            System.out.printf("3. The difference between the first and last value in your current array is %.2f.%n", difference);
        }
        else {
            System.out.println("3. Not enough values in the array to calculate the difference between the first and last value.");
        }
    }
}
