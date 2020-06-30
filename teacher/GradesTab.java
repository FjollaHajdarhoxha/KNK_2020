package teacher;

import java.util.List;

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
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import menu.I18N;

public class GradesTab
{
	Tab tab;

	public GradesTab(Tab tab)
	{
		this.tab = tab;
	}
	
	public GradesTab()
	{
		
	}

	// Text fields
	private TextField periodIDTxt = new TextField();
	private TextField studentIDTxt = new TextField();
	private TextField subjectIDTxt = new TextField();
	private TextField commitmentTxt = new TextField();
	private TextField tasksTxt = new TextField();
	private TextField essayTxt = new TextField();
	private TextField debatesTxt = new TextField();
	private TextField projectsTxt = new TextField();
	private TextField testsTxt = new TextField();
	private TextField quizzessTxt = new TextField();
	private TextField portfolioTxt = new TextField();
	private TextField markPart1Txt = new TextField();
	private TextField finalTestTxt = new TextField();
	private TextField markPart2Txt = new TextField();
	private TextField finalPeriodMarkTxt = new TextField();

	// Buttons
	private Button insertBtn = new Button();
	private Button updateBtn = new Button();
	private Button deleteBtn = new Button();
	private Button clearBtn = new Button();

	
	// Table views
	private TableView gradesTable = new TableView();

