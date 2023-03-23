package application.model;

public class WorkContact extends Contact {

	public WorkContact(String name, String position, String phone) {
		super(name, position, phone);
	}
	
	public String getName() {
		return this.getContact().get("name");
	}
	
	public void setName(String name) {
		this.getContact().put("name", name);
	}
	
	public String getPosition() {
		return this.getContact().get("position");
	}
	
	public void setPosition(String position) {
		this.getContact().put("position", position);
	}
	
	public String getPhone() {
		return this.getContact().get("phone");
	}
	
	public void setPhone(String phone) {
		this.getContact().put("phone", phone);
	}
}
