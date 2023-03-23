package application.model;

import java.util.HashMap;

public class Contact {

	private HashMap<String, String> contact;
	
	public Contact(String name, String position, String phone) {
		HashMap<String, String> info = new HashMap<String, String>();
		
		info.put("name", name);
		info.put("position", position);
		info.put("phone", phone);
		
		contact = info;
	}
	
	public Contact(String name, String relation, String phone, String location) {
		HashMap<String, String> info = new HashMap<String, String>();
		
		info.put("name", name);
		info.put("relation", relation);
		info.put("phone", phone);
		info.put("location", location);
		
		contact = info;
	}
	
	public HashMap<String, String> getContact() {
		return this.contact;
	}
	
	public void setContact(HashMap<String, String> contact) {
		this.contact = contact;
	}
}
