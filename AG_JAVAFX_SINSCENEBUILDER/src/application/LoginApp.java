package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class LoginApp extends Application {
	Stage miStage;
	Button btAcceder;
	Button btBorrar;

	public static void main(String[] args) {
		// para arrancar la aplicacion, llamamos a launch(), que a su vez, internamente,
		// llama a start()
		launch(args);
	}

	// start() se llama directamente desde launch()
	@Override
	public void start(Stage primaryStage) throws IOException {
		// start() recibe como parámetro el escenario principal de la aplicación, ya
		// creado
		miStage = primaryStage;

		inicializar();
		listeners();

	}

	public void inicializar() {

		try {
			// crear un elemento (nodo) que sera el nodo raiz de los otros elementos (nodos)
			// normalmente, se trata de un layout
			GridPane root = new GridPane();
			root.setPadding(new Insets(15, 12, 15, 12));
			root.setVgap(5);
			root.setHgap(5);
			// Setting size for the pane
			root.setMinSize(400, 200);
			// Setting the Grid alignment
			root.setAlignment(Pos.CENTER);

			// crear una escena, y decirle cual es el nodo raiz de la misma
			Scene escenaPrincipal = new Scene(root, 400, 400);

			// ------------ STAGE --------------
			// poner tamaño al stage
			miStage.setHeight(300);
			miStage.setWidth(400);

			// poner posicion al stage
			miStage.setX(100);
			miStage.setY(200);

			// o simplemente ventrarlo en la pantalla
			centrarStage(miStage);

			// titulo al stage
			miStage.setTitle("Ventana LOGIN JavaFX");

			// añadimos al escena al escenario
			miStage.setScene(escenaPrincipal);

			// mostramos el escenario
			miStage.show();

			// ------------ TEXT --------------
			// metemos textos

			// creating label edmail
			Text text1 = new Text("Email");
			Text text2 = new Text("Password");
			TextField textField1 = new TextField();
			TextField textField2 = new TextField();
			btAcceder = new Button("Acceder");
			btBorrar = new Button("Borrar");

			root.add(text1, 0, 0);
			root.add(textField1, 1, 0);
			root.add(text2, 0, 1);
			root.add(textField2, 1, 1);
			root.add(btBorrar, 0, 2);
			root.add(btAcceder, 1, 2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listeners() throws IOException {

		btAcceder.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// -------------- abrir una segunda ventana que es una application, no un fxml
//				new ComponentesApp();
//
////                //  -------------- abrir una segunda ventana FXML
//				try {
////                    AUXFxDialogs.mensaje("Acceso concedido");
//					URL recurso = getClass().getResource("/jy/fxidealibro/VentanaConController.fxml");
//					FXMLLoader fxmlLoader = new FXMLLoader(recurso);
//
//					Stage stage = new Stage();
////                    stage.initModality(Modality.APPLICATION_MODAL);  // si queremos que la ventana sea modal
////                    stage.initStyle(StageStyle.UNDECORATED);  // si no queremos title bar en la nueva ventana
//					stage.setTitle("Segunda ventana");
//
//					Parent parentRoot = fxmlLoader.load();
//					stage.setScene(new Scene(parentRoot));
//					stage.show();
//
//				} catch (IOException ex) {
//					ex.printStackTrace();
//				}
			}
		});
	}

	public void centrarStage(Stage pStage) {
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		pStage.setX((primScreenBounds.getWidth() - pStage.getWidth()) / 2);
		pStage.setY((primScreenBounds.getHeight() - pStage.getHeight()) / 2);
	}

}
