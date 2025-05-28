package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;

import com.example.ag_fx_sin_scenebuilder.utils.AUXFxDialogs;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Persona;

public class ComponentesApp extends Application {

	private Button btAceptar, btCancelar;
	private Stage stage;
	private ComboBox<String> combo1;
	private Label label1;
	private TextField textField1;
	private TextArea taTexto;
	private Text text1;
	private CheckBox chkManzana, chkPera;
	private ToggleButton tbford, tbaudi, tbferrari, tbporsche;
	private RadioButton rbford, rbaudi, rbferrari, rbporsche;
	private ToggleGroup grupoToggleCoches, grupoRadioCoches;
	private ListView<String> lvCoches;
	private TableView table;
	private ObservableList<Persona> modeloTablaPersonas;
	private ArrayList<Persona> listapersonas;

	public static void main(String[] args) {
//		Application.launch(args);
		launch(args);
	}

	@Override
	public void start(Stage stage) throws FileNotFoundException {
		this.stage = stage;
		inicializar();
		listeners();
	}

	public void inicializar() throws FileNotFoundException {
		// ROOT ----------------------
		VBox root = new VBox();
//		root.autosize();             // expande hasta llegar a su padre.
		root.setMinSize(800, 800); // define un mínimo tamaño

		// CONTROLES --------------------
		usandoText();
		usandoLabel();
		usandoTextField();
		usandoTextArea();
		usandoComboBox();
		usandoButton();
		usandoCheckBox();
		usandoToggleButton();
		usandoRadioButton();
		usandoListView();
		usandoTableView();

		// SCENE ---------------------
		Scene scene = new Scene(root, 800, 800);
		// solo si aplicamos estilos css desde un fichero externo
		// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		// METER UNOS DENTRO DE OTROS Y MOSTRAR
		root.getChildren().add(label1);
		root.getChildren().add(textField1);
		root.getChildren().add(taTexto);
		root.getChildren().add(text1);
		root.getChildren().add(btAceptar);
		root.getChildren().add(btCancelar);
		root.getChildren().add(combo1);
		root.getChildren().addAll(chkManzana, chkPera);
		root.getChildren().addAll(tbaudi, tbferrari, tbporsche, tbford);
		root.getChildren().addAll(rbford, rbaudi, rbferrari, rbporsche);
		root.getChildren().add(lvCoches);
		root.getChildren().add(table);

		// STAGE --------------
		// poner posicion al stage
		stage.setX(100);
		stage.setY(200);
		// o centrarlo en la pantalla, pero ello se ha de hacer tras el SHOW()

		// poner tamaño al stage
		stage.setHeight(800);
		stage.setWidth(800);
		// poner titulo al stage
		stage.setTitle("Ventana Ejemplo JavaFX");

		stage.setScene(scene);
		stage.show();

		centrarStage(stage);
	}

	// *******************************************************************
	// ******************** CONTROLES ****************************
	// *******************************************************************

	public void usandoText() {
		text1 = new Text("Text 1");
	}

	public void usandoLabel() throws FileNotFoundException {

		// ===== creamos label con un texto
		label1 = new Label("Texto inicial");

		// ===== consultamos su texto
		String texto = label1.getText();

		// ===== cambiamos texto
		// label1.setText("Nuevo texto");
	
		
		// ===== accedemos a un recurso de nuestro directorio de recursos
		// ESTE CASO ES SIN USAR MAVEN, POR LO QUE NO HAY UNA CARPETA PROPIA DE RECURSOS
		// AQUI RECURSOS SE NOMBRAN DESDE DENTRO DE LA CARPETA SRC, Y COMENZANDO CON /
		// SE VAN MARCANDO LOS DEMAS PAQUETES.
		// USAR GETRESOURCE() PARA SACAR UNA URL Y CON ELLA SE USAN FILE ,
		// FILEINPUTSTREAM...
		URL url = getClass().getResource("/imagenes/coche.png");
		File fileimagen = new File(url.getFile());

// otras formas
//		GUT_fxBasicos.ponImagen("/imagenes/cara.png", label1);
//		Image img = new Image("/imagenes/coche.png");
//		ImageView view = new ImageView(img);
//		view.setFitHeight(80);
//		view.setPreserveRatio(true);
//		label1.setGraphic(view);
//		
		// ===== creamos label con un texto y una imagen
		// primero creamos un imageview para meterlo en el Label
		FileInputStream fis = new FileInputStream(fileimagen);
		Image imagen = new Image(fis);
		ImageView imageView = new ImageView(imagen);
		// creamos label con un texto y el imageview ya creado
		label1 = new Label("My Label", imageView);

		// ===== cambiamos font
		label1.setFont(new Font("Arial", 24));

	}

	public void usandoTextField() {
		// ===== muy parecido a un Label
		textField1 = new TextField("TextField 1");
	}

