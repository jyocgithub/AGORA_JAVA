package controllers;

import java.io.IOException;
import java.util.ArrayList;

import application.GUT_fxBasicos;
import application.GUT_fxDialogs;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import models.PersonaConProperties;

public class EscenaPrincipalController {

	@FXML
	private Button bt_goto_2;

	@FXML
	private Button bt_volver_login;

	@FXML
	private CheckBox chk_mayusculas;

	@FXML
	private TextField txt_mensaje_para_2;
	@FXML
	private TextField txt_contador;

	@FXML
	private ListView<String> listview_principal;

	@FXML
	private RadioButton radio1_principal;

	@FXML
	private RadioButton radio2_principal;

	@FXML
	private TableView<PersonaConProperties> tableview_principal;

	@FXML
	private TextArea textarea_principal;

	@FXML
	private ToggleButton toogle1_principal;
	@FXML
	private ToggleButton toogle2_principal;

	@FXML
	private ComboBox<String> combo_principal;


	
	// Initialize() actua como el 'constructor' de la ventana, pero cuidado.
	// Si queremos acceder a los nodos antes de ninguna interaccion con el usuario,
	// podemos hacerlo desde este metodo, pero NO podemos acceder a la scene ni 
	// al stage desde aqui, pues aun no estan totalmente creados
	// Si necesitamos acceso al Stage, o Scene, podemos tenerlos como objetos static desde 
	// la clase inicial.
	// O mejor aun, usar el initialize_trasCrearStage de este ejemplo, llamado con 
	// el Platform.runLater
	@FXML
	void initialize() {
		System.out.println("INICIALIZANDO");
		txt_mensaje_para_2.setText("Hola...");
		
		Platform.runLater(() -> initialize_trasCrearStage());

		usandoTextField();
		usandoTextArea();
		usandoComboBox();
		usandoCheckBox();
		usandoButton();
		usandoToggleButton();
		usandoRadioButton();
		usandoListView();
		usandoTableView();

	}
	public void initialize_trasCrearStage() {
		Stage thisStage = GUT_fxBasicos.getStage(bt_goto_2);
		String nombre = (String) GUT_fxBasicos.sacaSaco(thisStage, "nombre");
		String contrasena = (String) GUT_fxBasicos.sacaSaco(thisStage, "contrasena");
		txt_mensaje_para_2.setText("Bienvenido " + nombre);
	}

	// =============================================================================
	public void usandoButton() {
		// asi se puede hacer un boton tipo cancelar, que se dispara tambien
		// al pulsar la tecla ESC
		bt_volver_login.setCancelButton(true);
	}

	@FXML
	void on_bt_volver_login(ActionEvent event) throws IOException {
		// RECORDAR GUARDAR EXPRESAMENTE EL FICHERO FXML ANTES DE EJECUTAR ESTOS METODOS
		GUT_fxBasicos.iniciaStage(bt_goto_2, "/vista/EscenaLogin.fxml", "NUEVO TITULO VENTANA LOGIN");
	}

	@FXML
	void on_bt_goto_2(ActionEvent event) {
		// RECORDAR GUARDAR EXPRESAMENTE EL FICHERO FXML ANTES DE EJECUTAR ESTOS METODOS
	}

	// =============================================================================
	public void usandoTextField() {
		// ===== muy parecido a un Label pero editable

		// ===== PARA CREAR UN TEXTFIELD DESDE CODIGO, no desde scenebuilder
		// TextField tfTexto = new TextField("TextField 1");

		txt_mensaje_para_2.setVisible(true);
		txt_mensaje_para_2.setDisable(false);

		if (txt_mensaje_para_2.isDisable()) {
		}
		// txt_mensaje_para_2.clear(); // PARA BORRAR EL CONTENIDO
		// txt_mensaje_para_2.copy();  // copia al portapapeles el contenido
		// txt_mensaje_para_2.paste(); // pega el contenido del portapapeles aqui

		
		// ===== intenta poner el foco en el textfield, pero esto solo vale despues del initialize
		// txt_mensaje_para_2.requestFocus(); 
		// -- si se quiere antes...usar 
		// -- (en general, vale para cualquier accion donde haya de estar stage y scene creados)
		Platform.runLater(() -> txt_mensaje_para_2.requestFocus());
		
		if (txt_mensaje_para_2.isFocused()) {
		}

		// ===== cambiamos font
		txt_mensaje_para_2.setFont(new Font("Arial", 14));

		txt_mensaje_para_2.setOnKeyPressed(k -> {

			if (k.getCode() == KeyCode.A) {
			}
			if (k.getCode() == KeyCode.COMMA) {
			}

			String s = txt_mensaje_para_2.getText();
			txt_contador.setText(s.length() + "");

		});
	}