	public void open()
	{
		// Form pane
		GridPane formPane = new GridPane();
		insertBtn = I18N.getButton("insert");
		updateBtn = I18N.getButton("insert");
		deleteBtn = I18N.getButton("delete");
		clearBtn = I18N.getButton("clear");
		
		
		

		formPane.addRow(0, I18N.getLabel("periodid"), periodIDTxt);
		formPane.addRow(1, I18N.getLabel("nrID"), studentIDTxt);
		formPane.addRow(2, I18N.getLabel("subjectid"), subjectIDTxt);
		formPane.addRow(3, I18N.getLabel("commitment"), commitmentTxt);
		formPane.addRow(4, I18N.getLabel("tasks"), tasksTxt);
		formPane.addRow(5, I18N.getLabel("essay"), essayTxt);
		formPane.addRow(6, I18N.getLabel("debates"), debatesTxt);
		formPane.addRow(7, I18N.getLabel("projects"), projectsTxt);
		formPane.addRow(8, I18N.getLabel("tests"), testsTxt);
		formPane.addRow(9, I18N.getLabel("quzzess"), quizzessTxt);
		formPane.addRow(10, I18N.getLabel("portfolio"), portfolioTxt);
		formPane.addRow(11, I18N.getLabel("markpart1"), markPart1Txt);
		formPane.addRow(12, I18N.getLabel("finaltest"), finalTestTxt);
		formPane.addRow(13, I18N.getLabel("markpart2"), markPart2Txt);
		formPane.addRow(14, I18N.getLabel("finalperiodmark"), finalPeriodMarkTxt);

		formPane.setHgap(10);
		formPane.setVgap(10);

		markPart1Txt.setDisable(true);
		markPart2Txt.setDisable(true);
		finalPeriodMarkTxt.setDisable(true);

		// Buttons pane
		HBox buttonsPane = new HBox(10);

		buttonsPane.getChildren().addAll(insertBtn, updateBtn, deleteBtn, clearBtn);

		insertBtn.setOnAction(e -> {
			insertGrade();
		});

		clearBtn.setOnAction(e -> {
			clearForm();
		});

		deleteBtn.setOnAction(e -> {
			deleteGrade();
		});

		updateBtn.setOnAction(e -> {
			updateGrade();
		});

		// Left Pane

		VBox leftPane = new VBox(50);

		leftPane.getChildren().addAll(formPane, buttonsPane);

		// Grades table

		TableColumn<String, Grades> column1 = I18N.getTblColumn("periodid");
		column1.setCellValueFactory(new PropertyValueFactory("periodID"));
		column1.setPrefWidth(80);

		TableColumn<String, Grades> column2 = I18N.getTblColumn("nrID");
		column2.setCellValueFactory(new PropertyValueFactory("studentID"));
		column2.setPrefWidth(120);

		TableColumn<String, Grades> column3 = I18N.getTblColumn("subjectid");
		column3.setCellValueFactory(new PropertyValueFactory("subjectID"));
		column3.setPrefWidth(80);

		TableColumn<String, Grades> column4 =I18N.getTblColumn("commitment");
		column4.setCellValueFactory(new PropertyValueFactory("commitment"));
		column4.setPrefWidth(120);

		TableColumn<String, Grades> column5 = I18N.getTblColumn("tasks");
		column5.setCellValueFactory(new PropertyValueFactory("tasks"));
		column5.setPrefWidth(60);

		TableColumn<String, Grades> column6 = I18N.getTblColumn("essay");
		column6.setCellValueFactory(new PropertyValueFactory("essay"));
		column6.setPrefWidth(60);

		TableColumn<String, Grades> column7 = I18N.getTblColumn("debates");
		column7.setCellValueFactory(new PropertyValueFactory("debates"));
		column7.setPrefWidth(80);

		TableColumn<String, Grades> column8 = I18N.getTblColumn("projects");
		column8.setCellValueFactory(new PropertyValueFactory("projects"));
		column8.setPrefWidth(80);

		TableColumn<String, Grades> column9 = I18N.getTblColumn("tests");
		column9.setCellValueFactory(new PropertyValueFactory("tests"));
		column9.setPrefWidth(60);

		TableColumn<String, Grades> column10 = I18N.getTblColumn("quzzess");
		column10.setCellValueFactory(new PropertyValueFactory("quizzess"));
		column10.setPrefWidth(80);

		TableColumn<String, Grades> column11 = I18N.getTblColumn("portfolio");
		column11.setCellValueFactory(new PropertyValueFactory("portfolio"));
		column11.setPrefWidth(100);

		TableColumn<String, Grades> column12 = I18N.getTblColumn("markpart1");
		column12.setCellValueFactory(new PropertyValueFactory("markPart1"));
		column12.setPrefWidth(100);

		TableColumn<String, Grades> column13 = I18N.getTblColumn("finaltest");
		column13.setCellValueFactory(new PropertyValueFactory("finalTest"));
		column13.setPrefWidth(100);

		TableColumn<String, Grades> column14 = I18N.getTblColumn("markpart2");
		column14.setCellValueFactory(new PropertyValueFactory("markPart2"));
		column14.setPrefWidth(100);

		TableColumn<String, Grades> column15 = I18N.getTblColumn("finalperiodmark");
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

		gradesTable.setRowFactory(tv -> {
			TableRow<Grades> row = new TableRow<>();

			row.setOnMouseClicked(e -> {

				periodIDTxt.setText(row.getItem().getPeriodID());
				studentIDTxt.setText(row.getItem().getStudentID());
				subjectIDTxt.setText(row.getItem().getSubjectID());
				commitmentTxt.setText(String.valueOf(row.getItem().getCommitment()));
				tasksTxt.setText(String.valueOf(row.getItem().getTasks()));
				essayTxt.setText(String.valueOf(row.getItem().getEssay()));
				debatesTxt.setText(String.valueOf(row.getItem().getDebates()));
				projectsTxt.setText(String.valueOf(row.getItem().getProjects()));
				testsTxt.setText(String.valueOf(row.getItem().getTests()));
				quizzessTxt.setText(String.valueOf(row.getItem().getQuizzess()));
				portfolioTxt.setText(String.valueOf(row.getItem().getPortfolio()));
				markPart1Txt.setText(String.valueOf(row.getItem().getMarkPart1()));
				finalTestTxt.setText(String.valueOf(row.getItem().getFinalTest()));
				markPart2Txt.setText(String.valueOf(row.getItem().getMarkPart2()));
				finalPeriodMarkTxt.setText(String.valueOf(row.getItem().getFinalPeriodMark()));

				markPart1Txt.setDisable(true);
				markPart2Txt.setDisable(true);
				finalPeriodMarkTxt.setDisable(true);
				deleteBtn.setOnKeyPressed(ev -> {
					if(ev.isControlDown() && ev.getCode() == KeyCode.D)
					{
						deleteGrade();
					}
				});
			});

			return row;
		});

		gradesTable.setPrefWidth(1360);
		gradesTable.setPrefHeight(200);

		// Main Pane
		HBox mainPane = new HBox(10);

		mainPane.getChildren().addAll(leftPane, gradesTable);

		mainPane.setPadding(new Insets(15, 15, 15, 15));

		showGrades();
		
		tab.setContent(mainPane);
	}

