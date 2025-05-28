package controles_uno_a_uno;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _08_PasswordField extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Un passwordField es un TextField en el que no se vé lo que se escribe
        // Para crear un objeto PasswordField usamos la clase PasswordField.
        PasswordField pf = new PasswordField();

        // Puedes leer el valor introducido con el método getText(). Siempre obtendremos un objeto de tipo String
        Button btn = new Button("Leer Password");
        btn.setOnAction(action -> {
            System.out.println(pf.getText());
        });
        // Tener un checkbox para mostrar la contraseña no está definido en este tipo de componente pero podemos
        // simular su comportamiento utilizando un TextField. Cuando esté marcado se mostrará el TextField y cuando
        // esté desmarcado en PasswordField
        TextField tf = new TextField();
        tf.setVisible(false);

        CheckBox cb = new CheckBox("Mostrar");
        cb.setOnAction(event -> {
            if (cb.isSelected()) {
                tf.setText(pf.getText());
                pf.setVisible(false);
                tf.setVisible(true);
            } else {
                pf.setText(tf.getText());
                pf.setVisible(true);
                tf.setVisible(false);
            }
        });

        StackPane sp = new StackPane(pf,tf);
        VBox vBox = new VBox(sp,cb, btn);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox);
        scene.getStylesheets().add(getClass()
                .getResource("css/styles.css").toExternalForm());
        primaryStage.setTitle("Experimentos con PasswordField");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
