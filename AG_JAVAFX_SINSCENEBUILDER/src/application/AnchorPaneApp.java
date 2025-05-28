package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnchorPaneApp extends Application {

	@Override
	public void start(Stage stage) {
		try {

			stage.setTitle("Probando AnchorPane");

			// creamos un AnchorPane
			AnchorPane anchorPane = new AnchorPane();

			// creamos un boton
			Button button = new Button("Elígeme");

			// OPCION 1 : poner posicion al stage y tamaño
//            button.setLayoutX(40);
//            button.setLayoutY(20);
//            button.setMinHeight(30);
//            button.setMinWidth(60);

			// OPCION 2 : anclamos el boton a los bordes, dandole asi posicion y tamaño
			AnchorPane.setTopAnchor(button, 20.0);
			AnchorPane.setBottomAnchor(button, 250.0);
			AnchorPane.setLeftAnchor(button, 40.0);
			AnchorPane.setRightAnchor(button, 30.0);

			// metemos el boton en el anchopane
			anchorPane.getChildren().add(button);

			anchorPane.setMinHeight(400); // opcional, por dar un tamaño al AnchorPane
			anchorPane.setMinWidth(400);

			// creamos la scene con el anchorpane
			Scene scene = new Scene(anchorPane, 400, 300);

			// arrancamos la scene
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String args[]) {
		launch(args);
	}
}