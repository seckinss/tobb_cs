import java.util.Scanner;
public class Encrypt
{
	public static void main(String[] args)
	{
		String characters ="                                                              abcdefghijklmnopqrstuvwxyzabc";
		Scanner scan = new Scanner(System.in);
		System.out.print("Plaintext: ");
		String code= scan.nextLine();
		char firstLetter = characters.charAt((int) code.charAt(0) - 32); 
		char secondLetter = characters.charAt((int) code.charAt(1) - 32);
		char thirdLetter = characters.charAt((int) code.charAt(2) - 32);
		char fourthLetter = characters.charAt((int) code.charAt(3) - 32);
		char fifthLetter = characters.charAt((int) code.charAt(4) - 32);
		char sixthLetter = characters.charAt((int) code.charAt(5) - 32);
		char seventhLetter = characters.charAt((int) code.charAt(6) - 32);
		char eighthLetter = characters.charAt((int) code.charAt(7) - 32);
		char ninthLetter = characters.charAt((int) code.charAt(8) - 32);
		char tenthLetter = characters.charAt((int) code.charAt(9) - 32);
		char eleventhLetter = characters.charAt((int) code.charAt(10) - 32);
		char twelfthLetter = characters.charAt((int) code.charAt(11) - 32);
		char thirteenthLetter = characters.charAt((int) code.charAt(12) - 32);
		char fourteenthLetter = characters.charAt((int) code.charAt(13)- 32);

			
		System.out.print("Ciphertext: " + firstLetter + secondLetter + thirdLetter + fourthLetter + fifthLetter + sixthLetter + seventhLetter );
		System.out.print("" + eighthLetter + ninthLetter + tenthLetter + eleventhLetter + twelfthLetter + thirteenthLetter + fourteenthLetter );	
	}
}