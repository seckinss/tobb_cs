import java.util.Scanner;
public class Shapes
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome, determine which shape's area is to be calculated:");
		System.out.println("----------------------------------------------------------");
		System.out.print("Please select a shape to be calculated\nType of area: ");
		String areaType = scan.next();
		System.out.println("----------------------------------------------------------");
		if (areaType.equals("triangle"))
		{
			System.out.print("You choose to calculate triangle's area,\nPlease enter the length of the edge: ");
			double edgeLength = scan.nextDouble();
			System.out.print("Please enter length of the height relative to the edge: ");
			double heightLength = scan.nextDouble();
			double areaSize	= (edgeLength * heightLength)/2;
			System.out.println("----------------------------------------------------------------");
			System.out.println("The area of the triangle where the edge has "+ edgeLength +" unit length and the height attached to the edge "+ heightLength +" unit is "+ areaSize +".");
			System.out.println("----------------------------------------------------------------");
		}
		else
			if (areaType.equals("square"))
			{
				System.out.print("You choose to calculate square's area,\nPlease enter the side length of the square: ");
				double sideLength = scan.nextDouble();
				double areaSize =  Math.pow(sideLength , 2 );
				System.out.println("------------------------------------------------------------");
				System.out.println("The area of a square with a side length of " + sideLength + " unit is " + areaSize + ".");
				System.out.println("------------------------------------------------------------");
			}
			else
				if (areaType.equals("rectangle"))
				{
					System.out.print("You choose to calculate rectangle's area,\nPlease enter the length of the first side: ");
					double side1Length = scan.nextDouble();
					System.out.print("Please enter the length of the second side: ");
					double side2Length = scan.nextDouble();
					double areaSize	= side1Length * side2Length;
					System.out.println("--------------------------------------------------------------");
					System.out.println("The area of a rectangle with side lengths of "+ side1Length +" and "+ side2Length +" unit is "+ areaSize +".");
					System.out.println("--------------------------------------------------------------");
				}
				else
					if (areaType.equals("parallelogram"))
					{
						System.out.print("You choose to calculate parallelogram's area,\nPlease enter the length of the side: ");
						double sideLength = scan.nextDouble();
						System.out.print("Please enter length of the height relative to the edge: ");
						double heightLength = scan.nextDouble();
						double areaSize	= sideLength * heightLength;
						System.out.println("----------------------------------------------------------------");
						System.out.println("The area of the parallelogram where the side has "+ sideLength +" unit length and the height attached to the side is "+ heightLength +" unit is "+ areaSize +".");
						System.out.println("----------------------------------------------------------------");
					}
					else
						if (areaType.equals("trapezoid"))
						{
							System.out.print("You choose to calculate trapezoid's area,\nPlease enter the length of the first side: ");
							double side1Length = scan.nextDouble();
							System.out.print("Please enter the length of the second side: ");
							double side2Length = scan.nextDouble();
							System.out.print("Please enter length of the height relative to the sides: ");
							double heightLength = scan.nextDouble();
							double areaSize	= ((side1Length + side2Length) * heightLength)/2 ;
							System.out.println("-----------------------------------------------------------------------");
							System.out.println("The area of a trapezoid with sides lengths of " + side1Length + " and " + side2Length + " unit and sides distance of " + heightLength + " unit is " + areaSize + ".");
							System.out.println("-----------------------------------------------------------------------");
						}
						else
							System.out.println("We cannot calculate this are of this shape.");
	}
}