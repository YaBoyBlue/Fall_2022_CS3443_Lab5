package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {

	private User user;
	
	private HashMap<String, FamilyMember> familyMembers = null;
	private HashMap<String, WorkContact> workContacts = null;
	
	public AddressBook(User user) {
		this.user = user;
	}
	
	public void fillFamilyMembers() {
		if (familyMembers != null)
			return;
		
		File file = new File("src/data/family-" + user.getName().split(" ")[0].toLowerCase() + ".csv");
		Scanner scanner;
		
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("POSSIBLE ERROR: Could not create scanner object; AddressBook.java, fillFamilyMembers; Family file may not exist.");
			return;
		}
		
		familyMembers = new HashMap<String, FamilyMember>();
		
		while(scanner.hasNextLine()) {
			String[] line = scanner.nextLine().split(",");
			
			if (line[0].equals(this.user.getName()))	//NOT NEEDED
				continue;								//BUT CONSISTENT
			
			familyMembers.put(line[0], new FamilyMember(line[0], line[1], line[2], line[3]));
		}
		
		scanner.close();
	}
	
	public void fillWorkContacts() {
		if (workContacts != null)
			return;
		
		File file = new File("src/data/work.csv");
		Scanner scanner;
		
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Could not create scanner object; AddressBook.java, fillWorkContacts; Work file does not exist.");
			return;
		}
		
		workContacts = new HashMap<String, WorkContact>();
		
		while(scanner.hasNextLine()) {
			String[] line = scanner.nextLine().split(",");
			
			if (line[0].equals(this.user.getName()))
				continue;
			
			workContacts.put(line[0], new WorkContact(line[0], line[1], line[2]));
		}
		
		scanner.close();
	}
	
	public HashMap<String, FamilyMember> getFamilyMembers() {
		return this.familyMembers;
	}
	
	public void setFamilyMembers(HashMap<String, FamilyMember> familyMembers) {
		this.familyMembers = familyMembers;
	}
	
	public FamilyMember getFamilyMember(String name) {
		return this.familyMembers.get(name);
	}
	
	public void setFamilyMember(FamilyMember familyMember) {
		this.familyMembers.put(familyMember.getName(), familyMember);
	}
	
	public HashMap<String, WorkContact> getWorkContacts() {
		return this.workContacts;
	}
	
	public void setWorkContacts(HashMap<String, WorkContact> workContacts) {
		this.workContacts = workContacts;
	}
	
	public WorkContact getWorkContact(String name) {
		return this.workContacts.get(name);
	}
	
	public void setWorkContact(WorkContact workContact) {
		this.workContacts.put(workContact.getName(), workContact);
	}
}