package controles_uno_a_uno;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _00_Label extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Puedes crear una etiqueta a través de la clase Label.
        Label l1 = new Label("Mi etiqueta");

        //A una etiqueta le podemos añadir una imagen
        Image imagen = new Image(getClass().getResource("img/icon_hand.png").toString());
        ImageView iv = new ImageView(imagen);
        Label l2 = new Label("Stop", iv);

        VBox hb = new VBox(l1, l2);
        Scene scene = new Scene(hb,300,300);
        scene.getStylesheets().add(getClass()
                .getResource("css/styles.css").toExternalForm());
        primaryStage.setTitle("Experimento con Etiquetas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
