package controles_uno_a_uno;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _09_TextArea extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Para crear un objeto TextArea utilizamos la clase TextArea.
        TextArea ta = new TextArea();

        // Podemos leer el valor de TextArea con el método getText().
        // Podemos establecer un nuevo valor con el método setText().
        Button btn = new Button("Pulsa para obtener el texto introducido");
        btn.setOnAction(action -> {
            System.out.println(ta.getText());
            ta.setText("Nuevo texto almacenado");
        });


        VBox vbox = new VBox(ta, btn);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox);
        scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());
        primaryStage.setTitle("Experimento con TextArea");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
