package programming.injava.array;

import java.util.List;

/**
 * Given current day as day of the week and an integer K, the task is to find the day of the week after K days.
 * 
 * day = “Monday”, k = 3
 * Output: Thursday
 * 
 * **/
public class DaysOfTheWeek {

	public static void main(String[] args) {
		System.out.println("Kth Days: " + findDay("Monday", 3));
		System.out.println("Kth Days: " + findDay("Tuesday", 101));
		
	}
	
	public static String findDay(String currDay, int k) {
		List<String> weekDays = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
		return weekDays.get((weekDays.indexOf(currDay) + k) % 7);
	}

}
