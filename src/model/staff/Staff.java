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
	
	
	@JsonIgnore
	protected ArrayList<Request> getRequest() {
		Database db = Database.getInstance();
		return db.getRequestList();
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
	
	public String getPermLvl() {
		return this.getClass().getSimpleName();
	}
}
