package is.ru.honn.ruber.domain;

import java.util.Date;

/**
 * Created by Gvendur Stefáns on 28.10.2014.
 */
public class TripDTO {
	private Date date;
	private double distance;
	private long time;
	private String driver;

	public TripDTO()
	{

	}

	public TripDTO(Trip trip, String driver)
	{
		this.date = new Date(trip.getRequestTime());
		this.distance = trip.getDistance();
		this.time = trip.getEndTime() - trip.getStartTime();
		this.driver = driver;
	}

	public Date getDate(){
		return date;
	}

	public void setDate(Date date){
		this.date = date;
	}

	public double getDistance()
	{
		return distance;
	}

	public void setDistance(double distance)
	{
		this.distance = distance;
	}

	public long getTime(){
		return time;
	}

	public void setTime(long time){
		this.time = time;
	}

	public String getDriver(){
		return this.driver;
	}

	public void setDriver(String driver){
		this.driver = driver;
	}



	public long getTimeHours(){
		return time / 3600;
	}

	public long getTimeMinutes(){
		return time / 60;
	}

	@Override
	public String toString()
	{
		return "TripDTO{" +
				"date=" + date +
				", distance=" + distance +
				", time=" + time +
				", driver=" + driver +
				'}';
	}
}
