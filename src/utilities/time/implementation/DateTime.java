/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.time.implementation;

import java.util.Date;

/**
 *
 * @author tobias
 */
public class DateTime implements Comparable<DateTime> {
	
	private static final long MAX_VALUE_TICKS = 3155378975999999999L;
	
	public static final DateTime MIN_VALUE = new DateTime (false, new TimeSpan (0));
	public static final DateTime MAX_VALUE = new DateTime (false, new TimeSpan (MAX_VALUE_TICKS));
		
	private static final int[] daysPerMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };	
	private static final int[] daysPerMonthLeapYear = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };	
		
	private TimeSpan ticks;
	
	private static final String[] PARSE_TIME_FORMATS = new String[] {
		"H:m:s.fff zzz",
		"H:m:s.fffffffzzz",
		"H:m:s.fffffff",
		"H:m:s.ffffff",
		"H:m:s.fffff",
		"H:m:s.ffff",
		"H:m:s.fff",
		"H:m:s.ff",
		"H:m:s.f",
		"H:m:s tt zzz",
		"H:m:szzz",
		"H:m:s",
		"H:mzzz",
		"H:m",
		"H tt", // Specifies AM to disallow '8'.
		"H'\u6642'm'\u5206's'\u79D2'",
	};

	// DateTime.Parse date patterns extend ParseExact patterns as follows:
	//   MMM - month short name or month full name
	//   MMMM - month number or short name or month full name

	// Parse behaves differently according to the ShorDatePattern of the
	// DateTimeFormatInfo. The following define the date patterns for
	// different orders of day, month and year in ShorDatePattern.
	// Note that the year cannot go between the day and the month.
	private static final String[] PARSE_YEAR_DAY_MONTH_FORMATS = new String[] {
		"yyyy/M/dT",
		"M/yyyy/dT",
		"yyyy'\u5E74'M'\u6708'd'\u65E5",


		"yyyy/d/MMMM",
		"yyyy/MMM/d",
		"d/MMMM/yyyy",
		"MMM/d/yyyy",
		"d/yyyy/MMMM",
		"MMM/yyyy/d",

		"yy/d/M",
	};

	private static final String[] PARSE_YEAR_MONTH_DAY_FORMATS = new String[] {
		"yyyy/M/dT",
		"M/yyyy/dT",
		"yyyy'\u5E74'M'\u6708'd'\u65E5",

		"yyyy/MMMM/d",
		"yyyy/d/MMM",
		"MMMM/d/yyyy",
		"d/MMM/yyyy",
		"MMMM/yyyy/d",
		"d/yyyy/MMM",

		"yy/MMMM/d",
		"yy/d/MMM",
		"MMM/yy/d",
	};

	private static final String[] PARSE_DAY_MONTH_YEAR_FORMATS = new String[] {
		"yyyy/M/dT",
		"M/yyyy/dT",
		"yyyy'\u5E74'M'\u6708'd'\u65E5",

		"yyyy/MMMM/d",
		"yyyy/d/MMM",
		"d/MMMM/yyyy",
		"MMM/d/yyyy",
		"MMMM/yyyy/d",
		"d/yyyy/MMM",

		"d/MMMM/yy",
		"yy/MMM/d",
		"d/yy/MMM",
		"yy/d/MMM",
		"MMM/d/yy",
		"MMM/yy/d",
	};

	private static final String[] PARSE_MONTH_DAY_YEAR_FORMATS = new String[] {
		"yyyy/M/dT",
		"M/yyyy/dT",
		"yyyy'\u5E74'M'\u6708'd'\u65E5",

		"yyyy/MMMM/d",
		"yyyy/d/MMM",
		"MMMM/d/yyyy",
		"d/MMM/yyyy",
		"MMMM/yyyy/d",
		"d/yyyy/MMM",

		"MMMM/d/yy",
		"MMM/yy/d",
		"d/MMM/yy",
		"yy/MMM/d",
		"d/yy/MMM",
		"yy/d/MMM",
	};

	private static final String[] PARSE_GENERIC_YEAR_MONTH_DAY_FORMATS = new String[] {
		"yyyy/M/dT",
		"yyyy/M/d",
		"M/yyyy/dT",
		"M/yyyy/d",
		"yyyy'\u5E74'M'\u6708'd'\u65E5",
		"yyyy'-'M'-'dT",
		"yyyy'-'M'-'d",
	};

	// Patterns influenced by the MonthDayPattern in DateTimeFormatInfo.
	// Note that these patterns cannot be followed by the time.
	private static final String[] MONTH_DAY_SHORT_FORMATS = new String[] {
		"MMMM/d",
		"d/MMM",
		"yyyy/MMMM",
	};

	private static final String[] DAY_MONTH_SHORT_FORMATS = new String[] {
		"d/MMMM",
		"MMM/yy",
		"yyyy/MMMM",
	};
	
	public DateTime(long ticks) {
		this.ticks = new TimeSpan(ticks);
	}
	
	public DateTime(int year, int month, int day) {
		
	}
	
	public DateTime(boolean check, TimeSpan ticks) {
		
	}
	
	public static DateTime now() {
		Date d = new Date();
		return new DateTime(d.getTime());
	}
	
	public static DateTime today() {
		DateTime now = now();
		return new DateTime(now.getYear(), now.getMonth(), now.getDay());
	}
	
	public long getTicks() {
		return ticks.getTicks();
	}
	
	public int getYear() {
		return 0;
	}
	
	public int getMonth() {
		return 0;
	}

	public int getDay() {
		return 0;
	}

	public void addYears(int value) {
		
	}
	
	public void addMonths(int value) {
		
	}

	public void addDays(int value) {
		
	}

	public void addHours(int value) {
		
	}

	public void addMinutes(int value) {
		
	}

	public void addSeconds(int value) {
		
	}

  @Override
  public int compareTo(DateTime o) {
    return ticks.compareTo(o.ticks);
  }

}
