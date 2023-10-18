public class Bus
{
	private String type;
	private String model;
	private int age;
	private int capacity;
	private int remainingCapacity;
	private int columns;
	private int rows;
	private String[][] pnrCodes;
	private boolean[][] seats;
	public Bus(String type, String model, int age, int capacity)
	{
		this.type=type;
		this.model=model;
		this.age=age;
		this.capacity=capacity;
		remainingCapacity = capacity;
		columns = -96 + type.charAt(0) + type.charAt(2);
		rows = capacity/columns;
		seats = new boolean[rows][columns];
		pnrCodes = new String[rows][columns];
		for(int i=0;rows>i;i++)
		{
			for(int j=0;columns>j;j++)
			{
				seats[i][j] = false; // all empty 
			}
		}
	}
	public String createPNR(int rowValue, int columnValue)
	{
		String pnrCode = "" + (char)(int)(5.0/3*rowValue+65) + (char)(int)(25.0/3*columnValue+65);
		for(int i=4;i>0;i--)
		{
			pnrCode = pnrCode + (char)(int)(Math.random()*26+65);
		}
		return pnrCode;
	}
	public String checkPNR(String seat)
	{
		seat = "" + seat;
		if(seat.length()==2)
			return pnrCodes[seat.charAt(0) - 49][seat.charAt(1) - 65];
		if(seat.length()==3)
			return pnrCodes[seat.charAt(0) + seat.charAt(1) - 88][seat.charAt(2) - 65];
		return "Seat does not exist";
	}
	public int numberOfEmptySeats()
	{
		return remainingCapacity;
	}
	public boolean doesSeatExist(String seat)
	{
		if(seat.length()==2)
			return (rows>=seat.charAt(0) - 48 && columns>=seat.charAt(1) - 64);
		if(seat.length()==3)
			return (rows>=seat.charAt(0) + seat.charAt(1) - 87 && columns>=seat.charAt(2) - 64);
		return false;
	}
	public boolean isSeatEmpty(String seat)
	{
		if (doesSeatExist(seat))
		{	
			if (seat.length()==2)
				return !(seats[seat.charAt(0) - 49][seat.charAt(1) - 65]);
			else
				return !(seats[seat.charAt(0) + seat.charAt(1) - 88][seat.charAt(2) - 65]);
		}
		return false;
	}
	public boolean fillSeat(String seat)
	{
		if (isSeatEmpty(seat))
		{
			if (seat.length()==2)
			{
				if (!(seats[seat.charAt(0) - 49][seat.charAt(1) - 65]))
				{
					seats[seat.charAt(0) - 49][seat.charAt(1) - 65] = true;
					remainingCapacity--;
					pnrCodes[seat.charAt(0) - 49][seat.charAt(1) - 65] = createPNR(seat.charAt(0) - 49, seat.charAt(1) - 65);
					System.out.println("Your PNR code for " + seat + " seat is: " + pnrCodes[seat.charAt(0) - 49][seat.charAt(1) - 65]);
				}
				return (seats[seat.charAt(0) - 49][seat.charAt(1) - 65]);
			}
			else 
			{
				if (!(seats[seat.charAt(0) + seat.charAt(1) - 88][seat.charAt(2) - 65]))
				{
					seats[seat.charAt(0) + seat.charAt(1) - 88][seat.charAt(2) - 65] = true;
					remainingCapacity--;
					pnrCodes[seat.charAt(0) + seat.charAt(1) - 88][seat.charAt(2) - 65] = createPNR(seat.charAt(0) + seat.charAt(1) - 88, seat.charAt(2) - 65);
					System.out.println("Your PNR code for " + seat + " seat is: " + pnrCodes[seat.charAt(0) + seat.charAt(1) - 88][seat.charAt(2) - 65]);
				}
				return (seats[seat.charAt(0) + seat.charAt(1) - 88][seat.charAt(2) - 65]);
			} 
		}
		return false;
	}
	public boolean emptySeat(String seat)
	{
		if (!isSeatEmpty(seat))
		{
			if (seat.length()==2)
			{
				if (seats[seat.charAt(0) - 49][seat.charAt(1) - 65])
				{
					seats[seat.charAt(0) - 49][seat.charAt(1) - 65] = false;
					remainingCapacity++;
					pnrCodes[seat.charAt(0) - 49][seat.charAt(1) - 65] = "";
					return !(seats[seat.charAt(0) - 49][seat.charAt(1) - 65]);
				}
				return false;
			}
			else
			{
				if (seats[seat.charAt(0) + seat.charAt(1) - 88][seat.charAt(2) - 65])
				{
					seats[seat.charAt(0) + seat.charAt(1) - 88][seat.charAt(2) - 65] = false;
					remainingCapacity++;
					pnrCodes[seat.charAt(0) + seat.charAt(1) - 88][seat.charAt(2) - 65] = "";
					return !(seats[seat.charAt(0) + seat.charAt(1) - 88][seat.charAt(2) - 65]);
				}
			}
		}
		return false;
	}
	public void printSeats()
	{
		String str = "\n\n";
		if (type.charAt(2)=='1')
		{
			str = str + " \tAB\tC\n";
			for(int i=0;rows>i;i++)
			{
				if (i==5 || i == 10 || i == 15)
					str = str + "\n";
				str =str + "\n" + (i+1) + "\t";
				for(int j=0;columns>j;j++)
				{
					if(j==2)
						str = str +"\t";
					if(seats[i][j])
						str = str + "T";
					if(!seats[i][j])
						str = str + ".";
				}
			}
		}
		if (type.charAt(2)=='2')
		{
			str = str + " \tAB\tCD\n";
			for(int i=0;rows>i;i++)
			{
				if (i==5 || i == 10 || i == 15)
					str = str + "\n";
				str =str + "\n" + (i+1) + "\t";
				for(int j=0;columns>j;j++)
				{
					if(j==2)
						str = str +"\t"; 
					if(seats[i][j])
						str = str + "T";
					if(!seats[i][j])
						str = str + ".";
				}
			}
		}
		System.out.println(str);
	}
	public void fillSeatsRandomly(int fillNum)
	{
		int rowRandom, columnRandom;
		remainingCapacity = remainingCapacity - fillNum;
		if (remainingCapacity<0)
		{
			for(int i=0;rows>i;i++)
			{
				for(int j=0;columns>j;j++)
				{
					seats[i][j] = true;
					pnrCodes[i][j] = createPNR(i,j);
				}
			}
			remainingCapacity = 0;
			return;
		}
		while (fillNum>0)
		{
			rowRandom = (int)(Math.random()* rows);
			columnRandom = (int)(Math.random()* columns);
			if (!(seats[rowRandom][columnRandom]))
			{
				seats[rowRandom][columnRandom] = true;
				pnrCodes[rowRandom][columnRandom] = createPNR(rowRandom, columnRandom);
				fillNum--;
			}
		}
		return;
	}
	public String toString()
	{
		String output;
		output = "Bus Information:\n\t\tBus: " + model + "\n\t\tType: " + type + "\n\t\tAge: " + age;
		output = output + "\n\t\tCapacity: " + capacity + " seats\n\t\tRemainingCapacity: " + remainingCapacity;
		return output;
	}
	// private int calculateSeatNumber(String input)
	// {
	//  	int seatNum = (input.charAt(0)-48)*columns+(input.charAt(1)-40);
	// 	return seatNum;
	// }
}