	// =============================================================================
	public void usandoTextArea() {
		// == ADEMAS DE LO DE UN TEXTFIELD...

		// ===== PARA CREAR UN TEXTAREA DESDE CODIGO, no desde scenebuilder
		// TextArea taTexto = new TextArea();

		// ===== si queremos ponerle texto real
		// textarea_principal.setText("Texto con contenido");

		// ===== ponemos un hint, una ayuda
		textarea_principal.setPromptText("Escribe aqui el contenido");

		// ===== ponemos dimensiones preferidas
		textarea_principal.setPrefColumnCount(20);
		textarea_principal.setPrefRowCount(4);
	}

	// =============================================================================
	public void usandoComboBox() {
		// ===== PARA CREAR UN COMBOBOX DESDE CODIGO, no desde scenebuilder
		// ===== creamos los elementos que ha de tener el Comnobox
//		ComboBox<String> combo1 = new ComboBox<>(items);

		// usamos Observable pues nos obliga ComboBox.
		// Es una clase de FX que usa el patron observable,
		// que permite responder automaticamente a cambios en el contenido
		ObservableList<String> items = FXCollections.observableArrayList();
		items.addAll("Rojo", "Verde", "Azul", "Negro", "Blanco");

		combo_principal.setItems(items);
		combo_principal.getSelectionModel().select(1); // indicar valor por defecto
		int pos = combo_principal.getSelectionModel().getSelectedIndex();
		String valor = combo_principal.getSelectionModel().getSelectedItem();
		System.out.println(pos);
		System.out.println(valor);
	}

	@FXML
	void on_combo_principal_clicked(ActionEvent event) {
		System.out.println("click en el combo");
		int pos = combo_principal.getSelectionModel().getSelectedIndex();
		String valor = combo_principal.getSelectionModel().getSelectedItem();
		System.out.println(pos);
		System.out.println(valor);
	}

	// =============================================================================
	public void usandoCheckBox() {
		chk_mayusculas.setSelected(true);
		if (chk_mayusculas.isSelected()) {
			System.out.println("chk_may seleccionado");
		}
	}

	// =============================================================================
	public void usandoToggleButton() {
		ToggleGroup grupoToggle = new ToggleGroup();
		grupoToggle.getToggles().addAll(toogle1_principal, toogle2_principal);

		toogle1_principal.setSelected(true);
		if (toogle1_principal.isSelected()) {
			System.out.println("toogle1 seleccionado");
		}
	}

	// =============================================================================
	public void usandoRadioButton() {

		ToggleGroup grupoRadio = new ToggleGroup();
		grupoRadio.getToggles().addAll(radio1_principal, radio2_principal);
		radio2_principal.setSelected(true);
		if (radio2_principal.isSelected()) {
			System.out.println("radio2 seleccionado");
		}
	}

	// =============================================================================
	public void usandoListView() {

		ArrayList<String> listacoches = new ArrayList<>();
		listacoches.add("Ford");
		listacoches.add("Audi");
		listacoches.add("Ferrari");
		listacoches.add("Kia");
		listview_principal.getItems().addAll(listacoches);
		// tambien se pueden añadir directamente....
//        listview_principal.getItems().addAll("Ford", "Audi", "Ferrari", "Porsche");

		listview_principal.getSelectionModel().selectFirst();
		int pos = listview_principal.getSelectionModel().getSelectedIndex();
		String valor = listview_principal.getSelectionModel().getSelectedItem();
		System.out.println(pos);
		System.out.println(valor);
	}

	@FXML
	void on_listview_principal_clicked(MouseEvent event) {
		// RECORDAR GUARDAR TODOS LOS FICHEROS EN ECLIPSE ANTES DE EJECUTAR ESTOS
		// METODOS
		System.out.println("click en el listview");
		int pos = listview_principal.getSelectionModel().getSelectedIndex();
		String valor = listview_principal.getSelectionModel().getSelectedItem();
		System.out.println(pos);
		System.out.println(valor);
	}

