public class Trip
{
	private String origin;
	private String destination;
	private String departureTime;
	private String arrivalTime;
	private String date;
	private Bus assignedBus;
	public Trip(String origin, String destination, String departureTime, String arrivalTime, String date, Bus assignedBus)
	{
		this.origin=origin;
		this.destination=destination;
		this.departureTime=departureTime;
		this.arrivalTime=arrivalTime;
		this.date=date;
		this.assignedBus=assignedBus;
	}
	public String toString()
	{
		String str ="Trip Information:\n\tDate: " + date +"\n\tFrom: " + origin + " to " + destination +"\n\tTrip Time: ";
		str = str + departureTime + " to  " + arrivalTime + "\n\t" + assignedBus.toString();
		return str;
	}
	public Bus getBus()
	{
		return assignedBus;
	}
}