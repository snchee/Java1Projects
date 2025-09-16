// Stella Chee
public class Project2 {
	public static void main(String[] args)
	{
		String bookOne = "Three Sisters, Bi Feiyu";
		String bookTwo = "Song of Solomon, Toni Morrison";
		String bookThree = "Owls Do Not Have to Mean Death, Chip Livingston";
		
		double priceOne = 18.99;
		double priceTwo = 11.99;
		double priceThree = 80.50;
		
		int amtOne = 2;
		int amtTwo = 4;
		int amtThree = 1;
		
		final double TAXRATE = 0.0875;
		
		double beforeTaxCost = priceOne * amtOne + priceTwo * amtTwo + priceThree * amtThree;
		
		double tax = beforeTaxCost * TAXRATE;
		
		double afterTaxCost = beforeTaxCost + tax;
		
		System.out.println("Purchase " + amtOne + " copies of " + bookOne + ". Each copy costs $" + priceOne + ".");
		System.out.println("Purchase " + amtTwo + " copies of " + bookTwo + ". Each copy costs $" + priceTwo + ".");
		System.out.println("Purchase " + amtThree + " copy of " + bookThree + ". Each copy costs $" + priceThree + "0.");
		System.out.println("Total before tax: $" + beforeTaxCost);
		System.out.println("Sales tax: $" + String.format("%.2f", tax));
		System.out.println("The total cost of your order will be $" + String.format("%.2f", afterTaxCost));
	}
}