package model;


import model.staff.Staff;


public class Model {
	
	private Staff currentUser;
	private Database db = Database.getInstance();
	
	
	public Model() {
		currentUser = null;
	}
	
	
	public boolean Login(int id, String password) {
		
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
	
	public Staff getCurrentUser() {
		return currentUser;
	}
	
	public Request getRequest(int index) {
		return currentUser.getRequest().get(index);
	}
	
	public String getName(int id) {
		for(Staff s : db.getStaffList()) {
			if(s.getID() == id) {
				return s.getName();
			}
		}
		return "";
	}
}