	public void usandoTextArea() {
		// ===== creamos TextArea vacio
		taTexto = new TextArea();

		// ===== si queremos ponerle texto real
		// taTexto.setText("Texto con contenido");

		// ===== ponemos un hint, una ayuda
		taTexto.setPromptText("Escribe aqui el contenido");

		// ===== ponemos dimensiones preferidas
		taTexto.setPrefColumnCount(20);
		taTexto.setPrefRowCount(4);
	}

	public void usandoComboBox() {
		// ===== creamos los elementos que ha de tener el Comnobox
		// usamos Observable pues nos obliga ComboBox.
		// Es una clase de FX que usa el patron observable,
		// que permite responder automaticamente a cambios en el contenido
		ObservableList<String> items = FXCollections.observableArrayList();
		items.addAll("Rojo", "Verde", "Azul", "Negro", "Blanco");

		combo1 = new ComboBox<>(items);
		combo1.getSelectionModel().select(1); // indicar valor por defecto

	}

	public void usandoCheckBox() {

		// Create a CheckBox to support only two states
		chkManzana = new CheckBox("Manzana");
		// Create a CheckBox to support three states
		chkPera = new CheckBox("Pera");

	}

	public void usandoButton() {
		btAceptar = new Button("Boton 1");
		btCancelar = new Button("Boton 1");

		// asi se puede hacer un boton tipo cancelar, que se dispara tambien
		// al pulsar la tecla ESC
		btCancelar.setCancelButton(true);

	}

	public void usandoToggleButton() {
		tbford = new ToggleButton("Ford");
		tbaudi = new ToggleButton("Audi");
		tbferrari = new ToggleButton("Ferrari");
		tbporsche = new ToggleButton("Porsche");

		grupoToggleCoches = new ToggleGroup();
		grupoToggleCoches.getToggles().addAll(tbford, tbaudi, tbferrari, tbporsche);

	}

	public void usandoRadioButton() {
		rbford = new RadioButton("Ford");
		rbaudi = new RadioButton("Audi");
		rbferrari = new RadioButton("Ferrari");
		rbporsche = new RadioButton("Porsche");

		grupoRadioCoches = new ToggleGroup();
		grupoRadioCoches.getToggles().addAll(rbford, rbaudi, rbferrari, rbporsche);

	}

	public void usandoListView() {

		lvCoches = new ListView<>();
		ArrayList<String> listacoches = new ArrayList<>();
		listacoches.add("Ford");
		listacoches.add("Audi");
		listacoches.add("Ferrari");
		listacoches.add("Kia");
		lvCoches.getItems().addAll(listacoches);
		// tambien se pueden añadir directamente....
//        lvCoches.getItems().addAll("Ford", "Audi", "Ferrari", "Porsche");

		lvCoches.getSelectionModel().selectFirst();

	}

