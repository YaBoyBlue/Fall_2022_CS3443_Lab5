package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class User {

	private String name;
	private String username;
	private String password;
	private String color1;
	private String color2;
	
	private AddressBook addressBook;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		
		addressBook = new AddressBook(this);
	}
	
	public boolean isValid() {
		File file = new File("src/data/login.csv");
		Scanner scanner;
		
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Could not create scanner object; User.java, validate; Login file does not exist.");
			return false;
		}
		
		String[] line;
		
		while(scanner.hasNextLine()) {
			line = scanner.nextLine().split(",");
			
			if (line[1].equals(this.username) && line[2].equals(this.password)) {
				this.name = line[0];
				this.color1 = line[3];
				this.color2 = line[4];
				
				scanner.close();
				return true;
			}
		}
		
		scanner.close();
		return false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getColor1() {
		return this.color1;
	}
	
	public void setColor1(String color1) {
		this.color1 = color1;
	}
	
	public String getColor2() {
		return this.color2;
	}
	
	public void setColor2(String color2) {
		this.color2 = color2;
	}
	
	public AddressBook getAddressBook() {
		return this.addressBook;
	}
}
