package menu;

import java.util.Locale;

import Help.About;
import Help.AdminHelp;
import Help.HelpAdminEn;
import Help.HelpStudentEn;
import Help.HelpTeacher;
import Help.teacherHelp;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MainMenu
{
	public static MenuBar mainMenu()
	{
		MenuBar menuBar = new MenuBar();
		Menu file = I18N.getMenu("file");
		Menu edit = I18N.getMenu("editMenu");
		Menu language = I18N.getMenu("language");
		
		MenuItem itmShqip = I18N.getMenuItem("shqip");
		MenuItem itmEnglish = I18N.getMenuItem("english");
		language.getItems().addAll(itmShqip, itmEnglish);
		edit.getItems().add(language);
		itmShqip.setOnAction(e -> {
			I18N.setLocale(new Locale("al"));
		});
		itmEnglish.setOnAction(e ->{
			I18N.setLocale(new Locale("en"));
		});
		Menu help = I18N.getMenu("help");
		MenuItem itmHelp = I18N.getMenuItem("help");
		help.getItems().add(itmHelp);
		itmHelp.setOnAction(e->{
			if(itmHelp.getText().equals("Help"))
			{
				HelpTeacher.about();	
			}else {
				teacherHelp.about();
			}
		});
		
		menuBar.getMenus().addAll(file, edit, help);
	
		return menuBar;
	}
}
