
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * This program use the GregorianCalendar class to show a calendar. The current
 * day is marked with an asterisk (*).
 * 
 * @author CurtisNewbie <br>
 * 
 *         Date of Creation: 27th Feb 2019
 *
 */

public class SimpleCalendar {

	public static void main(String[] args) {

		// The JVM can be aware of the locale of the users, thus which changes which day
		// is the first of the week in different calendar.
		Locale.setDefault(Locale.UK);
		System.out.println("\n" + Locale.getDefault());

		// Construct a GregorianCalendar object with current date.
		GregorianCalendar td = new GregorianCalendar();

		// Capture the current day and month from this GregorianCalendar object
		int today = td.get(Calendar.DAY_OF_MONTH);
		int month = td.get(Calendar.MONTH);

		// Then we set td to the first of the month and get the weekday of that date.
		td.set(Calendar.DAY_OF_MONTH, 1);

		// In US, a calendar starts from Sunday; in Europe, it starts from Mon.
		int weekday = td.get(Calendar.DAY_OF_WEEK);

		/*
		 * weekday is the day of the week of the 1st day of the month. It helps the the
		 * program decide how much it needs to indent. By checking how many days are
		 * between it and the first day of the week. For example, if the 1st of Feb in
		 * 2019 is Fri And in US (locale), the first day of the week in calendar is Sun.
		 * The first line of the calendar should indent one space.
		 */
		int indent = 0;
		while (weekday != td.getFirstDayOfWeek()) {
			indent++;
			td.add(Calendar.DAY_OF_MONTH, -1); // current day of week plus -1 day.
			weekday = td.get(Calendar.DAY_OF_WEEK); // get the dayofweek.
		}

		// getting the date back to normal:
		td.add(Calendar.DAY_OF_MONTH, indent);

		// Print the header of the calendar: Sun Mon Tue ....
		String[] weekdayName = new DateFormatSymbols().getShortWeekdays();

		int d = td.getFirstDayOfWeek();
		System.out.print("First day of the week is: ");
		String answer;
		switch (d) {
		case Calendar.MONDAY:
			answer = "Mon";
			break;
		case Calendar.TUESDAY:
			answer = "Tue";
			break;
		case Calendar.WEDNESDAY:
			answer = "Wed";
			break;
		case Calendar.THURSDAY:
			answer = "Thu";
			break;
		case Calendar.FRIDAY:
			answer = "Fri";
			break;
		case Calendar.SATURDAY:
			answer = "Sat";
			break;
		case Calendar.SUNDAY:
			answer = "Sun";
			break;
		default:
			answer = "error";
			break;
		}
		System.out.print(answer + "\n\n");

		int len = weekdayName.length;
		int startingDay = d;
		// Print out the names of the day of week
		for (int x = d; x < len; x++) {
			if (x != len - 1)
				System.out.print(weekdayName[x] + " ");
			else
				System.out.print(weekdayName[x]);
		}
		for (int x = 0; x < startingDay; x++) {
			System.out.print(weekdayName[x] + " ");
		}
		System.out.println();

		// print the indent
		for (int x = 0; x < indent; x++) {
			System.out.print("    ");
		}

		// print the day:
		do {
			int day = td.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%3d", day);

			// if this day is today
			if (day == today) {
				System.out.print("*");
			} else {
				System.out.print(" ");
			}

			// next day
			td.add(Calendar.DAY_OF_MONTH, 1);
			if (td.get(Calendar.DAY_OF_WEEK) == td.getFirstDayOfWeek()) {
				System.out.println(); // newline
			}
		} while (td.get(Calendar.MONTH) == month);
		System.out.println();
	}
}
