package controles_uno_a_uno;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class _03_RadioButton extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Podemos crear objetos RadioButton utilizando la clase RadioButton
        RadioButton rb1 = new RadioButton("Izquierda");
        RadioButton rb2 = new RadioButton("Derecha");
        RadioButton rb3 = new RadioButton("Arriba");
        RadioButton rb4 = new RadioButton("Abajo");

        // Mediante el método isSelected() podemos saber si el RadioButton está seleccionado o no
        ToggleButton rb5 = new RadioButton("OFF");
        rb5.setOnAction(event -> {
            if(rb5.isSelected())
                rb5.setText("ON");
            else
                rb5.setText("OFF");
        });

        // Puedes agrupar los RadioButtons mediante un objeto de tipo ToggleGroup.
        // Un ToggleGroup solo permite que uno de los RadioButtons del grupo pueda estar activado
        ToggleGroup radioGroup = new ToggleGroup();

        rb1.setToggleGroup(radioGroup);
        rb2.setToggleGroup(radioGroup);
        rb3.setToggleGroup(radioGroup);
        rb4.setToggleGroup(radioGroup);

        HBox hbox = new HBox(rb1, rb2, rb3, rb4,rb5);

        Scene scene = new Scene(hbox);
        primaryStage.setTitle("Experimento con RadioButton");
        primaryStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
