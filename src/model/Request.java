package model;
import staff.Teacher;

public class Request {
	private String name;
	private PTTClass pttClass;
	private Teacher teacher;
	private int approvedStatus;
	
	public Request(String name, PTTClass pttClass, Teacher teacher, int approvedStatus) {
		this.name = name;
		this.pttClass = pttClass;
		this.teacher = teacher;
		this.approvedStatus = approvedStatus;
	}
}
