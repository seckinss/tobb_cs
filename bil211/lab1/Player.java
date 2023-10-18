public class Player extends Staff {
    private int attackingSkill;
    private int defendingSkill;
    private int goalkeepingSkill;
    public int overallSkill(){
        return attackingSkill + defendingSkill + goalkeepingSkill;
    }
    public int getAttackingSkill() {
        return attackingSkill;
    }
    public int getDefendingSkill() {
        return defendingSkill;
    }
    public int getGoalkeepingSkill() {
        return goalkeepingSkill;
    }
    public void setAttackingSkill(int attackingSkill) {
        if(attackingSkill>5||attackingSkill<1){
            System.out.println("invalid skill value");
            this.attackingSkill=1;
        }
        else
            this.attackingSkill = attackingSkill;
    }
    public void setDefendingSkill(int defendingSkill) {
        if(defendingSkill>5||defendingSkill<1){
            System.out.println("invalid skill value");
            this.defendingSkill=1;
        }
        else
            this.defendingSkill = defendingSkill;
    }
    public void setGoalkeepingSkill(int goalkeepingSkill) {
        if(goalkeepingSkill>5||goalkeepingSkill<1){
            System.out.println("invalid skill value");
            this.goalkeepingSkill=1;
        }
        else
            this.goalkeepingSkill = goalkeepingSkill;
    }
}

