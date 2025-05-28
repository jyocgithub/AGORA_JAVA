package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class GUT_fxBasicos {

	/**
	 * INICIA STAGE Construye una escena en el stage indicado, y arranca dicha
	 * escena Esta sobrecargado, esta opcion recibe el Stage, si se conoce
	 * 
	 * @param esteStage
	 * @param pFicheroControllerFXML
	 * @param pTituloVentana
	 * @throws IOException
	 */
	public static void iniciaStage(Stage esteStage, String pFicheroControllerFXML, String pTituloVentana)
			throws IOException {

		URL recurso = GUT_fxBasicos.class.getResource(pFicheroControllerFXML);
		FXMLLoader fxmlLoader = new FXMLLoader(recurso);
		Parent parent = fxmlLoader.load();
//      pStage.initModality(Modality.APPLICATION_MODAL);  // si queremos que la ventana sea modal
//      pStage.initStyle(StageStyle.UNDECORATED);         // si no queremos title bar en la nueva ventana
//		Scene scene = new Scene(parentRoot, 300, 275);
		Scene scene = new Scene(parent);
		esteStage.setScene(scene);
		esteStage.setTitle(pTituloVentana);
		esteStage.show();
	}

	/**
	 * INICIA STAGE Construye una escena en el stage indicado, y arranca dicha
	 * escena Esta sobrecargado, esta opcion no recibe el Stage, sino un objeto Node
	 * cualquiera del que se extrae el Stage Node es la madre de casi todos los
	 * controles y layouts, se necesita recibir un objeto de cualquier cosa hija de
	 * Node para sacar de ahi el Stage actual
	 * 
	 * @param cualquiernodo
	 * @param pFicheroControllerFXML
	 * @param pTituloVentana
	 * @throws IOException
	 */
	public static void iniciaStage(Node cualquiernodo, String pFicheroControllerFXML, String pTituloVentana)
			throws IOException {

		Stage esteStage = getStage(cualquiernodo);

		URL recurso = GUT_fxBasicos.class.getResource(pFicheroControllerFXML);
		FXMLLoader fxmlLoader = new FXMLLoader(recurso);
		Parent parent = fxmlLoader.load();
//      pStage.initModality(Modality.APPLICATION_MODAL);  // si queremos que la ventana sea modal
//      pStage.initStyle(StageStyle.UNDECORATED);         // si no queremos title bar en la nueva ventana
//		Scene scene = new Scene(parentRoot, 300, 275);
		Scene scene = new Scene(parent);
		esteStage.setScene(scene);
		esteStage.setTitle(pTituloVentana);
		esteStage.show();
	}

	/**
	 * GET STAGE Obtiene el stage actual a partir de cualquier nodo que exista en él
	 * mismo
	 * 
	 * @param cualquiernodo un nodo de cualquier stage
	 * @return el stage donde esta el nodo
	 */
	public static Stage getStage(Node cualquiernodo) {
		return (Stage) cualquiernodo.getScene().getWindow();
	}

	/**
	 * PON IMAGEN Pone una imagen en un Label, sabiendo solo el nombre del fichero
	 * imagen y el objeto label
	 * 
	 * @param pPathImagen nombre del fichero imagen
	 * @param pLabel      el objeto label donde se pone la imagen
	 */
	public static void ponImagen(String pPathImagen, Label pLabel) {

		// PODEMOS CREAR UMAGEVIEW DIRECTAMENTE DESDE UN PATH
		Image img = new Image(pPathImagen);
		ImageView view = new ImageView(img);
		view.setFitHeight(80);
		view.setPreserveRatio(true);
		pLabel.setGraphic(view);

		// O PODEMOS OBTENER UNA URL Y USAR GETRESOURCE() PARA SACAR UNA URL Y CON ELLA
		// SE USAN FILE , FILEINPUTSTREAM...
		// ===== accedemos a un recurso de nuestro directorio de recursos
		// ESTE CASO ES SIN USAR MAVEN, POR LO QUE NO HAY UNA CARPETA PROPIA DE RECURSOS
		// AQUI RECURSOS SE NOMBRAN DESDE DENTRO DE LA CARPETA SRC, Y COMENZANDO CON /
		// SE VAN MARCANDO LOS DEMAS PAQUETES.
//		URL url = getClass().getResource("/imagenes/cara.png");
//		File fileimagen = new File(url.getFile());
//		FileInputStream fis = new FileInputStream(fileimagen);
//		Image imagen = new Image(fis);
//		ImageView imageView = new ImageView(imagen);

		pLabel.setText("");
	}

	public  static void meteSaco(Stage stage, String nombredato, Object valor) {
		if (stage.getUserData() == null) {
			HashMap<String, Object> mapa = new HashMap<>();
			mapa.put(nombredato, valor);
			stage.setUserData(mapa);
		} else {
			HashMap<String, Object> mapa = (HashMap<String, Object>) stage.getUserData();
			mapa.put(nombredato, valor);
			stage.setUserData(mapa);
		}
	}

	public  static Object sacaSaco(Stage stage, String nombredato) {
		if (stage.getUserData() == null) {
			return null;
		}
		HashMap<String, Object> mapa = (HashMap<String, Object>) stage.getUserData();
		return mapa.get(nombredato);
	}

	public static void meteSimple(Node nodo, Object data) {
		getStage(nodo).setUserData(data);
	}

	public static void meteSimple(Stage stage, Object data) {
		stage.setUserData(data);
	}

	public static Object sacaSimple(Node nodo, Object data) {
		return getStage(nodo).getUserData();
	}

	public static Object sacaSimple(Stage stage, Object data) {
		return stage.getUserData();
	}

}
