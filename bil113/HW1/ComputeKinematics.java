import java.util.Scanner;
public class ComputeKinematics
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your initial velocity: ");
		int velocity = scan.nextInt(); 
		System.out.println("Your initial velocity is: " + velocity);
		final double gravity = 9.81; 
		double hmax = Math.pow(velocity, 2) /(2*gravity);
		System.out.println("Maximum attitude is " + hmax);
		double halfoftime = velocity/gravity ;
		System.out.println("Duration of movement is " + (halfoftime*2)); 
	}
}
