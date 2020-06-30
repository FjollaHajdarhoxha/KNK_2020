package admin;

import java.util.List;
import java.util.Locale;

import Help.About;
import Help.AdminHelp;
import Help.HelpAdminEn;
import Help.studentHelp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import menu.I18N;

public class StudentsPanel {
	ComboBox<String> languagesCbo = new ComboBox<>();

	private Label studentLabel = new Label("Student Registration Details");
	private Button btnEdit = new Button();
	private Button btnDelete = new Button();
	private Button btnClear = new Button();
	private Button btnSave = new Button();
	private TextField studentID = new TextField();
	private TextField studentName = new TextField();
	private TextField studentSurname = new TextField();
	private TextField gender = new TextField();
	private TextField phoneNumber = new TextField();
	private TextField email = new TextField();
	private PasswordField password = new PasswordField();
	private TextField classRoomNumber = new TextField();
	private TextField addressID = new TextField();
	private TextField birthDate = new TextField();
	private TextField age = new TextField();

	private TableView studentsTable = new TableView();

	public void createStage() {

		ObservableList<String> applicationLanguages = FXCollections.observableArrayList();
		for (int i = 0; i < I18N.getLocales().size(); i++) {
			applicationLanguages.add(I18N.getLocales().get(i).getLanguage());
		}

		BorderPane pane = new BorderPane();
		Stage stage = new Stage();

		VBox vboxMain = new VBox();

		BorderPane root = new BorderPane();

		MenuBar menuBar = new MenuBar();

		Menu file = I18N.getMenu("file");

		MenuItem itmClose = I18N.getMenuItem("close");
		itmClose.setOnAction(e -> {
			stage.hide();
		});

		Menu edit = I18N.getMenu("editMenu");
		Menu language = I18N.getMenu("language");

		MenuItem itmShqip = I18N.getMenuItem("shqip");
		MenuItem itmEnglish =I18N.getMenuItem("english");
		language.getItems().addAll(itmShqip, itmEnglish);
		edit.getItems().add(language);
		itmShqip.setOnAction(e -> {
			I18N.setLocale(new Locale("al"));
		});
		itmEnglish.setOnAction(e ->{
			I18N.setLocale(new Locale("en"));
		});


		MenuItem itmTeacher = I18N.getMenuItem("teachersPanel");
		itmTeacher.setOnAction(e -> {
			new TeachersPanel().createStage();
		});
		MenuItem itmAbout = I18N.getMenuItem("about");
		MenuItem itmHelp = I18N.getMenuItem("help");

		itmHelp.setOnAction(e -> {
			if(itmHelp.getText().equals("Help"))
			{
				HelpAdminEn.about();
			}else {
				AdminHelp.about();
			}
		});
	
		About obj = new About();
		itmAbout.setOnAction(e -> {
			obj.openAbout();

		});

		Menu help = new Menu("Help");
		pane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.F1) {
				studentHelp.about();
			}
			if (e.isAltDown() && e.getCode() == KeyCode.F4) {
				stage.hide();
			}
			if (e.isControlDown() && e.getCode() == KeyCode.A) {
				adminSetAllEnable();
			}
			if (e.isControlDown() && e.getCode() == KeyCode.E) {
				updateStudents();
			}
			if (e.isShiftDown() && e.getCode() == KeyCode.C) {
				clearForm();
				adminSetAllDisable();
			}
			if (e.isControlDown() && e.getCode() == KeyCode.S) {
				insertStudents();
			}
		});

		file.getItems().addAll(itmClose);
		edit.getItems().addAll(itmTeacher);
		help.getItems().addAll(itmAbout);
		help.getItems().addAll(itmHelp);

		menuBar.getMenus().addAll(file, edit, help);

		root.setTop(menuBar);

		TableColumn<String, StudentsTable> column1 = I18N.getTblColumn("nrID");
		column1.setCellValueFactory(new PropertyValueFactory("studentID"));
		column1.setPrefWidth(60);

		TableColumn<String, StudentsTable> column2 = I18N.getTblColumn("firstname");
		column2.setCellValueFactory(new PropertyValueFactory("studentName"));
		column2.setPrefWidth(150);

		TableColumn<String, StudentsTable> column3 =  I18N.getTblColumn("fastname");
		column3.setCellValueFactory(new PropertyValueFactory("studentSurname"));
		column3.setPrefWidth(150);

		TableColumn<String, StudentsTable> column4 =  I18N.getTblColumn("gender");
		column4.setCellValueFactory(new PropertyValueFactory("gender"));
		column4.setPrefWidth(120);

		TableColumn<String, StudentsTable> column5 =  I18N.getTblColumn("phone");
		column5.setCellValueFactory(new PropertyValueFactory("phoneNumber"));
		column5.setPrefWidth(120);

		TableColumn<String, StudentsTable> column6 =  I18N.getTblColumn("email");
		column6.setCellValueFactory(new PropertyValueFactory("email"));
		column6.setPrefWidth(120);

		TableColumn<String, StudentsTable> column7 =  I18N.getTblColumn("password");
		column7.setCellValueFactory(new PropertyValueFactory("password"));
		column7.setPrefWidth(120);

		TableColumn<String, StudentsTable> column8 =  I18N.getTblColumn("classroom");
		column8.setCellValueFactory(new PropertyValueFactory("classRoomNumber"));
		column8.setPrefWidth(120);

		TableColumn<String, StudentsTable> column9 =  I18N.getTblColumn("adress");
		column9.setCellValueFactory(new PropertyValueFactory("addressID"));
		column9.setPrefWidth(120);

		TableColumn<String, StudentsTable> column10 =  I18N.getTblColumn("birthdate");
		column10.setCellValueFactory(new PropertyValueFactory("birthDate"));
		column10.setPrefWidth(120);

		TableColumn<Integer, StudentsTable> column11 =  I18N.getTblColumn("age");
		column11.setCellValueFactory(new PropertyValueFactory("age"));
		column1.setPrefWidth(120);

		studentsTable.getColumns().add(column1);
		studentsTable.getColumns().add(column2);
		studentsTable.getColumns().add(column3);
		studentsTable.getColumns().add(column4);
		studentsTable.getColumns().add(column5);
		studentsTable.getColumns().add(column6);
		studentsTable.getColumns().add(column7);
		studentsTable.getColumns().add(column8);
		studentsTable.getColumns().add(column9);
		studentsTable.getColumns().add(column10);
		studentsTable.getColumns().add(column11);

		studentsTable.setRowFactory(tv -> {
			TableRow<StudentsTable> row = new TableRow<>();

			row.setOnMouseClicked(e -> {
				studentID.setText(row.getItem().getStudentID());
				studentName.setText(row.getItem().getStudentName());
				studentSurname.setText(row.getItem().getStudentSurname());
				gender.setText(String.valueOf(row.getItem().getGender()));
				email.setText(String.valueOf(row.getItem().getEmail()));
				phoneNumber.setText(String.valueOf(row.getItem().getPhoneNumber()));
				classRoomNumber.setText(String.valueOf(row.getItem().getClassRoomNumber()));
				addressID.setText(String.valueOf(row.getItem().getAddressID()));
				birthDate.setText(String.valueOf(row.getItem().getBirthDate()));
				age.setText(String.valueOf(row.getItem().getAge()));
				password.setText(row.getItem().getPassword());
				adminSetAllEnable();
				studentID.setDisable(true);
				pane.setOnKeyPressed(ev -> {
					if (ev.isControlDown() && ev.getCode() == KeyCode.D) {
						deleteStudents();
					}
				});
			});
			return row;
		});
