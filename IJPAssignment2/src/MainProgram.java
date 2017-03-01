//IJP AssignMent 2, Version 1.1, 27 Nov 2016 

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.WorldController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 * The main program of the application
 * @author Assignment source
 * @version 1.0
 */


public class MainProgram extends Application {
	/**
	 * Start the application
	 */
	public void start(Stage stage) {
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			String viewerFxml = "WorldViewer.fxml";
			AnchorPane page = (AnchorPane) fxmlLoader.load(this.getClass().getResource(viewerFxml).openStream());
			Scene scene = new Scene(page);
			stage.setScene(scene);
			
			//Set the window of the application unResizable 
			stage.setResizable(false);
			
			WorldController controller = (WorldController) fxmlLoader.getController();      			
			controller.initialise();

			stage.show();
        
		} catch (IOException ex) {
		   Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
		   System.exit(1);
		}
	}
	/**
	 * Main program
	 * @param args
	 */
    public static void main(String args[]) {
    	launch(args);
    	System.exit(0);
    }
}
