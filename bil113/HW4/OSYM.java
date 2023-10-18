public class OSYM
{
	public static final int EXAM_ALES=0;
	public static final int EXAM_YDS=1;
	public static final int EXAM_YKS=2;
	
	public static Result makeExam(Student student, int type)
	{
		Result result= OSYM.makeAles(student);
		if (type == 0)
			result = OSYM.makeAles(student);
		if (type == 1)
			result = OSYM.makeYDS(student);
		if (type == 2)
			result = OSYM.makeYKS(student);
		return result;
	}
	public static Result makeAles(Student student)
	{
		Result result =new Result((int)Math.ceil(student.getMathSkill()*(Math.random()/10+0.95)), (int)Math.ceil(student.getTurkishSkill()*(Math.random()/10+0.95)));
		return result;
	}
	public static Result makeYDS(Student student)
	{
		Result result =new Result((int)Math.ceil(student.getEnglishSkill()*(Math.random()/10+0.95)));
		return result;
	}
	public static Result makeYKS(Student student)
	{
		Result result =new Result((int)Math.ceil(student.getMathSkill()*(Math.random()/10+0.95)), (int)Math.ceil(student.getScienceSkill()*(Math.random()/10+0.95)), (int)Math.ceil(student.getTurkishSkill()*(Math.random()/10+0.95)), (int)Math.ceil(student.getSocialScienceSkill()*(Math.random()/10+0.95)));
		return result;
	}
}