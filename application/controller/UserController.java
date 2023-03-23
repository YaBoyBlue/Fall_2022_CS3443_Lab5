package application.controller;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class UserController {

	@FXML
	private AnchorPane pane;
	@FXML
	private ImageView image;
	@FXML
	private Label full;
	@FXML
	private Button work;
	@FXML
	private Button family;
	@FXML
	private Label first;
	@FXML
	private Button logout;
	
	public void work() {
		try {
			AnchorPane anchorPane = (AnchorPane) new FXMLLoader(getClass().getResource("../view/WorkContactView.fxml")).load();
			Scene scene = new Scene(anchorPane,800,800);
			
			Main.stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void family() {
		try {
			AnchorPane anchorPane = (AnchorPane) new FXMLLoader(getClass().getResource("../view/FamilyContactView.fxml")).load();
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
		work.setStyle("-fx-background-color:" + Main.user.getColor2() + "; -fx-text-fill:" + Main.user.getColor1());
		family.setStyle("-fx-background-color:" + Main.user.getColor2() + "; -fx-text-fill:" + Main.user.getColor1());
		logout.setStyle("-fx-background-color:" + Main.user.getColor2() + "; -fx-text-fill:" + Main.user.getColor1());
		
		full.setText(Main.user.getName());
		first.setText(Main.user.getName().split(" ")[0]);
	}
}
