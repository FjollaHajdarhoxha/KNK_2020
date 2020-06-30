package admin;

import database.DBConnection;
import database.Hash;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsTable {

	private String studentID;
	private String studentName;
	private String studentSurname;
	private String gender;
	private String phoneNumber;
	private String email;
	private String password;
	private String classRoomNumber;
	private String addressID;
	private String birthDate;
	private int age;

	public StudentsTable(String studentID, String studentName, String studentSurname, String gender, String phoneNumber,
			String email, String password, String classRoomNumber, String addressID, String birthDate, int age) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.classRoomNumber = classRoomNumber;
		this.addressID = addressID;
		this.birthDate = birthDate;
		this.age = age;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSurname() {
		return studentSurname;
	}

	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClassRoomNumber() {
		return classRoomNumber;
	}

	public void setClassRoomNumber(String classRoomNumber) {
		this.classRoomNumber = classRoomNumber;
	}

	public String getAddressID() {
		return addressID;
	}

	public void setAddressID(String addressID) {
		this.addressID = addressID;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static boolean addStudents(String studentID, String studentName, String studentSurname, String gender,
			String phoneNumber, String email, String password, String classRoomNumber, String addressID,
			String birthDate, int age) {
		String query = "INSERT INTO Student(studentID, studentName, studentSurname, gender, phoneNumber, email, password, classRoomNumber, addressID, "
				+ "birthDate,age) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);

			preparedStatement.setString(1, studentID);
			preparedStatement.setString(2, studentName);
			preparedStatement.setString(3, studentSurname);
			preparedStatement.setString(4, gender);
			preparedStatement.setString(5, phoneNumber);
			preparedStatement.setString(6, email);
			preparedStatement.setString(7, Hash.SHA1(password));
			preparedStatement.setString(8, classRoomNumber);
			preparedStatement.setString(9, addressID);
			preparedStatement.setString(10, birthDate);
			preparedStatement.setInt(11, age);

			return (preparedStatement.executeUpdate() > 0);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static boolean updateStudents(String studentID, String studentName, String studentSurname, String gender,
			String phoneNumber, String email, String password, String classRoomNumber, String addressID,
			String birthDate, int age) {
		String query = "UPDATE student SET studentName=?, studentSurname=?, gender=?, phoneNumber=?, email=?, password=?,  classRoomNumber=?,"
				+ "addressID=?, birthDate=?, age=? WHERE studentID=?";

		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);

			preparedStatement.setString(1, studentName);
			preparedStatement.setString(2, studentSurname);
			preparedStatement.setString(3, gender);
			preparedStatement.setString(4, phoneNumber);
			preparedStatement.setString(5, email);
			preparedStatement.setString(6, Hash.SHA1(password));
			preparedStatement.setString(7, classRoomNumber);
			preparedStatement.setString(8, addressID);
			preparedStatement.setString(9, birthDate);
			preparedStatement.setInt(10, age);
			preparedStatement.setString(11, studentID);

			return (preparedStatement.executeUpdate() > 0);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static boolean deleteStudents(String id) {
		String query = "Delete from student where studentID=?";

		try {

			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			preparedStatement.setString(1, id);
			return (preparedStatement.executeUpdate() > 0);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static List<StudentsTable> getStudents() {
		List<StudentsTable> studentList = new ArrayList();

		String query = "Select * from student";

		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				StudentsTable students = new StudentsTable(resultSet.getString(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
						resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10),
						resultSet.getInt(11));
				studentList.add(students);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return studentList;
	}
}
