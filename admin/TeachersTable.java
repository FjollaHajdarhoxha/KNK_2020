package admin;

import database.DBConnection;
import database.Hash;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeachersTable {

	private String teacherID;
	private String teacherName;
	private String teacherSurname;
	private String phoneNumber;
	private String email;
	private String password;
	private String addressID;
	private String subjectID;

	public TeachersTable(String teacherID, String teacherName, String teacherSurname, String phoneNumber, String email, String password,
			String addressID, String subjectID) {
		super();
		this.teacherID = teacherID;
		this.teacherName = teacherName;
		this.teacherSurname = teacherSurname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.addressID = addressID;
		this.subjectID = subjectID;
	}

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherSurname() {
		return teacherSurname;
	}

	public void setTeacherSurname(String teacherSurname) {
		this.teacherSurname = teacherSurname;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddressID() {
		return addressID;
	}

	public void setAddressID(String addressID) {
		this.addressID = addressID;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public static boolean addTeachers(String teacherID, String teacherName, String teacherSurname, String phoneNumber,
			String email, String password, String addressID, String subjectID) {
		String query = "INSERT INTO Teacher(teacherID, teacherName, teacherSurname, phoneNumber, email, password, addressID, subjectID)"
				+ "VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);

			preparedStatement.setString(1, teacherID);
			preparedStatement.setString(2, teacherName);
			preparedStatement.setString(3, teacherSurname);
			preparedStatement.setString(4, phoneNumber);
			preparedStatement.setString(5, email);
			preparedStatement.setString(6, Hash.SHA1(password));
			preparedStatement.setString(7, addressID);
			preparedStatement.setString(8, subjectID);

			return (preparedStatement.executeUpdate() > 0);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static boolean updateTeachers(String teacherID, String teacherName, String teacherSurname,
			String phoneNumber, String email, String password, String addressID, String subjectID) {
		String query = "UPDATE Teacher SET teacherName=?, teacherSurname=?, phoneNumber=?, email=?, password=?, addressID=?, subjectID=?"
				+ "WHERE teacherID=?";

		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);

			preparedStatement.setString(1, teacherName);
			preparedStatement.setString(2, teacherSurname);
			preparedStatement.setString(3, phoneNumber);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, Hash.SHA1(password));
			preparedStatement.setString(6, addressID);
			preparedStatement.setString(7, subjectID);
			preparedStatement.setString(8, teacherID);

			return (preparedStatement.executeUpdate() > 0);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static boolean deleteTeachers(String id) {
		String query = "Delete from Teacher where teacherID=?";

		try {

			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			preparedStatement.setString(1, id);
			return (preparedStatement.executeUpdate() > 0);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static List<TeachersTable> getTeachers() {
		List<TeachersTable> teachersList = new ArrayList();

		String query = "Select * from teacher";

		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				TeachersTable teachers = new TeachersTable(resultSet.getString(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
						resultSet.getString(7), resultSet.getString(8));
				teachersList.add(teachers);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return teachersList;
	}
}