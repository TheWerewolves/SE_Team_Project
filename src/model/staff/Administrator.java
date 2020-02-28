package model.staff;


import java.util.ArrayList;

import model.Database;
import model.PTTClass;
import model.Request;


public class Administrator extends Staff {
	
	public Administrator(int id, String name, String password) {
		super(id, name, password);
	}
	
	public void organize(int requestIndex, int teacherID, PTTClass pttClass) {
		Database database = Database.getInstance();
		database.getRequestList().get(requestIndex).setTeacherID(teacherID);
		database.getRequest(requestIndex).setPTTClass(pttClass);
	}
	
	@Override
	public ArrayList<Request> getRequest() {
		Database db = Database.getInstance();
		return db.getApprovedList();
	}
}
