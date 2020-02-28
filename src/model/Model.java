package model;


import model.staff.Staff;


@SuppressWarnings("unused")
public class Model {
	
	private Staff currentUser;
	
	
	public Model() {
		currentUser = null;
	}
	
	
	public boolean Login(int id, String password) {
		Database db = Database.getInstance();
		Staff staff = db.findUser(id, password);
		if(staff != null) {
			currentUser = staff;
			return true;
		}
		return false;
	}
	
	public void Logout() {
		currentUser = null;
	}
}
