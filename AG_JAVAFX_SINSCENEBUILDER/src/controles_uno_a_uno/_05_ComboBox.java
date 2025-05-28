package controles_uno_a_uno;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class _05_ComboBox extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Para crear un ComboBox se utiliza la clase ComboBox.
        ComboBox cb = new ComboBox();

        // Puedes añadir opciones al ComboBox con el método add()

        cb.getItems().add("Opción 1");
        cb.getItems().add("Opción 2");
        cb.getItems().add("Opción 3");

        // Un comboBox no es editable por defecto.
        // Para hacerlo editable debemos activar el método setEditable()
        cb.setEditable(true);

        // Se puede leer el valor seleccionado mediante el método getValue().
        // Si no se selecciona ninguna opción el valor que se devuelve es null
        // También se puede leer el índice de la opción elegida con el método getSelectionModel().GetSelectedIndex()
        Button btn = new Button("Comprobar");
        btn.setOnAction(value ->  {
            System.out.print("Opción elegida Número: " + cb.getSelectionModel().getSelectedIndex()+ " / ");
            System.out.println("Con el valor seleccionado: " + cb.getValue());
        });

        // Para que se pueda visualizar un ComboBox es necesario incluirlo en algún tipo de plantilla de lo contrario
        // no se visualizará
        HBox hbox = new HBox(cb, btn);
        Scene scene = new Scene(hbox);
        scene.getStylesheets().add(getClass()
                .getResource("css/styles.css").toExternalForm());
        primaryStage.setTitle("Experimento con comboBox");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
