package model;


@SuppressWarnings("unused")
public class Request {
	
	private static int numRequests = 0;
	private int id;
	private String name;
	private String description;
	private PTTClass pttClass;
	private int teacherID = -1;
	private boolean approved = false;
	
	
	public Request() {
		this.id = numRequests;
		numRequests++;
		name = "";
		this.description = "";
		this.pttClass = null;
	}
	public Request(String name) {
		this();
		this.name = name;
	}
	public Request(String name, String description, PTTClass pttClass, int teacherID, boolean approved) {
		this();
		this.name = name;
		this.description = description;
		this.pttClass = pttClass;
		this.teacherID = teacherID;
		this.approved = approved;
	}
	

	// Getters and Setters
	public String getName() {
		return name;
	}
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
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
}
