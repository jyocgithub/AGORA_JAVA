package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.GUT_fxBasicos;
import application.GUT_fxDialogs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EscenaLoginController {

	Stage esteStage;

	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	Button bt_acceder;
	@FXML
	TextField txt_usuario;
	@FXML
	TextField txt_contrasena;
	@FXML
	Label lbl_imagen;
	@FXML
	Label lbl_usuario;

	@FXML
	void onAccederPulsado(ActionEvent event) throws IOException {

		esteStage = GUT_fxBasicos.getStage(bt_acceder);

		String nombre = txt_usuario.getText();
		String contrasena = txt_contrasena.getText();
//		if (nombre.equals("pepe") && contrasena.equals("123")) {
		GUT_fxDialogs.mensaje("ACCESO CONCEDIDO", "ACCEDIENDO");

		GUT_fxBasicos.meteSaco(esteStage, "nombre", nombre);
		GUT_fxBasicos.meteSaco(esteStage, "contrasena", contrasena);

		String param_ficheroController = "/vista/EscenaPrincipal.fxml";
		String param_titulo = "Ventana de inicio";
		GUT_fxBasicos.iniciaStage(bt_acceder, param_ficheroController, param_titulo);

//		} else {
//			GUT_fxDialogs.mensaje("ACCESO DENEGADO.", "ACCEDIENDO");
//		}
	}

	// este método actua como el 'constructor' de la ventana, pero cuidado, puede que aun no
	// estan bien instanciados todos los nodos, por ejepmlo, el scene 
	@FXML
	void initialize() {
		GUT_fxBasicos.ponImagen("/imagenes/cara.png", lbl_imagen);
	}

}