	public void usandoTableView() {
		// leemos los datos y los metemos en el modelo Observable

		// CUIDADO : la clase Persona se podria poner como interna a esta
		// pero si se añade en un package distinto, como nosotros en el lalmado 'models'
		// hay que añadir en el module-info-java la linea
		// exports jy.fxidealibro.models;

		listapersonas = new ArrayList<>();
		listapersonas.add(new Persona("Jacob", "Smith", "jacob.smith@example.com"));
		listapersonas.add(new Persona("Isabella", "Johnson", "isabella.johnson@example.com"));
		listapersonas.add(new Persona("Ethan", "Williams", "ethan.williams@example.com"));
		listapersonas.add(new Persona("Emma", "Jones", "emma.jones@example.com"));
		listapersonas.add(new Persona("Michael", "Brown", "michael.brown@example.com"));
		modeloTablaPersonas = FXCollections.observableArrayList(listapersonas);

		// si no estan en un arraylist........
//        data = FXCollections.observableArrayList(
//                new Persona("Jacob", "Smith", "jacob.smith@example.com"),
//                new Persona("Isabella", "Johnson", "isabella.johnson@example.com"),
//                new Persona("Ethan", "Williams", "ethan.williams@example.com"),
//                new Persona("Emma", "Jones", "emma.jones@example.com"),
//                new Persona("Michael", "Brown", "michael.brown@example.com")
//        );

		table = new TableView();

		// columnas y sus cabeceras
		TableColumn colNombre = new TableColumn("Nombre");
		TableColumn colApellidos = new TableColumn("Apellidos");
		TableColumn colEmail = new TableColumn("Correo");

		// segunda cabecera
//        TableColumn colMail1 = new TableColumn("Personal");
//        TableColumn colMail2 = new TableColumn("Trabajo");
//        colEmail.getColumns().addAll(colMail1, colMail2);

		colNombre.setMinWidth(100);
		colApellidos.setMinWidth(100);
		colEmail.setMinWidth(250);

		colNombre.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));
		colApellidos.setCellValueFactory(new PropertyValueFactory<Persona, String>("Apellidos"));
		colEmail.setCellValueFactory(new PropertyValueFactory<Persona, String>("email"));
		colEmail.setVisible(true); // asi podemos ocultar columnas....

		table.setItems(modeloTablaPersonas);
		table.getColumns().addAll(colNombre, colApellidos, colEmail);

		// permitimos seleccionar filas
		TableView.TableViewSelectionModel<Persona> selectionModel = table.getSelectionModel();
		selectionModel.clearSelection(); // borramos todox lo que hubiera seleccionado antes
		selectionModel.setSelectionMode(SelectionMode.SINGLE); // solo una fila seleccionable a la vez
		ObservableList<Persona> selectedItems = selectionModel.getSelectedItems();

		selectedItems.addListener(new ListChangeListener<Persona>() {
			@Override
			public void onChanged(Change<? extends Persona> change) {
				Persona persona = change.getList().get(0); // es asi por que sabemos que solo se puede elegir una
															// persona
				AUXFxDialogs.mensaje("Selecionado : " + persona.toString(),"");
			}
		});
		selectionModel.select(1); // esto es por si queremos seleccionar alguna programaticamente

		// editando la tabla
		table.setEditable(true);
		colNombre.setCellFactory(TextFieldTableCell.forTableColumn());
		colNombre.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Persona, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Persona, String> t) {
				String nuevonombre = t.getNewValue();
				AUXFxDialogs.mensaje("Nuevo nombre: " + nuevonombre,"");
				Persona p = t.getTableView().getItems().get(t.getTablePosition().getRow());
				p.setNombre(nuevonombre);
				// todox en una linea
				// ((Persona)
				// t.getTableView().getItems().get(t.getTablePosition().getRow())).setNombre(t.getNewValue());
			}
		});

	}

	public void agregarPersona(Persona persona) {
		modeloTablaPersonas.add(new Persona(persona.getNombre(), persona.getApellidos(), persona.getEmail()));

	}

	public void listeners() {
		// --------- LISTENERS DE BUTTONS

		btAceptar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				AUXFxDialogs.mensaje("Has pinchao en el boton Aceptar","");

			}
		});

		btCancelar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				AUXFxDialogs.mensaje("Has pinchao en el boton CANCELAR","");
			}
		});

		// --------- LISTENERS DE COMBOS
		combo1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				AUXFxDialogs.mensaje("Nueva Selección: " + combo1.getValue(),"");
			}
		});

		combo1.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				AUXFxDialogs.mensaje("Viendo cambios, has pasado de : " + oldValue + " a  " + newValue,"");
			}
		});

		// --------- LISTENERS DE CHECKBOX
		// Listener de chkManzana
		chkManzana.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> ov, final Boolean value, final Boolean newValue) {
				if (newValue != null && newValue) {
					AUXFxDialogs.mensaje("Has marcado MANZANA","");
				} else {
					AUXFxDialogs.mensaje("Has desmarcado MANZANA","");
				}
			}
		});
		// Listener de chkPera
		chkPera.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> ov, final Boolean value, final Boolean newValue) {
				if (newValue != null && newValue) {
					AUXFxDialogs.mensaje("Has marcado PERA","");
				} else {
					AUXFxDialogs.mensaje("Has desdesmarcado MANZANA","");
				}
			}
		});

		// Listaner de ToogleGroup
		grupoToggleCoches.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> ov, final Toggle toggle, final Toggle new_toggle) {
				String toggleBtn = ((ToggleButton) new_toggle).getText();
				AUXFxDialogs.mensaje("Has elegido " + toggleBtn,"");
			}
		});

		// Listaner de RadioGroup
		grupoRadioCoches.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> ov, final Toggle toggle, final Toggle new_toggle) {
				String radioBtn = ((RadioButton) new_toggle).getText();
				AUXFxDialogs.mensaje("Has elegido " + radioBtn,"");
			}
		});

		// Listaner de ListView
		lvCoches.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
				AUXFxDialogs.mensaje("Has pinchao en " + newValue,"");
			}
		});

		// --------- LISTENERS DE CON LAMBDA
//		btAceptar.setOnAction(e ->AUXFxDialogs.mensaje("Has pinchao en el boton Aceptar"));

//		combo1.setOnAction(e -> AUXFxDialogs.mensaje("Nueva Selección: " + combo1.getValue()));

//		combo1.valueProperty().addListener((ov, oldValue, newValue) -> {
//			AUXFxDialogs.mensaje("Viendo cambios, has pasado de : " + oldValue + " a  "+ newValue);
//		});

	}

	public void centrarStage(Stage pStage) {
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		pStage.setX((primScreenBounds.getWidth() - pStage.getWidth()) / 2);
		pStage.setY((primScreenBounds.getHeight() - pStage.getHeight()) / 2);

	}

}
