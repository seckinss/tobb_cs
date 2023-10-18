public class Attacker extends Player {
    private int shootingSkill;
    public int overallSkill(){
        return getAttackingSkill() + getDefendingSkill() + getGoalkeepingSkill() + getShootingSkill();
    }
    public int getShootingSkill() {
        return shootingSkill;
    }
    public void setShootingSkill(int shootingSkill) {
        if(shootingSkill>5||shootingSkill<1){
            System.out.println("invalid skill value");
            this.shootingSkill=1;
        }
        else
            this.shootingSkill = shootingSkill;
    }
}
