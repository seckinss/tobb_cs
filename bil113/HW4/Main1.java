public class Main1 {
    public static void main(String[] args) {
        String name = "Utku Umur";
        String surname = "ACIKALIN";
        int age = 23;
        int mathSkill = 95;
        int turkishSkill = 90;
        int englishSkill = 95;
        String schoolName = "TOBB ETU";
        double gpa = 3.74;

        Student utku = new Student(name, surname, age, mathSkill, turkishSkill, englishSkill,
                schoolName,  gpa);


        String universityName = "TOBB ETU";
        String location = "Ankara";


        int minimumUndergraduateComputerEngineeringScore = 80;
        int minimumUndergraduateElectronicEngineeringScore = 78;
        int minimumUndergraduateMechanicalEngineeringScore = 75;
        int minimumUndergraduateIndustrialEngineeringScore = 75;



        School tobb = new School(universityName, location, minimumUndergraduateComputerEngineeringScore, minimumUndergraduateElectronicEngineeringScore,
                minimumUndergraduateMechanicalEngineeringScore,minimumUndergraduateIndustrialEngineeringScore);

        School bilkent = new School("Bilkent", "Ankara", 90, 93,
                75, 78);

        System.out.println(utku.toString());

        System.out.println(tobb.toString());
        System.out.println(bilkent.toString());

        if (utku.enterExam(OSYM.EXAM_ALES))
            System.out.println(utku.getAlesResult().toString());

        if (utku.enterExam(OSYM.EXAM_YDS))
            System.out.println(utku.getYdsResult().toString());

        if (utku.enterExam(OSYM.EXAM_YKS))
            System.out.println(utku.getYksResult().toString());

        utku.applyToSchool(tobb, School.UNDERGRADUATE_COMPUTER_ENGINEERING);
        if (utku.getApplicationStatus())
            System.out.println("Accepted!..");
        else
            System.out.println("Rejected!..");


        utku.applyToSchool(tobb, School.GRADUATE_COMPUTER_ENGINEERING);
        if (utku.getApplicationStatus())
            System.out.println("Accepted!..");
        else
            System.out.println("Rejected!..");
    }
}
