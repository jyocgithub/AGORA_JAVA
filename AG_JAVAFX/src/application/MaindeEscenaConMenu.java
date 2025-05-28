package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class MaindeConMenu extends Application {



//	public static Stage mainStage;

	@Override
	public void start(Stage primaryStage) {
		try {
			String param_ficheroController = "/vista/EscenaConMenu.fxml";
			String param_titulo = "Ventana de inicio con MENU";
			GUT_fxBasicos.iniciaScene(primaryStage, param_ficheroController, param_titulo);
//			mainStage = primaryStage;
			
			// -- si queremos cambiar el tamaño o posicion del stage
			// -- y no usar la de scenebuilder (suya posicion es centrada en pantalla) 
//			primaryStage.setHeight(300);
//			primaryStage.setWidth(400);
//			// poner posicion al stage
//			primaryStage.setX(100);
//			primaryStage.setY(200);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	public static void main(String[] args) {
		launch(args);
	}
}
