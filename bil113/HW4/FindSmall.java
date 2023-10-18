import java.util.Scanner;
public class FindSmall
{
	public static int findSmall(int[] A,int k)
	{
		int smallNum = Integer.MAX_VALUE;
		int smallIndex = (int) Math.random();
		int length = k;
		while (k>0)
		{
			smallNum = Integer.MAX_VALUE;
			for(int index = A.length-1; index>=0;index--)
			{
				
				if (smallNum >= A[index])
				{
					smallNum = A[index];
					smallIndex = index;
				}
				
			}
			A[smallIndex] = Integer.MAX_VALUE;
			k--;
		}
		if (length>A.length)
			return 0;
		else
			return smallNum;
		
	}
	public static void main(String[] args)
	{
		int[] sample = {10,2,21,99,67,89,78,56,34,35,12,11,66,65,39}; //sample array
		Scanner scan = new Scanner(System.in);
		System.out.print("Which kth number do you want to find?:");
		int k = scan.nextInt();
		int kthNum = findSmall(sample,k);
		System.out.print(kthNum);
		
	}
}









