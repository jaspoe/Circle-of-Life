package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("mainUI.fxml"));
		
		/*HerbalismUI herbalismTab = new HerbalismUI();
		
		TabPane mainTabPane = new TabPane();
		
		mainTabPane.getTabs().add(herbalismTab.createHerablismTab());
		
		root.getChildren().add(mainTabPane);*/
		

		primaryStage.setTitle("Circle of Life");
		primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
