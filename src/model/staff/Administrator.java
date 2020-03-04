package model.staff;


import java.util.ArrayList;

import model.Database;
import model.PTTClass;
import model.Request;


public class Administrator extends Staff {
	
	public Administrator() { super(); }
	public Administrator(int id, String name, String password) {
		super(id, name, password);
	}
	
	//orginize teacher
	public void organize(Request request, int teacherID) {
		request.setTeacherID(teacherID);
	}
	
	//orgnize class
	public void organize(Request request, PTTClass pttClass) {
		request.setPTTClass(pttClass);
	}
	
	@Override
	public ArrayList<Request> getRequest() {
		Database db = Database.getInstance();
		return db.getApprovedList();
	}
}
