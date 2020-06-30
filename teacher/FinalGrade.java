package teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.StudentsTable;
import database.DBConnection;

public class FinalGrade
{
	private String studentID;
	private String subjectID;
	private double finalGrade;

	public FinalGrade(String studentID, String subjectID, double finalGrade)
	{
		this.studentID = studentID;
		this.subjectID = subjectID;
		this.finalGrade = finalGrade;
	}
	

	public String getStudentID()
	{
		return studentID;
	}

	public void setStudentID(String studentID)
	{
		this.studentID = studentID;
	}

	public String getSubjectID()
	{
		return subjectID;
	}

	public void setSubjectID(String subjectID)
	{
		this.subjectID = subjectID;
	}

	public double getFinalGrade()
	{
		return finalGrade;
	}

	public void setFinalGrade(double finalGrade)
	{
		this.finalGrade = finalGrade;
	}
	
	public static List<FinalGrade> getFinalGrades()
	{
		List<FinalGrade> gradeList = new ArrayList();

		String query = "Select * from finalPeriodMark";

		try
		{
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				FinalGrade grade = new FinalGrade(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3));

				gradeList.add(grade);
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}

		return gradeList;
	}
		
	public static boolean addGrade(String studentID, String subjectID, double finalGrade)
	{
		String query = "INSERT INTO finalGrade(studentID, subjectID, finalGrade) VALUES(?,?,?)";

		try
		{
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);

			preparedStatement.setString(1, studentID);
			preparedStatement.setString(2, subjectID);
			preparedStatement.setDouble(3, finalGrade);

			return (preparedStatement.executeUpdate() > 0);
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
}