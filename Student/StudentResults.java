package student;

import java.util.List;

import Help.About;
import Help.HelpStudentEn;
import Help.studentHelp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import teacher.FinalGrade;
import teacher.Grades;

public class StudentResults {
	// Table views
	private TableView gradesTable = new TableView();
	private TableView finalGradesTable = new TableView();
	private BorderPane bp = new BorderPane();

	public void openStudentResults() {
		Stage primaryStage = new Stage();
		MenuBar menuBar = new MenuBar();

		Menu file = new Menu("File");

		MenuItem itmNew = new MenuItem("New");
		MenuItem itmSave = new MenuItem("Save");
		MenuItem itmClose = new MenuItem("Close");
		itmClose.setOnAction(e -> {
			primaryStage.hide();
		});

		Menu edit = new Menu("Edit");

		MenuItem itmCut = new MenuItem("Cut");
		MenuItem itmCopy = new MenuItem("Copy");
		MenuItem itmPaste = new MenuItem("Paste");

		Menu help = new Menu("Help");
		MenuItem itmHelp = new MenuItem("Help");
		itmHelp.setOnAction(e -> {
			if(itmHelp.getText().equals("Help")) {
				HelpStudentEn.about();
			}else {
				studentHelp.about();
			}
			
		});
		About obj = new About();
		MenuItem itmAbout = new MenuItem("About");
		itmAbout.setOnAction(e -> {
			obj.openAbout();

		});
		help.getItems().addAll(itmAbout);
		help.getItems().addAll(itmHelp);

		Menu subSearch = new Menu("Search");

		MenuItem itmFind = new MenuItem("Find");
		MenuItem itmReplace = new MenuItem("Replace");

		HBox btnPane = new HBox(20);
		btnPane.setPadding(new Insets(10, 10, 10, 10));
		btnPane.getChildren().addAll();
		StackPane stackBtn = new StackPane();

		stackBtn.getChildren().add(btnPane);

		file.getItems().addAll(itmNew, itmSave, itmClose);
		edit.getItems().addAll(itmCut, itmCopy, itmPaste);
		subSearch.getItems().addAll(itmFind, itmReplace);

		menuBar.getMenus().addAll(file, edit, help);
		edit.getItems().add(subSearch);

		bp.setTop(menuBar);

		// Grades table

		TableColumn<String, Grades> column1 = new TableColumn<>("periodID");
		column1.setCellValueFactory(new PropertyValueFactory("periodID"));
		column1.setPrefWidth(80);

		TableColumn<String, Grades> column2 = new TableColumn<>("studentID");
		column2.setCellValueFactory(new PropertyValueFactory("studentID"));
		column2.setPrefWidth(120);

		TableColumn<String, Grades> column3 = new TableColumn<>("subjectID");
		column3.setCellValueFactory(new PropertyValueFactory("subjectID"));
		column3.setPrefWidth(80);

		TableColumn<String, Grades> column4 = new TableColumn<>("commitment");
		column4.setCellValueFactory(new PropertyValueFactory("commitment"));
		column4.setPrefWidth(120);

		TableColumn<String, Grades> column5 = new TableColumn<>("tasks");
		column5.setCellValueFactory(new PropertyValueFactory("tasks"));
		column5.setPrefWidth(60);

		TableColumn<String, Grades> column6 = new TableColumn<>("essay");
		column6.setCellValueFactory(new PropertyValueFactory("essay"));
		column6.setPrefWidth(60);

		TableColumn<String, Grades> column7 = new TableColumn<>("debates");
		column7.setCellValueFactory(new PropertyValueFactory("debates"));
		column7.setPrefWidth(80);

		TableColumn<String, Grades> column8 = new TableColumn<>("projects");
		column8.setCellValueFactory(new PropertyValueFactory("projects"));
		column8.setPrefWidth(80);

		TableColumn<String, Grades> column9 = new TableColumn<>("tests");
		column9.setCellValueFactory(new PropertyValueFactory("tests"));
		column9.setPrefWidth(60);

		TableColumn<String, Grades> column10 = new TableColumn<>("quizzess");
		column10.setCellValueFactory(new PropertyValueFactory("quizzess"));
		column10.setPrefWidth(80);

		TableColumn<String, Grades> column11 = new TableColumn<>("portfolio");
		column11.setCellValueFactory(new PropertyValueFactory("portfolio"));
		column11.setPrefWidth(100);

		TableColumn<String, Grades> column12 = new TableColumn<>("markPart1");
		column12.setCellValueFactory(new PropertyValueFactory("markPart1"));
		column12.setPrefWidth(100);

		TableColumn<String, Grades> column13 = new TableColumn<>("finalTest");
		column13.setCellValueFactory(new PropertyValueFactory("finalTest"));
		column13.setPrefWidth(100);

		TableColumn<String, Grades> column14 = new TableColumn<>("markPart2");
		column14.setCellValueFactory(new PropertyValueFactory("markPart2"));
		column14.setPrefWidth(100);

		TableColumn<String, Grades> column15 = new TableColumn<>("finalPeriodMark");
		column15.setCellValueFactory(new PropertyValueFactory("finalPeriodMark"));
		column15.setPrefWidth(140);

		gradesTable.getColumns().add(column1);
		gradesTable.getColumns().add(column2);
		gradesTable.getColumns().add(column3);
		gradesTable.getColumns().add(column4);
		gradesTable.getColumns().add(column5);
		gradesTable.getColumns().add(column6);
		gradesTable.getColumns().add(column7);
		gradesTable.getColumns().add(column8);
		gradesTable.getColumns().add(column9);
		gradesTable.getColumns().add(column10);
		gradesTable.getColumns().add(column11);
		gradesTable.getColumns().add(column12);
		gradesTable.getColumns().add(column13);
		gradesTable.getColumns().add(column14);
		gradesTable.getColumns().add(column15);

		gradesTable.setPrefWidth(1360);
		gradesTable.setPrefHeight(200);

		//==================  Final Grade  ===============================
		
		// Grades table

		TableColumn<String, Grades> column01 = new TableColumn<>("studentID");
		column1.setCellValueFactory(new PropertyValueFactory("studentID"));
		column1.setPrefWidth(120);

		TableColumn<String, Grades> column02 = new TableColumn<>("subjectID");
		column2.setCellValueFactory(new PropertyValueFactory("subjectID"));
		column2.setPrefWidth(80);

		TableColumn<String, Grades> column03 = new TableColumn<>("finalGrade");
		column3.setCellValueFactory(new PropertyValueFactory("finalGrade"));
		column3.setPrefWidth(120);

		finalGradesTable.getColumns().add(column01);
		finalGradesTable.getColumns().add(column02);
		finalGradesTable.getColumns().add(column03);

		finalGradesTable.setPrefWidth(320);
		finalGradesTable.setPrefHeight(200);
		
		//==================  /Final Grade  ===============================
		
		
		// Main Pane
		VBox vbox = new VBox();		
		
		vbox.getChildren().add(gradesTable);
		vbox.getChildren().add(finalGradesTable);
		bp.setBottom(vbox);
		showGrades();
		showFinalGrades();
		Scene scene = new Scene(bp);
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public void showGrades() {
		List<Grades> grades = Grades.getGrades();

		ObservableList<Grades> gradesList = FXCollections.observableArrayList();

		for (int i = 0; i < grades.size(); i++) {
			gradesList.add(grades.get(i));
		}

		gradesTable.setItems(gradesList);
	}
	
	public void showFinalGrades()
	{
		List<FinalGrade> grades2 = FinalGrade.getFinalGrades();

		ObservableList<FinalGrade> gradesList2 = FXCollections.observableArrayList();

		for (int i = 0; i < grades2.size(); i++)
		{
			gradesList2.add(grades2.get(i));
		}

		finalGradesTable.setItems(gradesList2);
	}

}