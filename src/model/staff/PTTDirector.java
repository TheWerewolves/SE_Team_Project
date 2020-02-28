package model.staff;


import model.Database;


public class PTTDirector extends Staff {
	
	public PTTDirector(int id, String name, String password) {
		super(id, name, password);
	}
	
	public void approved(int requestIndex) {
		Database database = Database.getInstance();
		database.getRequest(requestIndex).approve();
	}

}
