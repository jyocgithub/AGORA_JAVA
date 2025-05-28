package controles_uno_a_uno;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _04_CheckBox extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Creamos un CheckBox a través de la clase CheckBox
        CheckBox cb1 = new CheckBox("Off");

        // Puedes leer el estado del Checkbox mediante el método isSelected()
        cb1.setOnAction(value ->  {
            if (cb1.isSelected()) {
                cb1.setText("On");
            } else {
                cb1.setText("Off");
            }
        });

        // Un checkbox puede estar en un estado indeterminado que no es ni verdadero ni falso
        CheckBox cb2 = new CheckBox("Indefinido");
        cb2.setAllowIndeterminate(true);

        // Podemos acceder desde otros componentes al valor del checkBox
        Button btn = new Button("Comprobar");
        btn.setOnAction(value ->  {
            if (cb2.isIndeterminate()) {
                System.out.println("Esta INDETERMINADO");
            } else if (cb2.isSelected()) {
                System.out.println("Esta ACTIVADO");
            } else {
                System.out.println("Esta DESACTIVADO");
            }
        });

        primaryStage.setTitle("Experimentos con CheckBox");
        VBox vBox = new VBox(cb1, cb2, btn);
        vBox.setAlignment(Pos.CENTER_LEFT);

        Scene scene = new Scene(vBox, 350, 150);
        scene.getStylesheets().add(getClass()
                .getResource("css/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
