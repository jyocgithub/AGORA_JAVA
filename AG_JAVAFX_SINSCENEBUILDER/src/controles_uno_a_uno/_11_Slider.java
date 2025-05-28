package controles_uno_a_uno;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class _11_Slider extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Text text = new Text("Mueve el slider y verás ...");

        // Para crear un objeto Slider debemos utilizar la clase Slider de JavaFX.
        // El constructor del Slider requiere tres parámetros. El valor mínimo, el máximo y el valor inicial
        Slider slider = new Slider(0, 100, 50);

        // Para obtener el valor indicado por el Slider usamos el método getValue()
        // Para controlar los cambios realizados en el Slider necesitamos un ChangeListener
        // Más info en ... https://code.makery.ch/blog/javafx-8-event-handling-examples/
        slider.valueProperty().addListener((observable, oldValue, newValue) ->  {
            System.out.println("The slider old value is " + oldValue + " and the new value is " + newValue);
            text.setText("The slider value is " + observable.getValue());  // o slider.getValue()
        });

        // Puedes hacer que el Slider muestre unas marcas cuando se pinta en pantalla
        // Para hacerlo debemos activar el método setShowTickMarks().
        Slider slider1 = new Slider (0,100,20);
        slider1.setShowTickMarks(true);

        // Puedes hacer que el Slider se ajuste a unos valores predeterminados usando el método setSnapToTicks()
        slider1.setSnapToTicks(true);
        slider1.valueProperty().addListener((observable, oldValue, newValue) ->  {
            System.out.println("The slider old value is " + oldValue + " and the new value is " + newValue);
            text.setText("The slider value is " + observable.getValue());  // o slider.getValue()
        });


        // Puedes mostrar los números del Slider con el método setShowTickLabels().
        Slider slider2 = new Slider(0,100,0);
        slider2.setShowTickLabels(true);

        VBox vBox = new VBox(slider, slider1, slider2, text);

        Scene scene = new Scene(vBox, 800, 200);
        scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Experimento con Slider");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
