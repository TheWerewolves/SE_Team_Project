package model;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import model.staff.Administrator;
import model.staff.ClassDirector;
import model.staff.PTTDirector;
import model.staff.Staff;
import model.staff.Teacher;


public class Database {
	
	private ArrayList<Request> requestList;
	private ArrayList<Staff> staffList;
	
	
	private ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	
	
	// Create Singleton
	private Database() {
		requestList = new ArrayList<Request>();
		staffList = new ArrayList<Staff>();
		load();
	}
	private static class DatabaseInstance {
		private final static Database instance = new Database();
	}
	public static Database getInstance() {
		return DatabaseInstance.instance;
	}
	
	
	public void load() {
		
		try {
			
			JsonNode jn = mapper.readTree(new File("./Database.json"));
			Administrator[] administrators = mapper.treeToValue(jn.get("Staffs").get("Administrator"), Administrator[].class);
			ClassDirector[] classDirectors = mapper.treeToValue(jn.get("Staffs").get("ClassDirector"), ClassDirector[].class);
			PTTDirector[] pttDirectors = mapper.treeToValue(jn.get("Staffs").get("PTTDirector"), PTTDirector[].class);
			Teacher[] teachers = mapper.treeToValue(jn.get("Staffs").get("Teacher"), Teacher[].class);
			
			staffList.addAll(Arrays.asList(administrators));
			staffList.addAll(Arrays.asList(classDirectors));
			staffList.addAll(Arrays.asList(pttDirectors));
			staffList.addAll(Arrays.asList(teachers));
			
			Request[] requests = mapper.treeToValue(jn.get("Requests"), Request[].class);
			
			requestList.addAll(Arrays.asList(requests));

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void save() {
		
		ArrayList<Staff> administratorList = new ArrayList<Staff>();
		ArrayList<Staff> classDirectorList = new ArrayList<Staff>();
		ArrayList<Staff> pttDirectorList = new ArrayList<Staff>();
		ArrayList<Staff> teacherList = new ArrayList<Staff>();
		
		for (Staff s : staffList) {
			if(s instanceof Administrator) {
				administratorList.add(s);
				
			} else if(s instanceof ClassDirector) {
				classDirectorList.add(s);
				
			} else if(s instanceof PTTDirector) {
				pttDirectorList.add(s);
				
			} else if(s instanceof Teacher) {
				teacherList.add(s);
			}
		}
		
		ObjectNode objectNode = mapper.createObjectNode();
		ObjectNode staffs = mapper.createObjectNode();
		
		staffs.putPOJO("Administrator", administratorList);
		staffs.putPOJO("ClassDirector", classDirectorList);
		staffs.putPOJO("PTTDirector", pttDirectorList);
		staffs.putPOJO("Teacher", teacherList);
		
		objectNode.putPOJO("Staffs", staffs);
		objectNode.putPOJO("Requests", requestList);

        try {
			mapper.writeValue(new File("./Database.json"), objectNode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Staff findUser(int id, String password) {
		for(int i = 0; i < staffList.size(); i++) {
			Staff staff = staffList.get(i);
			if(staff.getID() == id && staff.getPassword().equals(password)) {
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
