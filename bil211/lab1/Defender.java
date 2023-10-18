public class Defender extends Player {
    private int strengthSkill;
    public int overallSkill(){
        return getAttackingSkill() + getDefendingSkill() + getGoalkeepingSkill() + getStrengthSkill();
    }
    public int getStrengthSkill() {
        return strengthSkill;
    }
    public void setStrengthSkill(int strengthSkill) {
        if(strengthSkill>5||strengthSkill<1){
            System.out.println("invalid skill value");
            this.strengthSkill=1;
        }
        else
            this.strengthSkill = strengthSkill;
    }
}
