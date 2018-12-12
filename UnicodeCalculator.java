package deliver1_2;
import java.util.Scanner;

public class UnicodeCalculator {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String input;
		String string1;
		String string2;
		int str1;
		int str2;
		int diff;
		
		//get string from user
		do {
			System.out.print("Enter two words: ");
			input = scnr.nextLine();
			input = removeWhite(input);
			string1 = input.substring(0, input.indexOf(' '));
			string2 = input.substring(input.indexOf(' ') + 1, input.length());	
			string2 = removeWhite(string2);
		}
		while (!validate(string1, string2));
		
		scnr.close();
		
		//calculate
		str1 = sum(string1);
		System.out.println("Sum of first word: " + str1 + "\n");
		str2 = sum(string2);
		System.out.println("Sum of second word: " + str2 + "\n");
		diff = Math.abs(str1 - str2);
		
		//display results
		System.out.println("Difference: " + diff);
	}
	
	public static String removeWhite(String check) {
		String input = check;
		while (Character.isWhitespace(input.charAt(0))) {
			input = input.substring(1, input.length());
		}
		while (Character.isWhitespace(input.charAt(input.length() - 1))) {
			input = input.substring(0, input.length() - 1);
		}
		return input;
	}
	
	public static boolean validate(String string1, String string2) {
		if ((string1.length()) > 0 && (string2.length() > 0)) {
			String words = string1 + string2;
			for (int i = 0; i < words.length(); ++i) {
				if (!Character.isLetter(words.charAt(i))) {
					if (words.charAt(i) == ' ') {
						System.out.println("INVALID INPUT - two words only!");
					}
					else {
						System.out.println("INVALID INPUT - letters a-z/A-Z only!");
					}
					return false;
				}
			}
			return true;			
		}
		else {
			System.out.println("INVALID INPUT - try again...");
			return false;
		}
	}
	
	public static int sum(String find) {
		int letter;
		int sum = 0;
		for (int i = 0; i < find.length(); ++i) {
			letter = find.charAt(i);
			System.out.println(find.charAt(i) + ": " + letter);
			sum += letter;
		}
		return sum;
	}
}
