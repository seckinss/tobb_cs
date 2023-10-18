import java.util.Scanner;
public class Decrypt
{
	public static void main(String[] args)
	{
		String characters ="zyxwvutsrqponmlkjihgfedcbazyx                                                                 ";
		Scanner scan = new Scanner(System.in);
		System.out.print("Ciphertext: ");
		String code= scan.nextLine();
		char firstLetter = characters.charAt(125 - (int) code.charAt(0)); 
		char secondLetter = characters.charAt(125 - (int) code.charAt(1));
		char thirdLetter = characters.charAt(125 - (int) code.charAt(2));
		char fourthLetter = characters.charAt(125 - (int) code.charAt(3));
		char fifthLetter = characters.charAt(125 - (int) code.charAt(4));
		char sixthLetter = characters.charAt(125 - (int) code.charAt(5));
		char seventhLetter = characters.charAt(125 - (int) code.charAt(6));
		char eighthLetter = characters.charAt(125 - (int) code.charAt(7));
		char ninthLetter = characters.charAt(125 - (int) code.charAt(8));
		char tenthLetter = characters.charAt(125 - (int) code.charAt(9));
		char eleventhLetter = characters.charAt(125 - (int) code.charAt(10));
		char twelfthLetter = characters.charAt(125 - (int) code.charAt(11) );
		char thirteenthLetter = characters.charAt(125 - (int) code.charAt(12));
		char fourteenthLetter = characters.charAt(125 - (int) code.charAt(13));

			
		System.out.print("Plaintext: " + firstLetter + secondLetter + thirdLetter + fourthLetter + fifthLetter + sixthLetter + seventhLetter );
		System.out.print("" + eighthLetter + ninthLetter + tenthLetter + eleventhLetter + twelfthLetter + thirteenthLetter + fourteenthLetter );	
	}
}

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			