/*******************************************************
 * Megan Gerth megger5968 SDC230L
 * Date: 10/16/2025
 * Assignment: Project Java Lab 
 */
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        //print a header explaining the assignment
        System.out.println("==================================================================================================");
        System.out.println("This submission is for Week 2 of SDC230L to Looping; authored by Megan Gerth");
        System.out.println("==================================================================================================");
        //print a welcome message
        System.out.println("Welcome to Megan's Calculator Program!\n");
        System.out.println("Rules for Use:");
        System.out.println("1. You may perform addition (+), subtraction (-), multiplication (*), and division (/).");
        System.out.println("2. Please enter your math problem in the following format: number operator number (e.g., 5 + 3)");
        System.out.println("3. Enter 0 0 0 to exit the program.\n");
        
        System.out.print("Please enter your math problem or 0 0 0 to exit: ");
        //create a scanner object to read user input
        Scanner input = new Scanner(System.in);

        double num1 = input.nextDouble();
        String operator = input.next();
        double num2 = input.nextDouble();
        //create a loop to allow multiple calculations until user decides to exit
        while (!operator.equals("0")) {
            if (operator.equals("+")) {
                double sum = Operations.add(num1, num2);
                System.out.printf("The sum of %.2f + %.2f is %.2f.%n", num1, num2, sum);
            } else if (operator.equals("-")) {
                double difference = Operations.sub(num1, num2);
                System.out.printf("The difference of %.2f - %.2f is %.2f.%n", num1, num2, difference);
            } else if (operator.equals("*")) {
                double product = Operations.mul(num1, num2);
                System.out.printf("The product of %.2f * %.2f is %.2f.%n", num1, num2, product);
            } else if (operator.equals("/")) {
                try {
                    double quotient = Operations.div(num1, num2);
                    System.out.printf("The quotient of %.2f / %.2f is %.2f.%n", num1, num2, quotient);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Invalid operator. Please use +, -, *, or /.");
            }
            //prompt user for another calculation
            System.out.print("Please enter your math problem or 0 0 0 to exit: ");
             num1 = input.nextDouble();
             operator = input.next(); 
             num2 = input.nextDouble();
        } 
        //Thank user for trying system
        System.out.println("Thank you for trying Megan's Calculator Program!");

    }
}