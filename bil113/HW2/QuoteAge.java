import java.util.Scanner;
public class QuoteAge
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Provide a name,surname and birth year of a famous person: ");
		String personName = scan.next();
		String personSurname = scan.next();
		int personBYear = scan.nextInt();
		String blank = scan.nextLine();
		System.out.println("-------------------------------------------------------");
		System.out.print("Please enter a quote of this famous person: ");
		String personQuote = scan.nextLine();
		System.out.println("-------------------------------------------------------");
		System.out.print("Please enter the year that this quote is said: ");
		int personQYear = scan.nextInt();
		System.out.println("-------------------------------------------------------");
		System.out.print(personName +" "+ personSurname + " said \"" +  personQuote  + "\" at ");
		System.out.println("the age of " + (personQYear - personBYear) + ".");
		System.out.println("-------------------------------------------------------");
		
	}
}