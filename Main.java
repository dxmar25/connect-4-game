package application;
	
import java.io.IOException;
import java.io.OutputStream;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loadFXML = new FXMLLoader(getClass().getResource("Sample.fxml"));
			AnchorPane root = (AnchorPane) loadFXML.load();
			
			SampleController controller = loadFXML.getController();
			controller.setMainApplication(this);
			
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Connect Four");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void openPopup(String Title ,String message) {
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initStyle(StageStyle.UTILITY);
        popupStage.setTitle(Title);

        Label popupLabel = new Label(message);

        StackPane popupRoot = new StackPane();
        popupRoot.getChildren().add(popupLabel);

        Scene popupScene = new Scene(popupRoot, 200, 100);

        popupStage.setScene(popupScene);
        popupStage.showAndWait(); 
    }
		
	public void moveLogPopup(TextArea text) {
		Stage popupStage = new Stage();
		popupStage.initModality(Modality.APPLICATION_MODAL);
		popupStage.setTitle("Console Output");
		
//		TextArea textArea = new TextArea();
//        textArea.setEditable(false);
        
        VBox popupLayout = new VBox(10);
        popupLayout.getChildren().addAll(text);
        
        Scene popupScene = new Scene(popupLayout, 300, 400);
        popupStage.setScene(popupScene);
        popupStage.show();
	}

}
