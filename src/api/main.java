package api;

import javax.ws.rs.*;
import java.util.Calendar;

@Path("/")
public class main {

	private static String month;
	private static int day, year, hour, minute, second;

	@GET
	@Path("/main")
	@Produces("application/json")
	public String getTime() {
		String timeFormat = "{ \n \"Month\":\"%s\", \n \"Day\":\"%s\", \n \"Year\": \"%s\", \n \"Hour\":\"%s\", \n \"Minute\":\"%s\", \n \"Second\":\"%s\" \n}";
		return String.format(timeFormat, month, day, year, hour, minute, second);
	}
	
	//http://localhost:8080/api/main?
	
	@PUT
	@Path("/main")
	@Produces("application/json")
	public String updateTime(@QueryParam("Month")String month,@QueryParam("Day")int day,@QueryParam("Year")int year, @QueryParam("Hour")int hour, @QueryParam("Minute")int minute, @QueryParam("Second")int second) {
		main.month = month;
		main.day = day;
		main.year = year;
		main.hour = hour;
		main.minute = minute;
		main.second = second;
		String pattern = "{ \"Month\":\"%s\", \"Day\":\"%s\", \"Year\": \"%s\", \"Hour\":\"%s\", \"Minute\":\"%s\", \"Second\":\"%s\"}";
		return String.format(pattern, month, day, year, hour, minute, second);	
	}
	
	@POST @ Path("/main/month")@Produces("text/plain")
	public String getMonth() {
        String[] monthName = {"January", "February",
                "March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};
        Calendar cal = Calendar.getInstance();
        return monthName[cal.get(Calendar.MONTH)];
	}
	@POST @ Path("/main/day")@Produces("text/plain")
	public int getDay() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	@POST @ Path("/main/year")@Produces("text/plain")
	public int getYear() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}
	@GET @ Path("/main/hour")@Produces("text/plain")
	public int getHour() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.HOUR_OF_DAY);		
	}
	@GET @ Path("/main/minute")@Produces("text/plain")
	public int getMinute() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.MINUTE);
	}
	@GET @ Path("/main/second")@Produces("text/plain")
	public int getSecond() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.SECOND);
	}
}
