import java.util.*;
public class Gamble
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("How much money gambler have?: ");
		int balance = scan.nextInt();
		System.out.print("How much money is gambler's goal?: ");
		int goal = scan.nextInt();
		System.out.print("What is the probability of winning?: ");
		double possibility = scan.nextDouble();
		System.out.print("How many time we need to simulate this?: ");
		int simulate = scan.nextInt();
		int counter = 0;
		int simulate1 = simulate; 
		int firstBal = balance;
		Random numGen = new Random();
			while (simulate>0)
			{
				balance = firstBal;
				while (balance<goal && balance>0)
				{
					if (numGen.nextDouble() <= possibility)
						balance++;
					else
						balance--;
					if (balance==goal)
					{
						counter++;
					}
					
				}
				simulate--;
			}
		System.out.print("Win: " + counter + "\nLose: " + (simulate1-counter));
	}
}