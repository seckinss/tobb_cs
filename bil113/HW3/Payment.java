import java.util.*;
import java.text.NumberFormat;
public class Payment
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter the initial debt: ");
		double debt = scan.nextInt();
		System.out.print("Please enter the yearly interest rate (in percentages): ");
		double rate = scan.nextDouble();
		System.out.print("Please enter the monthly payment you want to make:");
		double monthlyPayment = scan.nextDouble();
		double monthlyRate = rate/12.00;
		int month = 0;
		NumberFormat fm1 = NumberFormat.getCurrencyInstance();
		while (debt>0)
		{
			debt = debt - monthlyPayment + monthlyRate*debt/100;
			
			month++;
		}
		System.out.print("It takes " + month + " months to pay the debt and the total payment equals to " + fm1.format(month*monthlyPayment + debt));

		}
}