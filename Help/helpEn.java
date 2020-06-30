package Help;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class helpEn {
	
	

	

		public static void about() {

			Stage helpAboutStage = new Stage();
			
			WebView browser = new WebView();

			WebEngine webEngine = browser.getEngine();

			String url = helpEn.class.getResource("help-en.html").toExternalForm();

			System.out.println("Local URL: " + url);
			
			webEngine.load(url);

			Scene sc = new Scene(browser, 500, 300);

			helpAboutStage.setTitle("Help - English");
			helpAboutStage.setScene(sc);

			helpAboutStage.show();
		}

	}



