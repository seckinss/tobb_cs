public class Student
{
    private String name;
    private String surname;
    private int age,mathSkill,scienceSkill,turkishSkill,englishSkill,socialScienceSkill;
    private String schoolName ;
    private double gpa;
	private static boolean uniStudent;
	private Result examResult;
	private boolean applicationStatus;
    public Student(String name,String surname, int age, int mathSkill, int scienceSkill, int turkishSkill, int socialScienceSkill, String schoolName, double gpa)
    {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.mathSkill = mathSkill;
        this.scienceSkill = scienceSkill;
        this.turkishSkill = turkishSkill;
        this.socialScienceSkill = socialScienceSkill;
        this.schoolName = schoolName;
        this.gpa = gpa;
		uniStudent = false;
    }
    public Student(String name, String surname, int age, int mathSkill,  int turkishSkill, int englishSkill, String schoolName, double gpa)
    {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.mathSkill = mathSkill;
        this.turkishSkill = turkishSkill;
        this.englishSkill = englishSkill;
        this.schoolName = schoolName;
        this.gpa = gpa;
		uniStudent = true;
    }
    public boolean enterExam(int examType) 
    {
		if (uniStudent)
		{
			Student student = new Student(name, surname, age, mathSkill,  turkishSkill, englishSkill, schoolName, gpa);
			Result examResult = OSYM.makeExam(student,examType);
			this.examResult = examResult;
			return true;
		}
		if(!uniStudent)
		{
			Student student = new Student(name, surname, age, mathSkill, scienceSkill, turkishSkill, socialScienceSkill, schoolName, gpa);
			Result examResult = OSYM.makeExam(student,examType);
			this.examResult = examResult;
			return true;
		}
		return true;
    }
	public void applyToSchool(School school, int program)
	{
		if (program == School.UNDERGRADUATE_COMPUTER_ENGINEERING)
			program = school.getComputerEngineeringScore();
		if (program == School.UNDERGRADUATE_ELECTRONIC_ENGINEERING)
			program = school.getElectronicEngineeringScore();
		if (program == School.UNDERGRADUATE_INDUSTRIAL_ENGINEERING)
			program = school.getIndustrialEngineeringScore();
		if (program == School.UNDERGRADUATE_MECHANICAL_ENGINEERING)
			program = school.getMechanicalEngineeringScore();
		if (uniStudent)
		{
			if (program==-1)
			{
				Student student = new Student(name, surname, age, mathSkill,  turkishSkill, englishSkill, schoolName, gpa);
				applicationStatus = school.evaluateApplication(student,program);
			}
			else
			{
				System.out.println("You cannot apply to undergraduate programs.");
				applicationStatus = false;
			}
		}
		if(!uniStudent)
		{
			if (program==-1)
			{
				System.out.println("You cannot apply to graduate programs.");
				applicationStatus = false;
			}
			else
			{
				Student student = new Student(name, surname, age, mathSkill, scienceSkill, turkishSkill, socialScienceSkill, schoolName, gpa);
				
				applicationStatus = school.evaluateApplication(student,program);
				if(!applicationStatus)
					System.out.println("Your YKS score must be higher!..");
			}
		}
		
	}
	public boolean getApplicationStatus()
	{
		return applicationStatus;
	}
	public String toString()
	{
		String a = "name="+name+", surname:"+surname+", age="+ age + ", schoolName=" +schoolName;
		return a;
	}
	public String getAlesResult() 
	{
		String a="";
		if (uniStudent)
		{	
			int math = Result.getMathScore();  
			int turk = Result.getTurkishScore();
			a = "Math Score: " + math + " \tTurkish Score: " + turk;
		}
		else
			a ="You are not allowed to enter this exam !..";
		return a;
	}
	public String getYdsResult()
	{
		String a="";
		if (uniStudent)
		{	
			int eng = Result.getEnglishScore();  
			a = "English Score: " + eng;
		}
		else
			a ="You are not allowed to enter this exam !..";
		return a;
	}
	public String getYksResult()
	{
		String a="";
		if (uniStudent)
			a = "You are not allowed to enter this exam !..";
		else
		{
			int math = Result.getMathScore();  
			int turk = Result.getTurkishScore();
			int science = Result.getScienceScore();
			int socialScience = Result.getSocialScienceScore();
			a = "Math Score: " + math + "\nScience Score: "+ science +"\nTurkish Score: " + turk +"\nSocialScience Score: " +socialScience;
		}
		return a;
	}
	public int getMathSkill()
	{
		return mathSkill;
	}
	public int getTurkishSkill()
	{
		return turkishSkill;
	}
	public int getEnglishSkill()
	{
		return englishSkill;
	}
	public int getScienceSkill()
	{
		return scienceSkill;
	}
	public int getSocialScienceSkill()
	{
		return socialScienceSkill;
	}
	public double getGPA()
	{
		return gpa;
	}
	public static boolean getUniStatus()
	{
		return uniStudent;
	}
}
