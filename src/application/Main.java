package application;
	
import Herbalism.Herbalism;
import Herbalism.HerbalismFXMLController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("mainUI.fxml"));
		Parent root = loader.load();
		
		//short version
		//Parent root = FXMLLoader.load(getClass().getResource("mainUI.fxml"));
		
		HerbalismFXMLController herbalismController = loader.getController();
		herbalismController.herbalismSetTerrain();
		
		
		primaryStage.setTitle("Circle of Life");
		primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
