package teacher;

import java.sql.ResultSet;
import java.util.List;

import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FinalGradeTab
{
	Tab tab;

	public FinalGradeTab(Tab tab)
	{
		this.tab = tab;
	}

	// Table views
	private TableView gradesTable = new TableView();

	public void open()
	{

		// Grades table

		TableColumn<String, Grades> column1 = new TableColumn<>("studentID");
		column1.setCellValueFactory(new PropertyValueFactory("studentID"));
		column1.setPrefWidth(120);

		TableColumn<String, Grades> column2 = new TableColumn<>("subjectID");
		column2.setCellValueFactory(new PropertyValueFactory("subjectID"));
		column2.setPrefWidth(80);

		TableColumn<String, Grades> column3 = new TableColumn<>("finalGrade");
		column3.setCellValueFactory(new PropertyValueFactory("finalGrade"));
		column3.setPrefWidth(120);

		gradesTable.getColumns().add(column1);
		gradesTable.getColumns().add(column2);
		gradesTable.getColumns().add(column3);

		gradesTable.setPrefWidth(320);
		gradesTable.setPrefHeight(200);

		// Main Pane
		HBox mainPane = new HBox(10);

		mainPane.getChildren().addAll(gradesTable);

		mainPane.setPadding(new Insets(15, 15, 15, 15));

		showFinalGrades();

		tab.setContent(mainPane);
	}

	public void showFinalGrades()
	{
		List<FinalGrade> grades = FinalGrade.getFinalGrades();

		ObservableList<FinalGrade> gradesList = FXCollections.observableArrayList();

		for (int i = 0; i < grades.size(); i++)
		{
			gradesList.add(grades.get(i));
		}

		gradesTable.setItems(gradesList);
	}
}