public class Goalkeeper extends Player {
    private int reflexSkill;
    public int overallSkill(){
        return getAttackingSkill() + getDefendingSkill() + getGoalkeepingSkill() + getReflexSkill();
    }
    public int getReflexSkill() {
        return reflexSkill;
    }
    public void setReflexSkill(int reflexSkill) {
        if(reflexSkill>5||reflexSkill<1){
            System.out.println("invalid skill value");
            this.reflexSkill=1;
        }
        else
            this.reflexSkill = reflexSkill;
    }
}
