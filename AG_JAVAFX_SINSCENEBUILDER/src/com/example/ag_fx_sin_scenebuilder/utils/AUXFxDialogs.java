package com.example.ag_fx_sin_scenebuilder.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;

public class AUXFxDialogs {

	// *******************************************************************
	// ******************** DIALOGOS *****************************
	// *******************************************************************

	public static void mensaje(String pTexto, String pTitulo) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(pTitulo);
		alert.setContentText(pTexto);
		alert.showAndWait();
	}

	public static void mensajeConfirmacion(String pTexto, String pTitulo) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle(pTitulo);
		alert.setContentText(pTexto);
		alert.showAndWait();

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			// ... cuando eligen si
			alert.close();
		} else {
			// ... cuando eligen no o cancelan el dialog
		}
	}

	public static void mensajeConInput(String texto) {

		TextInputDialog dialog = new TextInputDialog("texto que sale por defecto");
		dialog.setContentText(texto);

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			System.out.println("Ha escrito: " + result.get());
		}

	}

	public static void mensajeConLista(String texto) {

		List<String> choices = new ArrayList<>();
		choices.add("a");
		choices.add("b");
		choices.add("c");

		ChoiceDialog<String> dialog = new ChoiceDialog<>("b", choices);
		dialog.setHeaderText("Elegir");
		dialog.setContentText(texto);

		// Obteniendo la respuesa con un optional
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			System.out.println("Elegido" + result.get());
			dialog.close();
		}

	}
}
