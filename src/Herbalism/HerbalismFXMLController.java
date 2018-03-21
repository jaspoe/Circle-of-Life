package Herbalism;

import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class HerbalismFXMLController implements Initializable{
    Herbalism herbalism = new Herbalism();
	
	
    @FXML
    private void herbalismButtonRoll(ActionEvent event) {
        String terrain = herbalismComboBox.getValue();
    	herbalism.rollIngredients(terrain);
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
    
    public void herbalismFillList() {
    	herbalismListView.getItems().add("test");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
}
