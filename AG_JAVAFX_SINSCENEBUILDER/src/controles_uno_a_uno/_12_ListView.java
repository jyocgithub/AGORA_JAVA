package controles_uno_a_uno;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _12_ListView extends Application {
    int i = 3;
    @Override
    public void start(Stage primaryStage) throws Exception {
        // ListView nos permite elegir una o más opciones de una lista predefinida de opciones.
        // Para crear un ListView debemos usar la clase ListView
        ListView <String> listView = new ListView<String>();

        // Para añadir elementos usamos el método add()
        listView.getItems().add("Elemento 1");
        listView.getItems().add("Elemento 2");

        Button btn = new Button("Añadir elemento");

        btn.setOnAction(event -> {
            listView.getItems().add("Elemento " + i);
            this.i++;
        });

        // Podemos leer el elemento seleccionado con los métodos getSelectionModel().getSlectedIndice()
        Button btn1 = new Button("Leer Seleccióm");

        btn1.setOnAction(event -> {
                System.out.println( "Posición: " + listView.getSelectionModel().getSelectedIndex() + " - " +
                                     "Valor: " + listView.getSelectionModel().getSelectedItem());
        });

        HBox hbox = new HBox(btn, btn1);
        VBox vbox = new VBox(listView,hbox);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 300, 300);
        primaryStage.setTitle("Experimento con ListView");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
