public class Team {
    private Coach coach;
    private Player[] squad;
    public Team(int squadCapacity) {
        this.squad = new Player[squadCapacity];
    }
    public void addPlayer(Player player){
        int i=0;
        for (int index = 0; index < squad.length; index++) {
            if(squad[index]==null){
                i=index;
                break;
            }
            else{
                i=index;
                i++;
            }
        }
        if(i==squad.length)
            System.out.println("squad is full");
        else
            squad[i]=player;
    }
    public int teamSkill(){
        int total =0;
        for (int i = 0; i < squad.length; i++) {
            total+= squad[i].overallSkill();
        }
        total = total * coach.getCoachingSkill();
        return total;
    }
    public Coach getCoach() {
        return coach;
    }
    public void setCoach(Coach coach) {
        this.coach = coach;
    }
    public Player[] getSquad() {
        return squad;
    }
    public void setSquad(Player[] squad) {
        for (int i = 0; i < squad.length; i++) {
            this.squad[i]=squad[i];
        }
    }
}
