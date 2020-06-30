import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

public class Admin {
	public static void createStage() {
		Stage stage = new Stage();
		
		HBox hbox = new HBox(10);
		
		hbox.getChildren().add(new Label("This is Admin Stage"));
		
		Scene scene = new Scene(hbox, 300, 300);
		
		stage.setTitle("Administrator");
		stage.setScene(scene);
		stage.show();
	}

}
