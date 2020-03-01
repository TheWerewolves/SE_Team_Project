package model;


public class Date {

	private int day;
	private int month;
	private int year;


	public Date() {
		this.day = -1;
		this.month = -1;
		this.year = -1;
	}
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	
	public static Date parseDate(String s) throws Exception {
		String[] splits = s.split("/");
		Date d = new Date();
		
		d.setDay(Integer.parseInt(splits[0]));
		d.setMonth(Integer.parseInt(splits[1]));
		d.setYear(Integer.parseInt(splits[2]));
		
		return d;
	}

	// Getters and Setters
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return String.format("%02d/%02d/%04d", day, month, year);
	}

}