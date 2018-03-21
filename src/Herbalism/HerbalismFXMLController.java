package Herbalism;

import javafx.event.ActionEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class HerbalismFXMLController implements Initializable{
    Herbalism herbalism = new Herbalism();
	
    @FXML
    private void herbalismButtonRoll(ActionEvent event) {
        String terrain = herbalismComboBox.getValue();
    	herbalismFillList(herbalism.rollIngredients(terrain));
    	
    }
    
    @FXML
    JFXComboBox<String> herbalismComboBox = new JFXComboBox<String>();
    
    public void herbalismSetTerrain() {
    	for (int i = 0; i < herbalism.getTerrainTable().size(); i++) {
    		herbalismComboBox.getItems().add(herbalism.getTerrainTable().get(i));
    	}
    }
    
    
    @FXML
    JFXListView<String> herbalismListView = new JFXListView<String>();
    
    public void herbalismFillList(List<Herb> herbList) {
    	herbalismListView.getItems().clear();
    	for(int i = 0; i < herbList.size(); i++) {
    		herbalismListView.getItems().add(herbList.get(i).getName() + ", " + herbList.get(i).getAdditionalRule());
    	}
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
}
