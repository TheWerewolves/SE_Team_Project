package model;


import staff.Staff;


@SuppressWarnings("unused")
public class Model {
	
	private Staff currentUser;
	
	
	public Model() {
		currentUser = null;
	}
	
	
	public void Login(int id, String password) {
		Database db = Database.getInstance();
		Staff staff = db.findUser(id, password);
		if(staff != null) {
			currentUser = staff;
		}
	}
	
	public void Logout() {
		currentUser = null;
	}
}
