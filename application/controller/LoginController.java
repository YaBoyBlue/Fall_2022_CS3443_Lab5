package application.controller;

import java.io.IOException;

import application.Main;
import application.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class LoginController {

	@FXML
	private ImageView image;
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	@FXML
	private Label error;
	@FXML
	private Button login;
	
	public void login() {
		Main.user = new User(username.getText(), password.getText());
		
		if (!Main.user.isValid()) {
			if (!error.isVisible()) {
				error.setVisible(true);
			}
			return;
		}
		
		if (error.isVisible())
			error.setVisible(false);
		
		try {
			AnchorPane anchorPane = (AnchorPane) new FXMLLoader(getClass().getResource("../view/UserView.fxml")).load();
			Scene scene = new Scene(anchorPane,800,800);
			
			Main.stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
