package model;

import java.util.ArrayList;

import model.staff.Staff;

public class Database {
	
	private ArrayList<Request> requestList;
	private ArrayList<Staff> staffList;
	
	// Create Singleton
	private Database() {
		load();
	}
	private static class DatabaseInstance {
		private final static Database instance = new Database();
	}
	public static Database getInstance() {
		return DatabaseInstance.instance;
	}
	
	
	public void load() {
		
	}
	
	public void save() {
		
	}
	
	public Staff findUser(int id, String password) {
		for(int i = 0; i < staffList.size(); i++) {
			Staff staff = staffList.get(i);
			if(staff.getID() == id && staff.getPassword() == password) {
				return staff;
			}
		}
		return null;
	}
	
	public void addRequest(String name, String description) {
		Request newRequest = new Request(name);
		newRequest.setDescription(description);
		requestList.add(newRequest);
	}
	
	public void deleteRequest(int index) {
		requestList.remove(index);
	}
	
	public ArrayList<Request> getApprovedList() {
		ArrayList<Request> approvedList = new ArrayList<Request>();
		requestList.forEach(request -> {
			if(request.getApproved()) approvedList.add(request);
		});
		return approvedList;
	}
	
	public Request getRequest(int index) {
		return requestList.get(index);
	}
	public ArrayList<Request> getRequestList() {
		return requestList;
	}
	public ArrayList<Staff> getStaffList() {
		return staffList;
	}
}
