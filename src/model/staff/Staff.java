package model.staff;


import java.util.ArrayList;

import model.Database;
import model.Request;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Staff {
	
	protected int id;
	protected String name;
	protected String password;

	
	public Staff() {
		id = -1;
		name = "";
		password = "";
	}
	public Staff(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	
	//get the staff's permission level
	@JsonIgnore
	public String getPermLvl() {
		return this.getClass().getSimpleName();
	}
	
	//different staff have different requirement to get the requestList
	// for example. teacher and admin only can see the approved request
	// class director can only see the not approved request.
	@JsonIgnore
	public ArrayList<Request> getRequest() {
		Database db = Database.getInstance();
		return db.getRequestList();
	}
	
	//get a specific request from its ID
	@JsonIgnore
	public Request getRequest(int id) {
		Database db = Database.getInstance();
		return db.getRequest(id);
	}
	
	// Getters
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
