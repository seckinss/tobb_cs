import java.util.Scanner;
public class Triangle
{
	public static void main(String[] args)
	{
	Scanner scan = new Scanner(System.in);
	System.out.print("Enter 3 integers: ");
	int edge1 = scan.nextInt();
	int edge2 = scan.nextInt();
	int edge3 = scan.nextInt();
	if (edge1>=edge2)
		if (edge1>=edge3)
			if (edge2+edge3<=edge1)
				System.out.println("There does not exist a triangle whose sides are " + edge1 + " " + edge2 + " " + edge3 + ".");
			else
				System.out.println("There exist a triangle whose sides are " + edge1 + " " + edge2 + " " + edge3 + ".");
		else
			if (edge1+edge2<=edge3)
				System.out.println("There does not exist a triangle whose sides are " + edge1 + " " + edge2 + " " + edge3 + ".");
			else
				System.out.println("There exist a triangle whose sides are " + edge1 + " " + edge2 + " " + edge3 + ".");
	else
		if(edge2>=edge3)
			if (edge1+edge3<=edge2)
				System.out.println("There does not exist a triangle whose sides are " + edge1 + " " + edge2 + " " + edge3 + ".");
			else
				System.out.println("There exist a triangle whose sides are " + edge1 + " " + edge2 + " " + edge3 + ".");
		else 
			if (edge1+edge2<=edge3)
				System.out.println("There does not exist a triangle whose sides are " + edge1 + " " + edge2 + " " + edge3 + ".");
			else
				System.out.println("There exist a triangle whose sides are " + edge1 + " " + edge2 + " " + edge3 + ".");
	}


}