	// =============================================================================
	public void usandoTableView() {
		// leemos los datos y los metemos en el modelo Observable

		// CUIDADO : la clase PersonaConProperties se podria poner como interna a esta
		// pero si se añade en un package distinto, como nosotros en el llamado 'models'
		// hay que añadir en el module-info-java (si se usa) la linea
		// exports jy.fxidealibro.models;

		ArrayList<PersonaConProperties> listapersonas = new ArrayList<>();
		listapersonas.add(new PersonaConProperties("Jacob", "Smith", "jacob.smith@example.com"));
		listapersonas.add(new PersonaConProperties("Isabella", "Johnson", "isabella.johnson@example.com"));
		listapersonas.add(new PersonaConProperties("Ethan", "Williams", "ethan.williams@example.com"));
		listapersonas.add(new PersonaConProperties("Emma", "Jones", "emma.jones@example.com"));
		listapersonas.add(new PersonaConProperties("Michael", "Brown", "michael.brown@example.com"));

		ObservableList<PersonaConProperties> modeloTablaPersonas = FXCollections.observableArrayList(listapersonas);

		// se pueden meter los elementos directamente.....
//        data = FXCollections.observableArrayList(
//                new PersonaConProperties("Jacob", "Smith", "jacob.smith@example.com"),
//                new PersonaConProperties("Isabella", "Johnson", "isabella.johnson@example.com"),
//                new PersonaConProperties("Ethan", "Williams", "ethan.williams@example.com"),
//                new PersonaConProperties("Emma", "Jones", "emma.jones@example.com"),
//                new PersonaConProperties("Michael", "Brown", "michael.brown@example.com")
//        );

		// columnas y sus cabeceras
		TableColumn<PersonaConProperties, String> colNombre = new TableColumn<>("Nombre");
		TableColumn<PersonaConProperties, String> colApellidos = new TableColumn<>("Apellidos");
		TableColumn<PersonaConProperties, String> colEmail = new TableColumn<>("Correo");
		// segunda cabecera para dos correos por ejemplo....
//        TableColumn colMail1 = new TableColumn("Personal");
//        TableColumn colMail2 = new TableColumn("Trabajo");
//        colEmail.getColumns().addAll(colMail1, colMail2);

		colNombre.setCellValueFactory(new PropertyValueFactory<PersonaConProperties, String>("nombre"));
		colApellidos.setCellValueFactory(new PropertyValueFactory<PersonaConProperties, String>("Apellidos"));
		colEmail.setCellValueFactory(new PropertyValueFactory<PersonaConProperties, String>("email"));

		colNombre.setMinWidth(100);
		colApellidos.setMinWidth(100);
		colEmail.setMinWidth(250);

		colEmail.setVisible(true); // asi podemos ocultar o mostrar columnas....

		tableview_principal.setItems(modeloTablaPersonas);
		tableview_principal.getColumns().addAll(colNombre, colApellidos, colEmail);

		// permitimos seleccionar filas
		TableView.TableViewSelectionModel<PersonaConProperties> selectionModel = tableview_principal.getSelectionModel();
		selectionModel.clearSelection(); // borramos todas las filasque hubiera seleccionado antes
		selectionModel.setSelectionMode(SelectionMode.SINGLE); // permitimos solo una fila seleccionable a la vez

		ObservableList<PersonaConProperties> selectedItems = selectionModel.getSelectedItems();

		// LISTENER DE SELECCION EN LA TABLA
		// ESTE LISTENER NO SE PUEDE AÑADIR DESDE SCENEBUILDER
		selectedItems.addListener(new ListChangeListener<PersonaConProperties>() {
			@Override
			public void onChanged(Change<? extends PersonaConProperties> change) {
				// es asi por que sabemos que solo se puede elegir una
				PersonaConProperties persona = change.getList().get(0);
				GUT_fxDialogs.mensaje("Seleccionado : " + persona.toString(), "");
			}
		});
		// -- esto es por si queremos seleccionar alguna programaticamente, pero
		// cuidado, que lanza el listener de seleccion...
		// selectionModel.select(1);

		// LISTENER DE CAMBIOS AL EDITAR LA TABLA
		// ESTE LISTENER NO SE PUEDE AÑADIR DESDE SCENEBUILDER
		tableview_principal.setEditable(true);
		colNombre.setCellFactory(TextFieldTableCell.forTableColumn());
		colNombre.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<PersonaConProperties, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<PersonaConProperties, String> t) {
				String nuevonombre = t.getNewValue();
				GUT_fxDialogs.mensaje("Nuevo nombre: " + nuevonombre, "");
				PersonaConProperties p = t.getTableView().getItems().get(t.getTablePosition().getRow());
				p.setNombre(nuevonombre);
			}
		});
	}
// =============================================================================

}
