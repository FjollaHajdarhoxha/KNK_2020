import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

public class Login extends Application
{
	private Connection dbConnection;
	private TextField username = new TextField();
	private PasswordField password = new PasswordField();
	private Button btnDergo = new Button("KYÇU");
	private Stage mainStage;
	private Scene scene2 = new Scene(new Label("Mirdita"));

	public void start(Stage primaryStage)
	{
		setDBConnection();
		
		mainStage = primaryStage;
		HBox hbox = new HBox(30);
		VBox vbox = new VBox(20);
		StackPane photoPane = new StackPane();
		
		ImageView schoolImage = new ImageView("images/school.jpg");
		ImageView logoImage = new ImageView("images/logo.png");
		logoImage.setFitHeight(300);
		logoImage.setFitWidth(250);
		photoPane.getChildren().add(schoolImage);
		
		StackPane logoPane = new StackPane();
		logoPane.getChildren().add(logoImage);
		
		GridPane loginPane = new GridPane();
		loginPane.addRow(0, new Label("Perdoruesi: "));
		loginPane.addRow(0, username);
		loginPane.addRow(1, new Label("Fjalekalimi: "));
		loginPane.addRow(1, password);
		
		loginPane.setAlignment(Pos.CENTER);
		loginPane.setHalignment(btnDergo, HPos.CENTER);
		btnDergo.setOnAction(e -> {
			loginUser();
		});
		loginPane.add(btnDergo, 1, 2);
		btnDergo.setStyle("-fx-background-color:red; -fx-text-fill: white; -fx-border-radius:20px;"); 
		loginPane.setVgap(15);
		vbox.getChildren().addAll(logoPane, loginPane);
		hbox.setStyle("-fx-background-color:white");
		hbox.getChildren().addAll(photoPane, vbox);
		Scene scene = new Scene(hbox);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	public void loginUser() {
		String query = "Select * from Administrator where email = ? AND password = ?";
		try {
			PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
			//
			preparedStatement.setString(1, username.getText());
			preparedStatement.setString(2, password.getText());
			
			ResultSet result = preparedStatement.executeQuery();
			
			if(result.next()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Logged in");
				alert.setHeaderText(null);
				alert.setContentText("You are log in!");
				
				alert.showAndWait();
				
//				mainStage.show();
				mainStage.setScene(scene2);
				
//				System.exit(1);
			}
                                else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("User not found");
				alert.setHeaderText(null);
				alert.setContentText("Email or password not found!");
				
				alert.showAndWait();
				
//				System.exit(1);
			}
			
		}
		catch(SQLException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Database problem!");
			alert.setHeaderText(null);
			alert.setContentText("Cannot connect to database!");
			
			alert.showAndWait();
			
			System.exit(1);
		}
	}
	private void setDBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/knk", "root","root");	
		}
		catch(Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Database problem!");
			alert.setHeaderText(null);
			alert.setContentText("Cannot connect to database!");
			
			alert.showAndWait();
			
			System.exit(1);
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
