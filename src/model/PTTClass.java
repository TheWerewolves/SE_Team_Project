package model;


public class PTTClass {
	
	private static int numClasses = 0;
	private int id;
	private int size;
	private Date time;
	private String location;
	private String semester;

	
	public PTTClass() {
		this.id = numClasses;
		numClasses++;
		this.size = 0;
		this.time = null;
		this.location = "";
		this.semester = "";
	}
	public PTTClass(int size, Date time, String location, String semester) {
		this();
		this.size = size;
		this.time = time;
		this.location = location;
		this.semester = semester;
	}


	// Getters and Setters
	public int getID() {
		return id;
	}
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
		if(location.length() == 0) return "unorganized";
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSemester() {
		if(semester.length() == 0) return "unorganized";
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
}
