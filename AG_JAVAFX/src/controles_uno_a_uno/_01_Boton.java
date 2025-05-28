package controles_uno_a_uno;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class _01_Boton extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        // Podemos crear un botón creando un objeto a partir de la clase Button
        Button btn1 = new Button("Mi Botón 1");

        // Para añadir funcionalidad al botón debemos añadir una función (lambda) al evento "setOnAction"
        btn1.setOnAction(value ->  {
            System.out.println("'Mi Botón 1 se ha pulsado!");
        });

        // Podemos obligar a mostrar todo el texto de un botón (Warping). Para ello debemos activar (true)
        // el método setWrapText()
        Button btn2 = new Button("Mi Botón 2 con un texto más largo");
        btn2.setWrapText(true);

        //Podemos añadir una imagen al lado del botón
        Image image = new Image(getClass().getResource("img/menu.png").toString());
        ImageView imageView = new ImageView(image);
        Button btn3 = new Button("Mi Botón 3", imageView);
        //Con el método setContentDisplay podemos indicar la posición de la imagen
        btn3.setContentDisplay(ContentDisplay.RIGHT);

        // Podemos indicar atajos de teclado para activar un botón. Para ello debemos activar el método
        // setMnemonicParsing(true). A la hora de indicar el texto del botón debemos indicar con el simbolo "_" la
        // tecla a pulsar. Se activará el botón al pulsar ALT + [tecla elegida]
        // ATENCIÓN: Hay que tener cuidado y no indicar la misma tecla para dos botones dentro de la misma escena.
        Button btn4 = new Button();
        btn4.setMnemonicParsing(true);
        btn4.setText("Clic_k");
        btn4.setOnAction(value ->  {
            System.out.println("Mnemonic Botón pulsado!");
        });

        primaryStage.setTitle("Experimentos con botones");
        HBox hbox = new HBox(btn1,btn2,btn3,btn4);

        Scene scene = new Scene(hbox, 900, 150);
        scene.getStylesheets().add(getClass()
                .getResource("css/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
