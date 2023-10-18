public class Result
{
	int type;
	private static int  mathScore, scienceScore, turkishScore, socialScienceScore, englishScore;
	public Result(int mathScore, int turkishScore)
	{
		this.mathScore = mathScore;
		this.turkishScore = turkishScore;
		type = 0;
		if (mathScore>100)
			this.mathScore = 100;
		if (turkishScore>100)
			this.turkishScore = 100;
	}
	public Result(int englishScore)
	{
		this.englishScore = englishScore;
		type = 1;
		if (englishScore>100)
			this.englishScore = 100;
	}
	public Result(int mathScore, int scienceScore, int turkishScore, int socialScienceScore)
	{
		this.mathScore = mathScore;
		this.scienceScore = scienceScore;
		this.turkishScore = turkishScore;
		this.socialScienceScore = socialScienceScore;
		type = 2;
		if (mathScore>100)
			this.mathScore = 100;
		if (scienceScore>100)
			this.scienceScore = 100;
		if (turkishScore>100)
			this.turkishScore = 100;
		if (socialScienceScore>100)
			this.socialScienceScore = 100;
	}
	public static int getMathScore()
	{
		return mathScore;
	}
	public static int getTurkishScore()
	{
		return turkishScore;
	}
	public static int getScienceScore()
	{
		return scienceScore;
	}
	public static int getSocialScienceScore()
	{
		return socialScienceScore;
	}
	public static int getEnglishScore()
	{
		return englishScore;
	}
}