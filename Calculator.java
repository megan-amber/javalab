/*******************************************************
 * Megan Gerth megger5968 SDC230L
 * Date: 10/16/2025
 * Assignment: Project Java Lab 
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Calculator {
    public static void main(String[] args) throws Exception {
        //initialize variables
        double num1; 
        String operator;
        double num2;
        double memVal = 1; 
        double result = 0.0;
        ArrayList<Double> memArray = new ArrayList<Double>();
        boolean greenLight = true;
        //create a scanner
        Scanner input = new Scanner(System.in);

        //print a header explaining the assignment
        System.out.println("=======================================================================================================");
        System.out.println("This submission is for Week 4 of SDC230L to showcase adding Exception Handling; authored by Megan Gerth");
        System.out.println("=======================================================================================================");
        //print a welcome message
        System.out.println("Welcome to Megan's Calculator Program!\n");
        getMenu();
        do {
            try {
                System.out.print("Please enter your math problem, 0 0 0 to exit, or 1 1 1 to see the rules again: ");
                //scan values into variables
                num1 = input.nextDouble();
                operator = input.next();
                num2 = input.nextDouble();
                if (operator.equals("0")) {
                    System.out.println("Exiting program...");
                    greenLight = false;
                    input.close();
                    return; 
                }
                //create a loop to allow multiple calculations until user decides to exit
                while (!operator.equals("0")) {
                    if (operator.equals("1")) {
                        getMenu();
                        System.out.print("Please enter your math problem, 0 0 0 to exit, or 1 1 1 to see the rules again: ");
                        num1 = input.nextDouble();
                        operator = input.next();
                        num2 = input.nextDouble();
                        continue;
                    }
                    else if (operator.equals("2")) {
                        System.out.printf("The current value in memory is: %.2f", memVal);
                        System.out.println("\nEnter 1 to enter a new value or 2 to delete the current value: ");
                        int option = input.nextInt();
                        if (option == 1) {
                            System.out.println("\nWhat new value would you like to store in memory? ");
                            memVal = input.nextDouble();
                        } else if (option == 2) {
                            memVal = 0.0;
                            System.out.println("Memory has been set to the default value of 0.0.");
                        }
                        System.out.printf("The current value in memory is: %.2f%n", memVal);
                        operator = "1";
                        continue;
                    }
                    else if (operator.equals("3")) {
                        memoryRecall(memArray);
                        memoryCalculations(memArray);
                        String choice;
                        if (memArray.size() < 10) {
                            System.out.println("Would you like to add another value in memory? (Y/N)");
                            choice = input.next();
                            boolean cont = true;
                            do {
                                if (choice.equals("Y")|| choice.equals("y")) {
                                    System.out.println("Enter the value you would like to add?");
                                    double userVal = input.nextDouble();
                                    memoryStorage(memArray, userVal);
                                    System.out.println("Would you like to add another value in memory or enter N if full? (Y/N)");
                                    choice = input.next();
                                } else {
                                    cont = false;
                                }
                            } while (cont);
                        }
                        System.out.println("Would you like to remove a value in memory? (Y/N)");
                        choice = input.next();
                        boolean cont = true;
                        do {
                            if (choice.equals("Y")|| choice.equals("y")) {
                                System.out.println("What value would you like to remove?");
                                memVal = input.nextDouble();
                                memoryRemove(memArray, memVal);
                                System.out.println("Would you like to remove another value in memory? (Y/N)");
                                choice = input.next();
                            } else {
                                cont = false;
                            }
                        } while (cont);
                        operator = "1";
                        continue;
                    }
                    else if (operator.equals("+")) {
                        result = Operations.add(num1, num2);
                        System.out.printf("The sum of %.2f + %.2f is %.2f.%n", num1, num2, result);
                    } else if (operator.equals("-")) {
                        result = Operations.sub(num1, num2);
                        System.out.printf("The difference of %.2f - %.2f is %.2f.%n", num1, num2, result);
                    } else if (operator.equals("*")) {
                        result = Operations.mul(num1, num2);
                        System.out.printf("The product of %.2f * %.2f is %.2f.%n", num1, num2, result);
                    } else if (operator.equals("/")) {
                        try {
                            result = Operations.div(num1, num2);
                            System.out.printf("The quotient of %.2f / %.2f is %.2f.%n", num1, num2, result);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            operator = "1";
                            continue;
                        }
                    } else {
                        System.out.println("Invalid operator. Please use +, -, *, or /.");
                        throw new IllegalArgumentException();
                    }
                    //prompt user if they would like to store value in multi value memory array
                    String choice;
                    System.out.println("Would you like to store your value in memory? (Y/N)");
                    choice = input.next();
                    if (choice.equals("Y")|| choice.equals("y")) {
                        memoryStorage(memArray, result);
                    }

                    //prompt user for another calculation
                    System.out.print("Please enter your math problem, 0 0 0 to exit, or 1 1 1 to see the rules again: ");
                    num1 = input.nextDouble();
                    operator = input.next(); 
                    num2 = input.nextDouble();
                } 
            } catch (InputMismatchException e) {
                System.err.printf("Error: %s. Invalid input. Please enter your expression as number operator number, seperated by spaces (e.g. 5 + 3).%n%n", e.getMessage());
                input.nextLine(); //clear the invalid input
            } catch (IllegalArgumentException e) {
                System.err.printf("Error: %s. Calculation could not be completed due to invalid operator.%n%n", e.getMessage());
                input.nextLine(); //clear the invalid input
            } 
        } while (greenLight);
        //Thank user for trying system
        System.out.println("Thank you for trying Megan's Calculator Program!");

    }
    public static void getMenu() {
        System.out.println("\nRules for Use:");
        System.out.println("1. You may perform addition (+), subtraction (-), multiplication (*), and division (/).");
        System.out.println("2. Please enter your math problem in the following format: number operator number (e.g., 5 + 3)");
        System.out.println("3. Enter 0 0 0 to exit the program.");
        System.out.println("4. Enter 1 1 1 to see these rules again.");
        System.out.println("5. Enter 2 2 2 for the Single Value Memory.");
        System.out.println("6. Enter 3 3 3 to view the Multi-value Memory.");  
    }
    public static void memoryStorage(ArrayList<Double> memArr, double num) {
        if (memArr.size() > 9) {
            System.out.println("Sorry, memory full!");
        }    
        else {
            memArr.add(num);
            System.out.printf("%.2f has been stored in memory at location %d%n", memArr.get(memArr.size() - 1), memArr.size() - 1);
        }
    }
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
    public static void memoryRemove(ArrayList<Double> memArr, double r) {
        boolean removed = memArr.remove(r);
        if (removed) System.out.printf("Removed %.2f%n", r);
        else System.out.printf("Could not find %.2f%n", r);
    }
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
    }

}
    
