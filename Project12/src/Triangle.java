import java.text.DecimalFormat;

public class Triangle {
	// Instance variables
    private double sideA;
    private double sideB;
    private double sideC;
    
    // Constants
    private static final DecimalFormat FORMATTER = new DecimalFormat("#.###");
    private static final double DEFAULT_SIDE_LENGTH = 1.0;

    // Constructor
    public Triangle(double sideA, double sideB, double sideC) {
        if (isTriangle(sideA, sideB, sideC)) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        } else {
            // If not a valid triangle, assign default side lengths
            this.sideA = DEFAULT_SIDE_LENGTH;
            this.sideB = DEFAULT_SIDE_LENGTH;
            this.sideC = DEFAULT_SIDE_LENGTH;
        }
    }

    // Accessors
    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    // Mutators
    public boolean setSideA(double sideA) {
        if (isTriangle(sideA, this.sideB, this.sideC)) {
            this.sideA = sideA;
            return true;
        }
        return false;
    }

    public boolean setSideB(double sideB) {
        if (isTriangle(this.sideA, sideB, this.sideC)) {
            this.sideB = sideB;
            return true;
        }
        return false;
    }

    public boolean setSideC(double sideC) {
        if (isTriangle(this.sideA, this.sideB, sideC)) {
            this.sideC = sideC;
            return true;
        }
        return false;
    }

    // Private helper method to check if the sides form a valid triangle
    private static boolean isTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a;
    }

    // toString method
    @Override
    public String toString() {
        return "Triangle(" + FORMATTER.format(sideA) + ", " + FORMATTER.format(sideB) + ", " + FORMATTER.format(sideC) + ")";
    }
}


