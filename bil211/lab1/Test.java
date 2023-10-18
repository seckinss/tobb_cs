public class Test {

    public static void main(String[] args) {
    
    	
	try {
		Player attacker = createPlayers("Attacker", "player1", 1, 1, -6, 1);
		Player defender = createPlayers("Defender", "player1", 1, -6, 1, 1);
		Player goalkeeper = createPlayers("Goalkeeper", "player1", 1, 2, -5, 2);
		Coach coach = new Coach();
		coach.setName("coach");
		coach.setCoachingSkill(2);

		Team team = new Team(3);
		team.setCoach(coach);
		team.addPlayer(attacker);
		team.addPlayer(defender);
		team.addPlayer(goalkeeper);
		team.addPlayer(attacker);

		System.out.println(team.teamSkill());
	}
	catch(Exception e) {
		System.out.println("running time error");
	}
	
	System.out.println("--*--");
        //---------------------------------------------------------------------------------------------------
        try {
		Player attacker = createPlayers("Goalkeeper", "player1", 0, 3, 2, 1);
		Player defender = createPlayers("Defender", "player1", 6, 1, 2, 2);
		Player goalkeeper = createPlayers("Goalkeeper", "player1", 1, 2, 4, 4);
		Coach coach = new Coach();
		coach.setName("coach");
		coach.setCoachingSkill(5);

		Team team = new Team(2);
		team.setCoach(coach);
		team.addPlayer(attacker);
		team.addPlayer(defender);
		team.addPlayer(goalkeeper);
		team.addPlayer(attacker);

		System.out.println(team.teamSkill());
	}
	catch(Exception e) {
		System.out.println("running time error");
	}
        
        System.out.println("--*--");
        //---------------------------------------------------------------------------------------------------
        try {
		Player attacker = createPlayers("Goalkeeper", "player1", 0, 3, 2, 1);
		Player defender = createPlayers("Goalkeeper", "player1", 6, 1, 2, 2);
		Player goalkeeper = createPlayers("Goalkeeper", "player1", 1, 2, 4, 4);
		Coach coach = new Coach();
		coach.setName("coach");
		coach.setCoachingSkill(5);

		Team team = new Team(4);
		team.setCoach(coach);
		team.addPlayer(attacker);
		team.addPlayer(defender);
		team.addPlayer(goalkeeper);
		team.addPlayer(attacker);

		System.out.println(team.teamSkill());
	}
	catch(Exception e) {
		System.out.println("running time error");
	}
        
        System.out.println("--*--");
        //---------------------------------------------------------------------------------------------------
        try {
		Player attacker = createPlayers("Goalkeeper", "player1", 0, 3, 2, 1);
		Player defender = createPlayers("Goalkeeper", "player1", 6, 1, 2, 2);
		Player goalkeeper = createPlayers("Goalkeeper", "player1", 1, 2, 4, 4);
		Coach coach = new Coach();
		coach.setName("coach");
		coach.setCoachingSkill(0);

		Team team = new Team(1);
		team.setCoach(coach);
		team.addPlayer(attacker);
		team.addPlayer(defender);
		team.addPlayer(goalkeeper);
		team.addPlayer(attacker);

		System.out.println(team.teamSkill());
	}
	catch(Exception e) {
		System.out.println("running time error");
	}
        
    }


    public static Player createPlayers(String position, String name, int attackingSkill, int defendingSkill, int goalkeepingSkill, int positionSkill){
        Player player;
        if (position.equals("Attacker")) {
            player = new Attacker();
            player = (Attacker) player;
            ((Attacker) player).setShootingSkill(positionSkill);
        }
        else if (position.equals("Defender")) {
            player = new Defender();

            player = (Defender) player;
            ((Defender) player).setStrengthSkill(positionSkill);
        }
        else {
            player = new Goalkeeper();

            player = (Goalkeeper) player;
            ((Goalkeeper) player).setReflexSkill(positionSkill);
        }

        player.setName(name);
        player.setAttackingSkill(attackingSkill);
        player.setDefendingSkill(defendingSkill);
        player.setGoalkeepingSkill(goalkeepingSkill);

        return player;


    }
}


