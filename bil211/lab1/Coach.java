public class Coach extends Staff {
    private int coachingSkill;
    public int getCoachingSkill() {
        return coachingSkill;
    }
    public void setCoachingSkill(int coachingSkill) {
        if(coachingSkill>5||coachingSkill<1){
            System.out.println("invalid skill value");
            this.coachingSkill=1;
        }
        else
            this.coachingSkill = coachingSkill;
    }
}
