
package teacher;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

public class ChartTab {
	Tab tab;

	public ChartTab(Tab tab) {
		this.tab = tab;
	}

	public int mjaft;
	public int mire;
	public int shumemire;
	public int shkelqyeshem;

	public void open() {

		VBox pane = new VBox();
		pane.getChildren().addAll(createPieChart(), createCategoryAxis());
		tab.setContent(pane);
	}

	public Group createCategoryAxis() {
		ArrayList<String> subjectID = new ArrayList();
		ArrayList<Integer> NumriProfesoreve = new ArrayList();

		try {

			String query = "SELECT * FROM NrLendeve";

			Statement st = DBConnection.getConnection().createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				subjectID.add(rs.getString("subjectID"));
				NumriProfesoreve.add(rs.getInt("NumriProfesoreve"));

				System.out.format("%s, %s", subjectID, NumriProfesoreve);
			}
			st.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

		CategoryAxis xAxis = new CategoryAxis();

		for (int i = 0; i < subjectID.size(); i++) {

			xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(subjectID.get(i))));
		}
		xAxis.setLabel("category");

		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Teachers number");

		BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
		barChart.setTitle("Numri i profesoreve per lende");

		for (int i = 0; i < subjectID.size(); i++) {
			XYChart.Series<String, Number> series = new XYChart.Series<>();
			series.setName("Numri Profesoreve");
			series.getData().add(new XYChart.Data<>(subjectID.get(i) + "", NumriProfesoreve.get(i)));
			barChart.getData().addAll(series);
		}

		Group root = new Group(barChart);

		return root;
	}

	public PieChart createPieChart() {
		PieChart pie = new PieChart();
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList();

		try {

			String query = "SELECT * FROM CountStudents";

			Statement st = DBConnection.getConnection().createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				mjaft = rs.getInt("mjaft");
				mire = rs.getInt("mire");
				shumemire = rs.getInt("shumemire");
				shkelqyeshem = rs.getInt("shkelqyeshem");

				// print the results
				System.out.format("%s, %s, %s, %s", mjaft, mire, shumemire, shkelqyeshem);
			}
			st.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

		data.addAll(new PieChart.Data("mjaft", mjaft), new PieChart.Data("mire", mire),
				new PieChart.Data("shumemire", shumemire), new PieChart.Data("shkelqyeshem", shkelqyeshem));

		pie.setData(data);
		pie.setTitle("Suksesi i klases");
		return pie;
	}

}
