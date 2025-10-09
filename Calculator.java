/*******************************************************
 * Megan Gerth megger5968 SDC230L
 * Date: 10/7/2025
 * Assignment: Project Java Lab 
 */
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        //print a header explaining the assignment
        System.out.println("==================================================================================================");
        System.out.println("This submission is for Week 1 of SDC230L to demonstrate IO and Operations; authored by Megan Gerth");
        System.out.println("==================================================================================================");
        //print a welcome message
        System.out.println("Welcome to Megan's Calculator Program!");
        System.out.printf("What do you need to calculate today?%n%n");
        //print out a menu for the user to choose from
        System.out.println("Choose from the following menu options:");
        System.out.println("1 for Addition");
        System.out.println("2 for Subtraction");
        System.out.println("3 for Multiplication");
        System.out.println("4 for Division");
        System.out.println("5 to  Exit the program");
        System.out.println();
        System.out.printf("Pick your poison (1-5): %n ");

        //create a scanner object to read user input
        Scanner input = new Scanner(System.in);
        //get input from user for menu choice
        int menuChoice = input.nextInt();
        //get two integers from the user and add together
        System.out.println("Enter two integer values:");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int sum = num1 + num2;
        System.out.printf("The sum of %d and %d is %d.%n", num1, num2, sum);
        System.out.println();
        //will need to reprompt user for menu choice, but will come back to that later
        //get two floating point values from the user and subtract value one from value two
        System.out.println("Enter two floating point values (2 decimal places):");
        double floatnum1 = input.nextDouble();
        double floatnum2 = input.nextDouble();
        double difference = floatnum2 - floatnum1;
        System.out.printf("The difference of %.2f and %.2f is %.2f.%n", floatnum2, floatnum1, difference);
        System.out.println();
        //Thank user for trying system
        System.out.println("Thank you for trying Megan's Calculator Program!");
    }
}
        