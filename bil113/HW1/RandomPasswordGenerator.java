import java.util.Random;
// this program gives a 7 characters long random password with spesific details.
public class RandomPasswordGenerator
{
	public static void main(String[] args)
	{
		Random numGen = new Random();
		int first = numGen.nextInt(26) + 10 ; //Picking numbers between 10 - 35
		int second =numGen.nextInt(26) + 10 ;
		int third = numGen.nextInt(10); //Picking numbers between 0 - 10
		int fourth = numGen.nextInt(26) + 36 ;
		int fifth = numGen.nextInt(26) + 36 ;
		int sixth = numGen.nextInt(52) + 10 ; //Picking numbers between 10 - 61
		int seventh = numGen.nextInt(52) + 10 ;
		String characters = "0123456789wqertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM"; //Defined all characters in characters variable.
		char firstLet = characters.charAt(first); //Choosing the number on characters variable with random number which produced at 7th line.
		char secondLet = characters.charAt(second);		
		char thirdNum = characters.charAt(third);
		char fourthLet = characters.charAt(fourth);
		char fifthLet = characters.charAt(fifth);
		char sixthLet = characters.charAt(sixth);
		char seventhLet = characters.charAt(seventh);
		System.out.println("" + firstLet + secondLet + thirdNum + fourthLet + fifthLet + sixthLet + seventhLet ); 
		
	}
}
		