package Help;

import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class studentHelp {

	public static void about() {

		Stage helpAboutStage = new Stage();
		
		WebView browser = new WebView();

		WebEngine webEngine = browser.getEngine();

		String url = studentHelp.class.getResource("studenthelp.html").toExternalForm();

		System.out.println("Local URL: " + url);
		
		webEngine.load(url);

		Scene sc = new Scene(browser, 800, 500);

		helpAboutStage.setTitle("Student - Help");
		helpAboutStage.setScene(sc);

		helpAboutStage.show();
	}
}
