import java.util.*;
import java.text.DecimalFormat;
public class PiNum
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Random randm = new Random();
		System.out.print("How many times we need to simulate?: ");
		DecimalFormat fmt =new DecimalFormat("0.######");
		int n =scan.nextInt();
		int m = 0;
		int simulate = n;
		while (n>0)
		{
			double x = randm.nextDouble(2)-1;
			double y = randm.nextDouble(2)-1;
			if (1 >= Math.pow(x,2) + Math.pow(y,2))
				m++;
			n--;	
		}
		String output = fmt.format(4.00 * m / simulate);
		while(output.length()<8)
		{
			output +="0";
		}
		System.out.println(output);
	}
}