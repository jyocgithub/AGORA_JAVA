package controles_uno_a_uno;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class _02_ToggleButton extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Puedes crear un ToggleButtonYou a través de la clase ToggleButton.

        ToggleButton tb1 = new ToggleButton("Izquierda");
        ToggleButton tb2 = new ToggleButton("Derecha");
        ToggleButton tb3 = new ToggleButton("Arriba");
        ToggleButton tb4 = new ToggleButton("Abajo");

        // Mediante el método isSelected() podemos saber si el ToggleButton está pulsado o no
        ToggleButton tb5 = new ToggleButton(("OFF"));
        tb5.setOnAction(event -> {
            if(tb5.isSelected())
                tb5.setText("ON");
            else
                tb5.setText("OFF");
        });

        // Puedes unir varios ToggleButton a través de un objeto del tipo ToggleGroup.
        // Dentro de un ToggleGroup solo un ToggleButton puede estar activado en cada momento.
        ToggleGroup toggleGroup = new ToggleGroup();
        tb1.setToggleGroup(toggleGroup);
        tb2.setToggleGroup(toggleGroup);
        tb3.setToggleGroup(toggleGroup);
        tb4.setToggleGroup(toggleGroup);

        HBox hbox = new HBox(tb1, tb2, tb3, tb4,tb5);

        Scene scene = new Scene(hbox);
        scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());
        primaryStage.setTitle("Experimento con ToggleButton");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