	public void showGrades()
	{
		List<Grades> grades = Grades.getGrades();

		ObservableList<Grades> gradesList = FXCollections.observableArrayList();

		for (int i = 0; i < grades.size(); i++)
		{
			gradesList.add(grades.get(i));
		}

		gradesTable.setItems(gradesList);
	}

	public void clearForm()
	{
		periodIDTxt.setText("");
		studentIDTxt.setText("");
		subjectIDTxt.setText("");
		commitmentTxt.setText("");
		tasksTxt.setText("");
		essayTxt.setText("");
		debatesTxt.setText("");
		projectsTxt.setText("");
		testsTxt.setText("");
		quizzessTxt.setText("");
		portfolioTxt.setText("");
		markPart1Txt.setText("");
		finalTestTxt.setText("");
		markPart2Txt.setText("");
		finalPeriodMarkTxt.setText("");
	}

	public void insertGrade()
	{
		double markPart1 = Double.parseDouble(commitmentTxt.getText()) * 0.3 +
						   Double.parseDouble(tasksTxt.getText()) * 0.1 +
						   Double.parseDouble(essayTxt.getText()) * 0.1 +
						   Double.parseDouble(debatesTxt.getText()) * 0.1 + 
						   Double.parseDouble(projectsTxt.getText()) * 0.1 +
						   Double.parseDouble(testsTxt.getText()) * 0.2 + 
						   Double.parseDouble(quizzessTxt.getText()) * 0.05 + 
						   Double.parseDouble(portfolioTxt.getText()) * 0.05;
		
		double markPart2 = Double.parseDouble(finalTestTxt.getText()) * 0.4;
		
		double finalPeriodMark = markPart1 * 0.6 + markPart2;
						   

		if (Grades.addGrade(periodIDTxt.getText(), studentIDTxt.getText(), subjectIDTxt.getText(),
				Double.parseDouble(commitmentTxt.getText()), Double.parseDouble(tasksTxt.getText()),
				Double.parseDouble(essayTxt.getText()), Double.parseDouble(debatesTxt.getText()),
				Double.parseDouble(projectsTxt.getText()), Double.parseDouble(testsTxt.getText()),
				Double.parseDouble(quizzessTxt.getText()), Double.parseDouble(portfolioTxt.getText()),
				markPart1, Double.parseDouble(finalTestTxt.getText()),
				markPart2, finalPeriodMark))
		{
			showGrades();
			clearForm();
		}
	}

	public void updateGrade()
	{
		if (Grades.updateGrade(periodIDTxt.getText(), studentIDTxt.getText(), subjectIDTxt.getText(),
				Double.parseDouble(commitmentTxt.getText()), Double.parseDouble(tasksTxt.getText()),
				Double.parseDouble(essayTxt.getText()), Double.parseDouble(debatesTxt.getText()),
				Double.parseDouble(projectsTxt.getText()), Double.parseDouble(testsTxt.getText()),
				Double.parseDouble(quizzessTxt.getText()), Double.parseDouble(portfolioTxt.getText()),
				Double.parseDouble(markPart1Txt.getText()), Double.parseDouble(finalTestTxt.getText()),
				Double.parseDouble(markPart2Txt.getText()), Double.parseDouble(finalPeriodMarkTxt.getText())))
		{
			showGrades();
			clearForm();
		}
	}

	public void deleteGrade()
	{
		if (Grades.deleteGrade(periodIDTxt.getText(), studentIDTxt.getText(), subjectIDTxt.getText()))
		{
			showGrades();
			clearForm();
		}
	}
}