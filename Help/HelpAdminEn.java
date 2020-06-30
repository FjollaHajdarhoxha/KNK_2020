package Help;

import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class HelpAdminEn {

	public static void about() {

		Stage helpAboutStage = new Stage();
		
		WebView browser = new WebView();

		WebEngine webEngine = browser.getEngine();

		String url = HelpAdminEn.class.getResource("adminHelp-en.html").toExternalForm();

		System.out.println("Local URL: " + url);
		
		webEngine.load(url);

		Scene sc = new Scene(browser, 800, 500);

		helpAboutStage.setTitle("Help");
		helpAboutStage.setScene(sc);

		helpAboutStage.show();
	}

}





