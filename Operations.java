
public class Operations {
    
    //method to add two integers
    public static double add(double a, double b) {
        return a + b;
    }

    //method to subtract two doubles
    public static double sub(double a, double b) {
        return a - b;
    }

    //method to multiply two integers
    public static double mul(double a, double b) {
        return a * b;
    }

    //method to divide two doubles
    public static double div(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
    
}
