import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import menu.I18N;
import menu.MainMenu;

import java.util.Locale;

import admin.MainLogin;
import admin.StudentsPanel;
import admin.StudentsPanel;
import admin.TeachersPanel;
import admin.TeachersTable;
import student.StudentLogin;
import teacher.TeacherLogin;

public class Main extends Application {

	private Button admin;
	private Button teacher;
	private Button student;

	@Override
	public void start(Stage primaryStage) {
		Image image1 = new Image("images/admin1.png");
		Image image2 = new Image("images/teacher1.png");
		Image image3 = new Image("images/student1.png");
		Image imgShqip = new Image("images/kosovee.png");
		Image imgEnglish = new Image("images/english.png");
		ImageView imgViewShqip = new ImageView(imgShqip);
		ImageView imgViewEnglish = new ImageView(imgEnglish);
		HBox photoPane = new HBox(20);
		imgViewShqip.setFitHeight(50);
		imgViewShqip.setFitWidth(70);
		imgViewEnglish.setFitHeight(50);
		imgViewEnglish.setFitWidth(70);
		Button btnShqip = new Button("KS", imgViewShqip);
		Button btnEnglish = new Button("EN", imgViewEnglish);
		btnShqip.setOnAction(e -> {
			I18N.setLocale(new Locale("al"));
		});
		btnEnglish.setOnAction(e -> {
			I18N.setLocale(new Locale("en"));
		});
		btnShqip.setStyle("-fx-background-color: transparent;");
		btnEnglish.setStyle("-fx-background-color: transparent;");
		ImageView adminImage = new ImageView(image1);
		ImageView teacherImage = new ImageView(image2);
		ImageView studentImage = new ImageView(image3);
		adminImage.setFitHeight(100);
		adminImage.setFitWidth(100);
		studentImage.setFitHeight(100);
		studentImage.setFitWidth(100);
		teacherImage.setFitHeight(100);
		teacherImage.setFitWidth(100);
		photoPane.getChildren().addAll(btnShqip, btnEnglish);
		photoPane.setPadding(new Insets(20, 0, 0, 20));
		GridPane pane = new GridPane();
		admin = I18N.getButton("admin");
		teacher = I18N.getButton("teacher");
		student = I18N.getButton("student");
		admin.setOnAction(e -> {
			new MainLogin().createStage();
		});
		teacher.setOnAction(e -> {
			new TeacherLogin().createStage();
		});
		student.setOnAction(e -> {
			new StudentLogin().createStage();
		});

		pane.addRow(0, adminImage, teacherImage, studentImage);
		pane.addRow(1, admin, teacher, student);
		pane.setAlignment(Pos.CENTER);
		pane.setStyle("-fx-padding:10;");
		pane.setHgap(50);
		pane.setVgap(20);
//		pane.setHalignment(admLabel, HPos.CENTER);
//		pane.setHalignment(tchLabel, HPos.CENTER);
		pane.setHalignment(admin, HPos.CENTER);
		pane.setHalignment(teacher, HPos.CENTER);
		pane.setHalignment(student, HPos.CENTER);

		BorderPane mainPain = new BorderPane();
		mainPain.setOnKeyPressed(e -> {
			if (e.isControlDown() && e.getCode() == KeyCode.A) {
				new MainLogin().createStage();
			}
			if (e.isControlDown() && e.getCode() == KeyCode.T) {
				new TeacherLogin().createStage();
			}
			if (e.isControlDown() && e.getCode() == KeyCode.S) {
				new StudentLogin().createStage();
			}
		});
		mainPain.setTop(photoPane);
		mainPain.setCenter(pane);
		Scene scene = new Scene(mainPain, 700, 400);
		scene.getStylesheets().add("style.css");
		pane.setStyle("-fx-background-image: url(images/main-background.4jpeg.jpeg);-fx-background-size:cover;");
		primaryStage.setScene(scene);
		primaryStage.setTitle("Main");
		primaryStage.show();
	}
}
