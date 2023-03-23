package application.controller;

import java.io.IOException;

import application.Main;
import application.model.WorkContact;
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

public class WorkContactController {

	@FXML
	private AnchorPane pane;
	@FXML
	private ImageView image;
	@FXML
	private TableView<WorkContact> table;
	@FXML
	private TableColumn<WorkContact, String> name;
	@FXML
	private TableColumn<WorkContact, String> title;
	@FXML
	private TableColumn<WorkContact, String> phone;
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
		
		Main.user.getAddressBook().fillWorkContacts();
		
		name.setCellValueFactory(new PropertyValueFactory<>("Name"));
		title.setCellValueFactory(new PropertyValueFactory<>("Position"));
		phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
		
		for (WorkContact contact : Main.user.getAddressBook().getWorkContacts().values()) {
			table.getItems().add(contact);
		}
	}
}
