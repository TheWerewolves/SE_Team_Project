package staff;

import java.util.ArrayList;

import model.Database;
import model.Request;

public class Teacher extends Staff {
	
	public Teacher(int id, String name, String password) {
		super(id, name, password);
	}

	@Override
	public ArrayList<Request> getRequest() {
		Database db = Database.getInstance();
		return db.getApprovedList();
	}
}
