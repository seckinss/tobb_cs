import java.util.Scanner;
// this program gives celcius degree and centimeter values based on value entered by user as reamur degree and feet lenght.
public class StandardizeMeasurements
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in); 
		System.out.print("Enter a measurement:"); 
		float feetLength = scan.nextFloat();
		String word2 = scan.next(); 
		String word3 = scan.next();
		float reamurDegree = scan.nextFloat(); 
		String word5 = scan.next();
		final float CONVERSION_FACTOR  = (float) 30.48;  
		float centimeter = feetLength * CONVERSION_FACTOR ; 
		float celciusDegree = reamurDegree *((float)5/4);
		System.out.println(feetLength + " feet is " + centimeter +" centimeter."); 
		System.out.println(reamurDegree + " reamur degree is "+ celciusDegree + " celcius degree.");
	}     
}