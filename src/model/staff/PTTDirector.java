package model.staff;


public class PTTDirector extends Staff {
	
	public PTTDirector() { super(); }
	public PTTDirector(int id, String name, String password) {
		super(id, name, password);
	}
	
	public void approved(int requestID, boolean approved) {
		getRequest(requestID).setApproved(approved);
	}

}
