public class Student implements Comparable<Student>
{
    private String ID;
    private int score;
    public Student (String ID, int S){
        this.ID=ID;
        this.score=S;
    }
    @Override
    public String toString(){
        return "ID:"+ID+" Score:"+score;
    }
    @Override
    public int compareTo(Student s){
        return score-s.score;
    }
    public boolean equals(Student s){
        return s.ID.equals(ID);
    }
}