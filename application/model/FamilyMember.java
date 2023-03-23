package application.model;

public class FamilyMember extends Contact {

	public FamilyMember(String name, String relation, String phone, String location) {
		super(name, relation, phone, location);
	}
	
	public String getName() {
		return this.getContact().get("name");
	}
	
	public void setName(String name) {
		this.getContact().put("name", name);
	}
	
	public String getRelation() {
		return this.getContact().get("relation");
	}
	
	public void setRelation(String relation) {
		this.getContact().put("relation", relation);
	}
	
	public String getPhone() {
		return this.getContact().get("phone");
	}
	
	public void setPhone(String phone) {
		this.getContact().put("phone", phone);
	}
	
	public String getLocation() {
		return this.getContact().get("location");
	}
	
	public void setLocation(String location) {
		this.getContact().put("location", location);
	}
}
