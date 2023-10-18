public class FractionalNumber
{
	private int numerator;
	private int denominator; 
	
	public FractionalNumber(String fractNum) 
	{
		numerator = 0;
		denominator = 0;
		int digit=0;
		int g=0;
		while (fractNum.charAt(digit) != '/') //If we leave fractNum space character in the string, it will give an error.
		{
			digit++;
		}
		while (digit > 0)
		{
			numerator = numerator + (fractNum.charAt(g)-48)*(int)Math.pow(10, digit-1);
			digit--;
			g++;
		}
		fractNum = fractNum.substring(g+1,fractNum.length());
		g = 0; 
		int b = fractNum.length();
		while (b > 0)
		{
			denominator = denominator + (fractNum.charAt(g)-48)*(int)Math.pow(10, b-1);
			b--;
			g++;
		}
	}
	public FractionalNumber(int a, int b)
	{
		numerator = a;
		denominator = b;
	}
	public double getDoubleValue()
	{
		double value = (double)numerator/denominator;
		return value;
	}
	public String toString()
	{
		String result = Integer.toString(numerator) + "/" + Integer.toString(denominator);
		return result;
	}
	public boolean equals(FractionalNumber fn2) 
	{
		double value = fn2.getDoubleValue();
		boolean d = (value == (double) numerator/denominator);
		return d;
	} 
	public FractionalNumber simplify()
	{
		int divisor = 2;
		int b = numerator;
		int c = denominator;
		if ((double) numerator/denominator < 0)
		{
			b = (int)Math.abs(numerator);
			c = (int)Math.abs(denominator);
			while (b>=divisor && c>=divisor)
			{
				if ( b%divisor==0 && c%divisor==0)
				{
					b = b / divisor;
					c = c / divisor;
					divisor = 1;
				}
				divisor++;
			}
			b = -b;
		}
		else 
		{
			if ((double) numerator / denominator > 0 && (numerator < 0 ))
			{
				b = -b;
				c = -c;
			}
		}
		while (b>=divisor && c>=divisor)
		{
			if ( b%divisor==0 && c%divisor==0)
			{
				b = b / divisor;
				c = c / divisor;
				divisor = 1;
			}
			divisor++;
		}
		if (b == 0)
			if (c != 0)
				c = 1;
			else
				return null;
		FractionalNumber simp = new FractionalNumber(b,c);
		return simp;
	}
	public FractionalNumber add(FractionalNumber fn2)
	{
		FractionalNumber newNum = new FractionalNumber((fn2.numerator*denominator + fn2.denominator * numerator), (fn2.denominator * denominator));
		newNum = newNum.simplify();
		return newNum;
	}
	public FractionalNumber subtract(FractionalNumber fn2)
	{
		FractionalNumber newNum = new FractionalNumber((numerator*fn2.denominator - denominator * fn2.numerator), (fn2.denominator * denominator));
		newNum = newNum.simplify();
		return newNum;
	}
	public FractionalNumber multiply(FractionalNumber fn2)
	{
		FractionalNumber newNum = new FractionalNumber((fn2.numerator*numerator), (fn2.denominator * denominator));
		newNum = newNum.simplify();
		return newNum;
	}
	public FractionalNumber divide(FractionalNumber fn2)
	{
		if (fn2.numerator == 0)
			return null;
		else
		{
			FractionalNumber newNum = new FractionalNumber( (numerator * fn2.denominator), (fn2.numerator * denominator));
			newNum = newNum.simplify();
			return newNum;
		}
	}
}