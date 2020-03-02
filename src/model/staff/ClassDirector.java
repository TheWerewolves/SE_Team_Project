package model.staff;


import java.util.ArrayList;

import model.Database;
import model.Request;


public class ClassDirector extends Staff {
	
	public ClassDirector() { super(); }
	public ClassDirector(int id, String name, String password) {
		super(id, name, password);
	}
	
	
	public void addRequest(String name, String description) {
		Database database = Database.getInstance();
		database.addRequest(name, description);
	}
	
	public void deleteRequest(int requestIndex) {
		Database database = Database.getInstance();
		database.deleteRequest(requestIndex);
	}

	@Override
	public ArrayList<Request> getRequest() {
		Database db = Database.getInstance();
		return db.getNotApprovedList();
	}
}
