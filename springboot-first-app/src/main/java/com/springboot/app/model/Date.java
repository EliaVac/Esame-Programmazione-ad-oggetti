package com.springboot.app.model;

public class Date {
	private int year;
	private int month;
    private int day;
    private int hour;
    private int minute;

	public Date(String date,String time) {
		String[] date_sliced=date.split("-");
		String[] time_sliced=time.split(":");
		this.year = Integer.parseInt(date_sliced[0]);
		this.month = Integer.parseInt(date_sliced[1]);
		this.day = Integer.parseInt(date_sliced[2]);
		this.hour = Integer.parseInt(time_sliced[0]);
		this.minute = Integer.parseInt(time_sliced[1]);
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}

	@Override
	public String toString() {
		String correct_hour,correct_minute,correct_day,correct_month;
		if(hour<10)
			correct_hour="0"+hour;
		else
			correct_hour=""+hour ;
		if(minute<10)
			correct_minute="0"+minute;
		else
			correct_minute=""+minute;
		if(day<10)
			correct_day="0"+day;
		else
			correct_day=""+day;
		if(month<10)
			correct_month="0"+month;
		else
			correct_month=""+month;
		
		return  correct_hour + ":" + correct_minute+ " - "+correct_day + "/" + correct_month + "/" + year;
	}

}
