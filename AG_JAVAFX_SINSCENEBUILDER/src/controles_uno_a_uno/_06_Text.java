package controles_uno_a_uno;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class _06_Text extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Podemos crear un objeto "texto" a través de la clase Text
        Text text1 = new Text("This is a JavaFX text.");

        // Una vez establecido el contenido del texto podemos cambiarlo con el método setText()
        text1.setText("Esto es un texto en JavaFX");

        // Podemos cambiar el tipo de fuente con el método setFont()
        // La fuente debe estar instalada en el equipo y se puede determinar tanto el tamaño como el grosor de la misma.
        text1.setFont(Font.font("Arial", FontWeight.BOLD, 36));

        // También se puede cambiar el color de la fuente.
        text1.setFill(Color.YELLOW);
        text1.setStroke(Color.GREEN);

        // Podemos utilizar cualquier otra fuente no instalada en el equipo, pero debemos tener el fichero de la fuente
        // El texto cambia de fuente cuando se hace clic con el ratón
        Text text2 = new Text("Nuevo tipo de letra");
        text2.setOnMouseClicked(event -> {
            text2.setFont(Font.loadFont(getClass().getResource("fonts/Tangerine-Regular.ttf").toExternalForm(),45));
        });

        Scene escena = new Scene(new VBox(text1,text2), 500,100);

        primaryStage.setScene(escena);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
