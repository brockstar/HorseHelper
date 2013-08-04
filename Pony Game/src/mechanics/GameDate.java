package mechanics;

import java.util.Arrays;
import java.util.Observable;

public class GameDate extends Observable {

	public enum Month {
		JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;

		public int index() {
			int output = 0;
			output = Integer.valueOf(Arrays.asList(Month.values()).indexOf(this));
			return output;
		}

		public String print() {
			return toString().charAt(0) + toString().substring(1).toLowerCase();
		}

		public String abbreviation() {
			return toString().substring(0, 2);
		}
	}

	public enum Week {
		FIRST, SECOND, THIRD, FOURTH;

		public int index() {
			int output = 0;
			output = Integer.valueOf(Arrays.asList(Week.values()).indexOf(this));
			return output;
		}

		public String print() {
			return toString().charAt(0) + toString().substring(1).toLowerCase();
		}

		public String abbreviation() {
			switch (this) {
				case FIRST:
					return "1st";
				case SECOND:
					return "2nd";
				case THIRD:
					return "3rd";
				case FOURTH:
					return "4th";
				default:
					return "";
			}
		}
	}

	public enum Day {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

		public int index() {
			int output = 0;
			output = Integer.valueOf(Arrays.asList(Day.values()).indexOf(this));
			return output;
		}

		public String print() {
			return toString().charAt(0) + toString().substring(1).toLowerCase();
		}

		public String abbreviation() {
			return toString().substring(0, 2);
		}
	}

	public enum TimeOfDay {
		MORNING, NOON, AFTERNOON, EVENING;

		public int index() {
			int output = 0;
			output = Integer.valueOf(Arrays.asList(TimeOfDay.values()).indexOf(
					this));
			return output;
		}

		public String print() {
			return toString().charAt(0) + toString().substring(1).toLowerCase();
		}

		public String abbreviation() {
			switch (this) {
				case MORNING:
					return "A.M.";
				case NOON:
					return "NOON";
				case AFTERNOON:
					return "P.M.";
				case EVENING:
					return "NIGHT";
				default:
					return "";
			}
		}
	}

	public enum Season {
		SPRING, SUMMER, AUTUMN, WINTER;

		public String print() {
			return toString().charAt(0) + toString().substring(1).toLowerCase();
		}

		public String abbreviation() {
			return toString().substring(0, 2);
		}
	}

	int			year;
	Month			month;
	Week			week;
	Day			day;
	TimeOfDay	timeOfDay;

	Season		season;

	public GameDate(){
		this(1, Month.MARCH, Week.FIRST, Day.SUNDAY, TimeOfDay.NOON);
	}

	public GameDate( int aYear,Month aMonth,Week aWeek,Day aDay,
			TimeOfDay aTimeOfDay ){
		this.year = aYear;
		this.month = aMonth;
		setSeason();
		this.week = aWeek;
		this.day = aDay;
		this.timeOfDay = aTimeOfDay;
	}

	public void advanceTime() {
		nextTime();
		setChanged();
		notifyObservers();
	}

	public void nextTime() {
		int index = getTimeOfDay().index();
		index++;
		if (index >= TimeOfDay.values().length) {
			index = 0;
			nextDay();
		}
		setTimeOfDay(TimeOfDay.values()[index]);
	}

	public void nextDay() {
		int index = getDay().index();
		index++;
		if (index >= Day.values().length) {
			index = 0;
			nextWeek();
		}
		setDay(Day.values()[index]);
	}

	public void nextWeek() {
		int index = getWeek().index();
		index++;
		if (index >= Week.values().length) {
			index = 0;
			nextMonth();
		}
		setWeek(Week.values()[index]);
	}

	public void nextMonth() {
		int index = getMonth().index();
		index++;
		if (index >= Month.values().length) {
			index = 0;
			nextYear();
		}
		setMonth(Month.values()[index]);
	}

	public void nextYear() {
		year++;
	}

	public int getYear() {
		return Integer.valueOf(year);
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
		setSeason();
	}

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public TimeOfDay getTimeOfDay() {
		return timeOfDay;
	}

	public void setTimeOfDay(TimeOfDay timeOfDay) {
		this.timeOfDay = timeOfDay;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason() {
		// march, april, may: Spring
		// june, july, august: Summer
		// september, october, november: autumn
		// december, january, february
		int index = getMonth().index();
		season = Season.SPRING;
		switch (index) {
			case 3:
			case 4:
			case 5:
				season = Season.SPRING;
				break;
			case 6:
			case 7:
			case 8:
				season = Season.SUMMER;
				break;
			case 9:
			case 10:
			case 11:
				season = Season.AUTUMN;
				break;
			case 12:
			case 1:
			case 2:
				season = Season.WINTER;
				break;
			default:
				season = Season.SPRING;
		}

	}

}
