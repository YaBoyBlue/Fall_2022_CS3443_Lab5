package application.controller;

import java.io.IOException;

import application.Main;
import application.model.FamilyMember;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class FamilyContactController {

	@FXML
	private AnchorPane pane;
	@FXML
	private ImageView image;
	@FXML
	private TableView<FamilyMember> table;
	@FXML
	private TableColumn<FamilyMember, String> name;
	@FXML
	private TableColumn<FamilyMember, String> relation;
	@FXML
	private TableColumn<FamilyMember, String> phone;
	@FXML
	private TableColumn<FamilyMember, String> locationn; //KEY WORD, WOW
	@FXML
	private Label first;
	@FXML
	private Button logout;
	@FXML
	private Button back;
	
	public void back() {
		try {
			AnchorPane anchorPane = (AnchorPane) new FXMLLoader(getClass().getResource("../view/UserView.fxml")).load();
			Scene scene = new Scene(anchorPane,800,800);
			
			Main.stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void logout() {
		try {
			AnchorPane anchorPane = (AnchorPane) new FXMLLoader(getClass().getResource("../view/Login.fxml")).load();
			Scene scene = new Scene(anchorPane,800,800);
			
			Main.stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initialize() {
		pane.setStyle("-fx-background-color:" + Main.user.getColor1());
		logout.setStyle("-fx-background-color:" + Main.user.getColor2() + "; -fx-text-fill:" + Main.user.getColor1());
		back.setStyle("-fx-background-color:" + Main.user.getColor2() + "; -fx-text-fill:" + Main.user.getColor1());
		first.setText(Main.user.getName().split(" ")[0]);		
		
		Main.user.getAddressBook().fillFamilyMembers();
		
		if (Main.user.getAddressBook().getFamilyMembers().size() < 1)
			return;
		
		name.setCellValueFactory(new PropertyValueFactory<>("Name"));
		relation.setCellValueFactory(new PropertyValueFactory<>("Relation"));
		phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
		locationn.setCellValueFactory(new PropertyValueFactory<>("Location"));
		
		for (FamilyMember contact : Main.user.getAddressBook().getFamilyMembers().values()) {
			table.getItems().add(contact);
		}
	}
}
