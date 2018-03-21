package Herbalism;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class HerbalismUI {

	public Tab createHerablismTab() {
		Tab herbalismTab = new Tab();
		AnchorPane herbalismAnchorPane1 = new AnchorPane();
		VBox herbalismVBox = new VBox();
		AnchorPane herbalismAnchorPane2 = new AnchorPane();
		ComboBox herbalismComboBox = new ComboBox();
		Button herbalismButton = new Button();
		
		herbalismAnchorPane2.getChildren().add(herbalismButton);
		herbalismAnchorPane2.getChildren().add(herbalismComboBox);
		
		herbalismVBox.getChildren().add(herbalismAnchorPane2);
		
		herbalismAnchorPane1.getChildren().add(herbalismVBox);
		
		herbalismTab.setContent(herbalismAnchorPane1);
		
		return herbalismTab;
	}
	
	
	
}
