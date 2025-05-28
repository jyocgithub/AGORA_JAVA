package controles_uno_a_uno;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class _10_ToolTip extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Un Tooltip es un mensaje que aparece en pantalla cuando se posiciona el ratón encima de algún elemento.
        // Para crear un Tooltip usamos la clase Tooltip

        Tooltip tp1 = new Tooltip("Introduce un nombre de usuario de al menos 4 caracteres");
        tp1.setFont(new Font("Arial",14));

        // Podemos añadir un Tooltip a cualquier elemento de la interfaz gráfica
        Label l1 = new Label("USUARIO:");
        TextField tf1 = new TextField();
        l1.setTooltip(tp1);
        tf1.setTooltip(tp1);

        // Podemos añadir un gráfico al tooltip con el método setGraphic().
        Tooltip tp2 = new Tooltip("Esto es un tooltip con un gráfico");
        tp2.setFont(new Font("Arial", 14));
        ImageView iv = new ImageView(new Image(getClass().getResourceAsStream("img/eye.png")));
        iv.setPreserveRatio(true);
        iv.setFitWidth(50);
        tp2.setGraphic(iv);

        Label l2 = new Label("CONTRASEÑA:");
        l2.setTooltip(tp2);
        TextField tf2 = new TextField();
        tf2.setTooltip(tp2);

        GridPane tabla = new GridPane();
        tabla.addRow(0,l1,tf1);
        tabla.addRow(1,l2,tf2);

        Scene scene = new Scene(tabla);
        scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());

        primaryStage.setTitle("Exerimento con Tooltip");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
