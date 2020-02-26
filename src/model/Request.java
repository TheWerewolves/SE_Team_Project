package model;


@SuppressWarnings("unused")
public class Request {
	
	private static int id = 0;
	private String name;
	private String description;
	private PTTClass pttClass;
	private int teacherID = -1;
	private boolean approved = false;
	
	
	public Request(String name) {
		id++;
		this.name = name;
		this.description = "";
		this.pttClass = null;
	}
	public Request(String name, String description, PTTClass pttClass, int teacherID) {
		this(name);
		this.description = description;
		this.pttClass = pttClass;
		this.teacherID = teacherID;
	}
	
	
	public void approve() {
		this.approved = true;
	}
	
	// Getters and Setters
	public PTTClass getPTTClass() {
		return pttClass;
	}
	public void setPTTClass(PTTClass pttClass) {
		this.pttClass = pttClass;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}
	public boolean getApproved() {
		return approved;
	}
	
}