//		studentsTable.setPrefWidth(500);
//		studentsTable.setPrefHeight(200);
		showStudents();

		VBox vbox = new VBox();
		btnEdit = I18N.getButton("edit");
		btnDelete = I18N.getButton("delete");
		btnClear = I18N.getButton("clear");
		btnSave = I18N.getButton("save");
		HBox hbox = new HBox();
		Button btnAddNew = I18N.getButton("addnew");
		btnAddNew.setStyle("-fx-background-color:green;-fx-text-fill:white;");
		btnEdit.setStyle("-fx-background-color:green;-fx-text-fill:white;");
		btnDelete.setStyle("-fx-background-color:red;-fx-text-fill:white;");
		VBox vbox2 = new VBox();
		Label label_1 = I18N.getLabel("studentRegistrationDetails");
		label_1.setStyle("-fx-text-fill:#4682B4;-fx-font-weight:bold;-fx-font-size:22;");
		label_1.setPadding(new Insets(2, 18, 1, 25));
		hbox.getChildren().addAll(btnAddNew, btnEdit, btnDelete);
		hbox.setPadding(new Insets(10, 10, 10, 27));
		hbox.setSpacing(20);
		vbox2.getChildren().add(hbox);
		vbox2.getChildren().add(label_1);

		Label label_2 = I18N.getLabel("personalInformation");
		label_2.setStyle("-fx-text-fill:#800080;-fx-font-weight:bold;-fx-font-size:18;");
		label_2.setPadding(new Insets(4, 1, 1, 4));

		GridPane gridPane1 = new GridPane();
		gridPane1.addRow(0, I18N.getLabel("nrID"));
		gridPane1.addRow(0, studentID);
		gridPane1.addRow(1, I18N.getLabel("firstname"));
		gridPane1.addRow(1, studentName);
		gridPane1.addRow(2, I18N.getLabel("fastname"));
		gridPane1.addRow(2, studentSurname);
		gridPane1.addRow(3, I18N.getLabel("gender"));
		gridPane1.addRow(3, gender);
		gridPane1.addRow(4, I18N.getLabel("phone"));
		gridPane1.addRow(4, phoneNumber);
		gridPane1.addRow(5, I18N.getLabel("email"));
		gridPane1.addRow(5, email);
		gridPane1.addRow(6, I18N.getLabel("password"));
		gridPane1.addRow(6, password);
		gridPane1.addRow(7, I18N.getLabel("classroom"));
		gridPane1.addRow(7, classRoomNumber);
		gridPane1.addRow(8, I18N.getLabel("adress"));
		gridPane1.addRow(8, addressID);
		gridPane1.addRow(9, I18N.getLabel("birthdate"));
		gridPane1.addRow(9, birthDate);
		gridPane1.addRow(10, I18N.getLabel("age"));
		gridPane1.addRow(10, age);

		gridPane1.setVgap(10);
		gridPane1.setHgap(15);

		gridPane1.setPadding(new Insets(4, 12, 4, 22));

		VBox vbox3 = new VBox();

		vbox3.getChildren().add(label_2);
		vbox3.getChildren().add(gridPane1);

		btnSave.setOnAction(e -> {
			insertStudents();
		});

		btnClear.setOnAction(e -> {
			clearForm();
			adminSetAllDisable();
		});
		btnEdit.setOnAction(e -> {
			updateStudents();
		});
		btnDelete.setOnAction(e -> {
			deleteStudents();
		});

		btnAddNew.setOnAction(e -> {
			adminSetAllEnable();
		});

		pane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.A) {
				adminSetAllEnable();
			}
		});

		HBox hbox5 = new HBox();

		hbox5.getChildren().addAll(btnClear, btnSave);

		btnClear.setStyle("-fx-background-color:red;-fx-text-fill:white;");
		btnSave.setStyle("-fx-background-color:green;-fx-text-fill:white;");

		hbox5.setAlignment(Pos.BASELINE_RIGHT);
		hbox5.setSpacing(20);
		hbox5.setPadding(new Insets(7, 17, 10, 1));

		vbox.getChildren().add(vbox2);
		vbox.getChildren().add(vbox3);
		vbox.getChildren().add(hbox5);

		vboxMain.getChildren().add(root);
		vboxMain.getChildren().add(vbox);

		adminSetAllDisable();
		HBox mainPane = new HBox(50);
		mainPane.getChildren().addAll(vboxMain, studentsTable);
		pane.setTop(menuBar);
		pane.setBottom(mainPane);

		pane.setOnKeyPressed(e -> {
			if(e.isControlDown() && e.getCode() == KeyCode.H) {
				if(itmHelp.getText().equals("Help"))
				{
					HelpAdminEn.about();
				}else {
					AdminHelp.about();
				}
			}
		});
		Scene scene = new Scene(pane);

		stage.setTitle("Students Panel");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	public void showStudents() {
		List<StudentsTable> students = StudentsTable.getStudents();

		ObservableList<StudentsTable> studentsList = FXCollections.observableArrayList();

		for (int i = 0; i < students.size(); i++) {
			studentsList.add(students.get(i));
		}

		studentsTable.setItems(studentsList);
	}

	public void insertStudents() {

		if (StudentsTable.addStudents(studentID.getText(), studentName.getText(), studentSurname.getText(),
				gender.getText(), phoneNumber.getText(), email.getText(), password.getText(), classRoomNumber.getText(),
				addressID.getText(), birthDate.getText(), Integer.parseInt(age.getText()))) {
			showStudents();
			clearForm();
		}
	}

	private void deleteStudents() {
		if (StudentsTable.deleteStudents(studentID.getText())) {
			showStudents();
			clearForm();
		}
	};

	private void updateStudents() {
		if (StudentsTable.updateStudents(studentID.getText(), studentName.getText(), studentSurname.getText(),
				gender.getText(), phoneNumber.getText(), email.getText(), password.getText(), classRoomNumber.getText(),
				addressID.getText(), birthDate.getText(), Integer.parseInt(age.getText()))) {
			showStudents();
			clearForm();
		}
	};

	public void clearForm() {
		studentID.setText("");
		studentName.setText("");
		studentSurname.setText("");
		gender.setText("");
		phoneNumber.setText("");
		email.setText("");
		classRoomNumber.setText("");
		addressID.setText("");
		birthDate.setText("");
		age.setText("");
		password.setText("");
	}

	private void adminSetAllEnable() {
		studentID.setDisable(false);
		studentName.setDisable(false);
		studentSurname.setDisable(false);
		gender.setDisable(false);
		phoneNumber.setDisable(false);
		email.setDisable(false);
		password.setDisable(false);
		classRoomNumber.setDisable(false);
		addressID.setDisable(false);
		birthDate.setDisable(false);
		age.setDisable(false);
	}

	private void adminSetAllDisable() {
		studentID.setDisable(true);
		studentName.setDisable(true);
		studentSurname.setDisable(true);
		gender.setDisable(true);
		phoneNumber.setDisable(true);
		email.setDisable(true);
		password.setDisable(true);
		classRoomNumber.setDisable(true);
		addressID.setDisable(true);
		birthDate.setDisable(true);
		age.setDisable(true);

	}

}
