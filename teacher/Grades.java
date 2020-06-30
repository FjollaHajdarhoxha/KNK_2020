package teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import database.DBConnection;

public class Grades
{
	private String periodID;
	private String studentID;
	private String subjectID;
	private double commitment;
	private double tasks;
	private double essay;
	private double debates;
	private double projects;
	private double tests;
	private double quizzess;
	private double portfolio;
	private double markPart1;
	private double finalTest;
	private double markPart2;
	private double finalPeriodMark;

	public Grades(String periodID, String studentID, String subjectID, double commitment, double tasks, double essay,
			double debates, double projects, double tests, double quizzess, double portfolio, double markPart1,
			double finalTest, double markPart2, double finalPeriodMark)
	{
		this.periodID = periodID;
		this.studentID = studentID;
		this.subjectID = subjectID;
		this.commitment = commitment;
		this.tasks = tasks;
		this.essay = essay;
		this.debates = debates;
		this.projects = projects;
		this.tests = tests;
		this.quizzess = quizzess;
		this.portfolio = portfolio;
		this.markPart1 = markPart1;
		this.finalTest = finalTest;
		this.markPart2 = markPart2;
		this.finalPeriodMark = finalPeriodMark;
	}

	public String getPeriodID()
	{
		return periodID;
	}

	public void setPeriodID(String periodID)
	{
		this.periodID = periodID;
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

	public double getCommitment()
	{
		return commitment;
	}

	public void setCommitment(double commitment)
	{
		this.commitment = commitment;
	}

	public double getTasks()
	{
		return tasks;
	}

	public void setTasks(double tasks)
	{
		this.tasks = tasks;
	}

	public double getEssay()
	{
		return essay;
	}

	public void setEssay(double essay)
	{
		this.essay = essay;
	}

	public double getDebates()
	{
		return debates;
	}

	public void setDebates(double debates)
	{
		this.debates = debates;
	}

	public double getProjects()
	{
		return projects;
	}

	public void setProjects(double projects)
	{
		this.projects = projects;
	}

	public double getTests()
	{
		return tests;
	}

	public void setTests(double tests)
	{
		this.tests = tests;
	}

	public double getQuizzess()
	{
		return quizzess;
	}

	public void setQuizzess(double quizzess)
	{
		this.quizzess = quizzess;
	}

	public double getPortfolio()
	{
		return portfolio;
	}

	public void setPortfolio(double portfolio)
	{
		this.portfolio = portfolio;
	}

	public double getMarkPart1()
	{
		return markPart1;
	}

	public void setMarkPart1(double markPart1)
	{
		this.markPart1 = markPart1;
	}

	public double getFinalTest()
	{
		return finalTest;
	}

	public void setFinalTest(double finalTest)
	{
		this.finalTest = finalTest;
	}

	public double getMarkPart2()
	{
		return markPart2;
	}

	public void setMarkPart2(double markPart2)
	{
		this.markPart2 = markPart2;
	}

	public double getFinalPeriodMark()
	{
		return finalPeriodMark;
	}

	public void setFinalPeriodMark(double finalPeriodMark)
	{
		this.finalPeriodMark = finalPeriodMark;
	}

	public static boolean addGrade(String periodID, String studentID, String subjectID, double commitment, double tasks,
			double essay, double debates, double projects, double tests, double quizzess, double portfolio,
			double markPart1, double finalTest, double markPart2, double finalPeriodMark)
	{
		String query = "INSERT INTO Grades(periodID, studentID, subjectID, commitment, tasks, "
				+ "essay, debates, projects, tests, quizzess, portfolio, markPart1, finalTest, markPart2, finalPeriodMark) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try
		{
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);

			preparedStatement.setString(1, periodID);
			preparedStatement.setString(2, studentID);
			preparedStatement.setString(3, subjectID);
			preparedStatement.setDouble(4, commitment);
			preparedStatement.setDouble(5, tasks);
			preparedStatement.setDouble(6, essay);
			preparedStatement.setDouble(7, debates);
			preparedStatement.setDouble(8, projects);
			preparedStatement.setDouble(9, tests);
			preparedStatement.setDouble(10, quizzess);
			preparedStatement.setDouble(11, portfolio);
			preparedStatement.setDouble(12, markPart1);
			preparedStatement.setDouble(13, finalTest);
			preparedStatement.setDouble(14, markPart2);
			preparedStatement.setDouble(15, finalPeriodMark);

			return (preparedStatement.executeUpdate() > 0);
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	public static boolean updateGrade(String periodID, String studentID, String subjectID, double commitment,
			double tasks, double essay, double debates, double projects, double tests, double quizzess,
			double portfolio, double markPart1, double finalTest, double markPart2, double finalPeriodMark)
	{
		String query = "UPDATE Grades SET commitment=?, "
				+ "tasks=?, essay=?, debates=?, projects=?, tests=?, quizzess=?, portfolio=?, "
				+ "markPart1=?, finalTest=?, markPart2=?, finalPeriodMark=? WHERE studentID=? AND periodID=? AND subjectID=?";

		try
		{
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);

			
			preparedStatement.setDouble(1, commitment);
			preparedStatement.setDouble(2, tasks);
			preparedStatement.setDouble(3, essay);
			preparedStatement.setDouble(4, debates);
			preparedStatement.setDouble(5, projects);
			preparedStatement.setDouble(6, tests);
			preparedStatement.setDouble(7, quizzess);
			preparedStatement.setDouble(8, portfolio);
			preparedStatement.setDouble(9, markPart1);
			preparedStatement.setDouble(10, finalTest);
			preparedStatement.setDouble(11, markPart2);
			preparedStatement.setDouble(12, finalPeriodMark);
			preparedStatement.setString(13, studentID);
			preparedStatement.setString(14, periodID);
			preparedStatement.setString(15, subjectID);

			return (preparedStatement.executeUpdate() > 0);
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	public static boolean deleteGrade(String periodID, String studentID, String subjectID)
	{
		String query = "Delete from Grades where periodID=? AND studentID=? AND subjectID=?";

		try
		{
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			preparedStatement.setString(1, periodID);
			preparedStatement.setString(2, studentID);
			preparedStatement.setString(3, subjectID);
			return (preparedStatement.executeUpdate() > 0);
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	public static List<Grades> getGrades()
	{
		List<Grades> gradeList = new ArrayList();

		String query = "Select * from Grades";

		try
		{
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				Grades grade = new Grades(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getDouble(7),
						resultSet.getDouble(8), resultSet.getDouble(9), resultSet.getDouble(10),
						resultSet.getDouble(11), resultSet.getDouble(12), resultSet.getDouble(13),
						resultSet.getDouble(14), resultSet.getDouble(15));

				gradeList.add(grade);
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}

		return gradeList;
	}
	
}