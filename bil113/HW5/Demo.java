import java.util.Scanner;
public class Demo
{
	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		Bus bus1 = new Bus("2+2", "Setra", 8, 40);
		Bus bus2 = new Bus("2+1", "Setra", 5, 36);
		Bus bus3 = new Bus("2+1", "Neoplan", 2, 48);
		Bus bus4 = new Bus("2+2", "Travego", 15, 36);
		Bus bus5 = new Bus("2+1", "Setra", 8, 36);
		Trip trip1 = new Trip("Ankara", "Istanbul", "00:15", "06:30", "27/11/2022", bus1);
		Trip trip2 = new Trip("Ankara", "Mersin", "13:00", "20:00", "27/11/2022", bus2);
		Trip trip3 = new Trip("Istanbul", "Ankara", "07:00", "13:30", "27/11/2022", bus3);
		Trip trip4 = new Trip("Mersin", "Ankara", "17:00", "00:00", "27/11/2022", bus4);
		Trip trip5 = new Trip("Istanbul", "Mersin", "00:15", "12:30", "27/11/2022", bus5);
		trip1.getBus().fillSeatsRandomly(17);
		trip2.getBus().fillSeatsRandomly(25);
		trip3.getBus().fillSeatsRandomly(10);
		trip4.getBus().fillSeatsRandomly(22);
		trip5.getBus().fillSeatsRandomly(28);
		int k = 0;
		Trip chosentrip;
		String looper = "1";
		while(!(looper.equals("0")))
		{
			System.out.print("Do you want to buy (press \"1\" for this) or cancel(press \"2\" for this) a ticket? ");
			int choice = console.nextInt();
			System.out.println("Available trips are shown below.");
			System.out.println("1)" + trip1 + "\n2)" + trip2 + "\n3)" + trip3 +"\n4)"+ trip4 +"\n5)" + trip5 );
			System.out.print("\nPlease choose trip: ");
			int tripChoice = console.nextInt();
			k=0;
			switch(tripChoice){
				case 1:
					chosentrip = trip1;
					break;
				case 2:
					chosentrip = trip2;
					break;
				case 3:
					chosentrip = trip3;
					break;
				case 4:
					chosentrip = trip4;
					break;
				case 5:
					chosentrip = trip5;
					break;
				default:
					System.out.println("There is no trip you choose");
					chosentrip = trip1;
					k = 1;
					break;
			}
			if (k==1)
				break;
			chosentrip.getBus().printSeats();
				if (choice==1)
				{
					System.out.print("\nPlease enter the seat number of the seat you want to buy: ");
					String seat = console.next();
					if( chosentrip.getBus().fillSeat(seat))
					{
						System.out.print("\nCongratulations, your seat number is: " + seat);
					}
					else
						System.out.print("\nYou can't select this seat. (Already taken or does not exist..) ");
				}	
				if (choice==2)
				{
					System.out.print("\nPlease enter the seat number of the seat you want to cancel: ");
					String seat = console.next();
					if(!(chosentrip.getBus().isSeatEmpty(seat)))
					{
						System.out.print("\nPlease provide PNR code to cancel : ");
						String pnrCode = console.next();
						if (chosentrip.getBus().checkPNR(seat).equals(pnrCode))
						{
							if(chosentrip.getBus().emptySeat(seat))
								System.out.print("\nYour Cancellation has been successful.");
								
							else
								System.out.print("\nYou can't select this seat. (Empty or does not exist..) ");
						}
						else
							System.out.print("\nThis PNR code is wrong, Please check again. ");
					}
					else
						System.out.print("\nYou can't select this seat. (Empty or does not exist..) ");
				}
				chosentrip.getBus().printSeats();
			System.out.print("\nEnter any key expect 0 to continue: ");
			looper = console.next();
		}
		console.close();
	}
}