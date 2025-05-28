package controles_uno_a_uno;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _07_TextField extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Para crear objetos de tipo TextField utilizamos la clase TextField.
        TextField tf1 = new TextField();

        // Podemos "escribir" cualquier texto en un TextField con el método setText().
        tf1.setText("Valor por defecto");

        // Podemos establecer un texto que desaparecerá cuando el usuario empiece a escribir en el TextField
        TextField tf2 = new TextField();
        tf2.setPromptText("Buscar ...");

        // Podemos obtener el valor introducir en el TExtField con el método getText() que devolverá siempre un String.
        Button btn = new Button("Pulsa aquí");
        btn.setOnAction(action -> {
            System.out.println(tf1.getText());
        });

        VBox vBox = new VBox(tf1,tf2, btn);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox);
        scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());
        primaryStage.setTitle("Experimentos con TextField");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
