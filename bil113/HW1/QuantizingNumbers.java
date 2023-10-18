import java.util.Scanner;
public class QuantizingNumbers
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter six numbers in decreasing order:");
		double firstNum = scan.nextDouble(); //Getting numbers in decreasing order.
		double secondNum = scan.nextDouble();
		double thirdNum = scan.nextDouble();
		double fourthNum = scan.nextDouble();
		double fifthNum = scan.nextDouble();
		double sixthNum = scan.nextDouble();
		System.out.println("New value of xl is : "+ ((firstNum-sixthNum)/(firstNum-sixthNum))); //Calculates new values.
		System.out.println("New value of x2 is : "+ ((secondNum-sixthNum)/(firstNum-sixthNum)));
		System.out.println("New value of x3 is : "+ ((thirdNum-sixthNum)/(firstNum-sixthNum)));
		System.out.println("New value of x4 is : "+ ((fourthNum-sixthNum)/(firstNum-sixthNum)));
		System.out.println("New value of x5 is : "+ ((fifthNum-sixthNum)/(firstNum-sixthNum)));
		System.out.println("New value of x6 is : "+ ((sixthNum-sixthNum)/(firstNum-sixthNum)));
	}
}