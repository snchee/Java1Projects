
public class StringExample {
	public static void main(String[] args) {
		String courseId = "CS 1323";
		//primitive data
		int number = 0;
		double average = 0.0;
		
		String pointer = new String("Jazz");
		String labMix = new String("Raven");
		String oldDog = new String ("Raven");
		String pointerL = "jazz";
		
		System.out.println(pointer == oldDog);
		System.out.println(labMix == oldDog);
		
		System.out.println(pointer.equals(oldDog));
		System.out.println(labMix.equals(oldDog));
		System.out.println(pointer.equals(pointerL));
		System.out.println()
	}
}
