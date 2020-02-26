package model;


import java.util.Date;


@SuppressWarnings("unused")
public class PTTClass {
	
	private int ID;
	private int size;
	private Date time;
	private String location;
	private String semester;
	
	
	public PTTClass(int ID) {
		this.ID = ID;
		this.size = 0;
		this.time = new Date();
		this.location = "";
		this.semester = "";
	}
	public PTTClass(int ID, int size, Date time, String location, String semester) {
		this.ID = ID;
		this.size = size;
		this.time = time;
		this.location = location;
		this.semester = semester;
	}


	// Getters and Setters
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
}
