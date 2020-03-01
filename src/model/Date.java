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


	// Getters
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	
	@Override
	public String toString() {
		return String.format("%02d/%02d/%04d", day, month, year);
	}

}