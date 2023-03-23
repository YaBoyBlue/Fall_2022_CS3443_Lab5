package application;
	
import application.model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	
	public static User user;
	
	public static AnchorPane anchorPane;
	public static Scene scene;
	public static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		
		try {
			anchorPane = (AnchorPane) new FXMLLoader(getClass().getResource("view/Login.fxml")).load();
			scene = new Scene(anchorPane,800,800);
			
			stage.setTitle("Lab 5 - Dylan Hammons");
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
