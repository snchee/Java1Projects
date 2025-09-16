
public class Driver {
	public static void main(String[] args) {
        // Test legal triangle
        Triangle triangle1 = new Triangle(5.0, 5.0, 5.0);
        System.out.println("The three sides of the legal triangle are: " + triangle1.getSideA() + " " + triangle1.getSideB() + " " + triangle1.getSideC());

        triangle1.setSideA(9.0);
        triangle1.setSideB(6.0);
        triangle1.setSideC(7.0);
        System.out.println("A was set to 9, then B to 6 and C to 7: " + triangle1);

        // Test illegal triangle
        Triangle triangle2 = new Triangle(2.0, 2.0, 10.0);
        System.out.println("The illegal triangle contained: " + triangle2);

        // Modify illegal triangle
        triangle2.setSideA(7.0);
        System.out.println("Changed side A to 7: " + triangle2);
        
        triangle2.setSideB(-10.0);
        System.out.println("Changed side B to -10: " + triangle2);
        
        triangle2.setSideC(21.0);
        System.out.println("Changed side C to 21: " + triangle2);
    }
}
