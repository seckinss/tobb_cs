public class School
{
	String universityName, location;
	private int minimumUndergraduateComputerEngineeringScore, minimumUndergraduateElectronicEngineeringScore, minimumUndergraduateIndustrialEngineeringScore, minimumUndergraduateMechanicalEngineeringScore;
	public static final int UNDERGRADUATE_COMPUTER_ENGINEERING = -2, UNDERGRADUATE_ELECTRONIC_ENGINEERING = -3, UNDERGRADUATE_MECHANICAL_ENGINEERING = -4, UNDERGRADUATE_INDUSTRIAL_ENGINEERING = -5;
	public static final int GRADUATE_COMPUTER_ENGINEERING = -1;
	public School(String universityName, String location, int minimumUndergraduateComputerEngineeringScore, int minimumUndergraduateElectronicEngineeringScore, int minimumUndergraduateMechanicalEngineeringScore, int minimumUndergraduateIndustrialEngineeringScore)
	{
		this.universityName = universityName;
		this.location = location;
		this.minimumUndergraduateComputerEngineeringScore = minimumUndergraduateComputerEngineeringScore;
		this.minimumUndergraduateElectronicEngineeringScore = minimumUndergraduateElectronicEngineeringScore;
		this.minimumUndergraduateIndustrialEngineeringScore = minimumUndergraduateIndustrialEngineeringScore;
		this.minimumUndergraduateMechanicalEngineeringScore = minimumUndergraduateMechanicalEngineeringScore;
	}
	
	public boolean evaluateApplication(Student student, int program)
	{
		double examScore = 0.35*Result.getMathScore()+0.25*Result.getScienceScore()+0.25*Result.getTurkishScore()+0.15*Result.getSocialScienceScore();
		double finalScore = 0.8*examScore+0.2*student.getGPA();
		double QuantitativeScore = 0.75*Result.getMathScore() + 0.25* Result.getTurkishScore();
		if (student.getUniStatus())
		{
			if (QuantitativeScore >=85 && Result.getEnglishScore()>=75 && student.getGPA()>= 2.5)
				return true;
			return false;
		}
		if(!student.getUniStatus())
		{
			if (finalScore >=program)
				return true;
			return false;
		}
		return true;
	}
	public String toString()
	{
		String a = "name=" + universityName+ ", location=" + location;
		return a;
	}
	public int getComputerEngineeringScore()
	{
		return minimumUndergraduateComputerEngineeringScore;
	}
	public int getElectronicEngineeringScore()
	{
		return minimumUndergraduateElectronicEngineeringScore;
	}
	public int getIndustrialEngineeringScore()
	{
		return minimumUndergraduateIndustrialEngineeringScore;
	}
	public int getMechanicalEngineeringScore()
	{
		return minimumUndergraduateMechanicalEngineeringScore;
	}
	
}