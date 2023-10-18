import java.util.Scanner; 
public class ComputeDistances
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter two points :");
		int point1x = scan.nextInt();
		int point1y = scan.nextInt();
		int point2x = scan.nextInt();
		int point2y = scan.nextInt();
		double mDistance = Math.abs(point1x - point2x) + Math.abs(point1y - point2y); 
		double eDistance = Math.sqrt(Math.pow((point1x-point2x), 2) + Math.pow((point1y-point2y), 2));
		double numeratorCosine = (point1x*point2x)+(point1y*point2y) ;
		double denominatorCosine = (Math.sqrt(Math.pow(point1x,2)+Math.pow(point1y,2)))*(Math.sqrt(Math.pow(point2x,2)+Math.pow(point2y,2)));
		double cDistance = 1 -  (numeratorCosine/denominatorCosine);
		System.out.println(mDistance);
		System.out.println(eDistance);
		System.out.println(cDistance);
	}
}