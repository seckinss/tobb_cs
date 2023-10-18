import java.util.Scanner;
public class SortAges
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		final int YEAR = 2022; 
		System.out.print("Welcome, please enter your birth years\nMr.Bıdık's birth year: ");
		int bidikAge = YEAR - scan.nextInt();
		System.out.println("---------------------------------------");
		System.out.print("Defne's birth year: ");
		int defneAge = YEAR - scan.nextInt();
		System.out.println("---------------------------------------");
		System.out.print("Subramani's birth year: ");
		int subramaniAge = YEAR - scan.nextInt();
		System.out.println("---------------------------------------");
		System.out.print("Matthew's birth year: ");
		int matthewAge = YEAR - scan.nextInt();
		System.out.println("---------------------------------------");
		System.out.print("Hang's birth year: ");
		int hangAge = YEAR - scan.nextInt();
		System.out.println("---------------------------------------");
		String youngest, oldest;
		if((bidikAge<122) && (bidikAge<122) && (defneAge<122) && (subramaniAge<122) && (matthewAge<122) && (hangAge<122)) 
		{	
			System.out.println("Mr. Bıdık is " + bidikAge + " years old.");
			System.out.println("Defne is " + defneAge + " years old.");
			System.out.println("Subramani is " + subramaniAge + " years old.");
			System.out.println("Matthew is " + matthewAge + " years old.");
			System.out.println("Hang is " + hangAge + " years old.\n");

			if((bidikAge > defneAge) && (bidikAge > subramaniAge) && (bidikAge > matthewAge) && (bidikAge > hangAge) )
				oldest = "Mr. Bıdık";
			else
				if((defneAge > bidikAge) && (defneAge > subramaniAge) && (defneAge > matthewAge) && (defneAge > hangAge))
					oldest = "Defne";
				else
					if((subramaniAge > bidikAge) && (subramaniAge > defneAge) && (subramaniAge > matthewAge) && (subramaniAge > hangAge))
						oldest = "Subramani";
					else
						if ((matthewAge > bidikAge) && (matthewAge > defneAge) && (matthewAge > subramaniAge) && (matthewAge > hangAge))
							oldest = "Matthew";
						else	
							oldest = "Hang";
							
			if ((bidikAge < defneAge) && (bidikAge < subramaniAge) && (bidikAge < matthewAge) && (bidikAge < hangAge) )
				youngest = "Mr. Bıdık";
			else
				if((defneAge < bidikAge) && (defneAge < subramaniAge) && (defneAge < matthewAge) && (defneAge < hangAge))
					youngest = "Defne";
				else
					if((subramaniAge < bidikAge) && (subramaniAge < defneAge) && (subramaniAge < matthewAge) && (subramaniAge < hangAge))
						youngest = "Subramani";
					else
						if ((matthewAge < bidikAge) && (matthewAge < defneAge) && (matthewAge < subramaniAge) && (matthewAge < hangAge))
							youngest = "Matthew";
						else	
								youngest = "Hang";
			System.out.println("Oldest person is: " + oldest + "\nYoungest person is: " + youngest );					
		}
		else
			System.out.println("Kids should be born after 1900.");
	}
}