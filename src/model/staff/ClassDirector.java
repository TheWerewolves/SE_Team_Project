package model.staff;


import model.Database;


public class ClassDirector extends Staff {
	
	public ClassDirector() { super(); }
	public ClassDirector(int id, String name, String password) {
		super(id, name, password);
	}
	
	
	public void addRequest(String name, String description) {
		Database database = Database.getInstance();
		database.addRequest(name, description);
	}
	
	public void deleteRequest(int... requestIndex) {
		Database database = Database.getInstance();
		for(int i = 0; i < requestIndex.length; i++) {
			database.deleteRequest(i);
		}
	}

}
