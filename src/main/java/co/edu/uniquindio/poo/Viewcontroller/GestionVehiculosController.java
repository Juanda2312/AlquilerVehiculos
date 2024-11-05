package co.edu.uniquindio.poo.Viewcontroller;

/**
 * Sample Skeleton for 'GestionVehiculos.fxml' Controller Class
 */

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.app.App;
import co.edu.uniquindio.poo.controllers.VehiculoController;
import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Caja;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class GestionVehiculosController {
    App app;
    VehiculoController vehiculoController;
    ObservableList<Vehiculo> listaVehiculos = FXCollections.observableArrayList();
    ObservableList<String> tipovehiculo = FXCollections.observableArrayList("Auto", "Moto", "Camioneta");
    ObservableList<Caja> tipocaja = FXCollections.observableArrayList(Caja.MANUAL, Caja.AUTOMATICO);
    Vehiculo vehiculoseleccionado;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="comboboxtipovehiculo"
    private ComboBox<String> comboboxtipovehiculo; // Value injected by FXMLLoader

    @FXML // fx:id="columnmarca"
    private TableColumn<Vehiculo, String> columnmarca; // Value injected by FXMLLoader

    @FXML // fx:id="btnagregarvehiculo"
    private Button btnagregarvehiculo; // Value injected by FXMLLoader

    @FXML // fx:id="btneliminarVehiculo"
    private Button btneliminarVehiculo; // Value injected by FXMLLoader

    @FXML // fx:id="btnactualizarvehiculo"
    private Button btnactualizarvehiculo; // Value injected by FXMLLoader

    @FXML // fx:id="btnregresar"
    private Button btnregresar; // Value injected by FXMLLoader

    @FXML // fx:id="columnmodelo"
    private TableColumn<Vehiculo, String> columnmodelo; // Value injected by FXMLLoader

    @FXML // fx:id="txtaño"
    private TextField txtaño; // Value injected by FXMLLoader

    @FXML // fx:id="columncaja"
    private TableColumn<Vehiculo, String> columncaja; // Value injected by FXMLLoader

    @FXML // fx:id="txtpuertas"
    private TextField txtpuertas; // Value injected by FXMLLoader

    @FXML // fx:id="titulocarga"
    private Text titulocarga; // Value injected by FXMLLoader

    @FXML // fx:id="txtmatricula"
    private TextField txtmatricula; // Value injected by FXMLLoader

    @FXML // fx:id="titulopuertas"
    private Text titulopuertas; // Value injected by FXMLLoader

    @FXML // fx:id="columnpuertas"
    private TableColumn<Vehiculo, String> columnpuertas; // Value injected by FXMLLoader

    @FXML // fx:id="columncarga"
    private TableColumn<Vehiculo, String> columncarga; // Value injected by FXMLLoader

    @FXML // fx:id="tblvehiculos"
    private TableView<Vehiculo> tblvehiculos; // Value injected by FXMLLoader

    @FXML // fx:id="txtmarca"
    private TextField txtmarca; // Value injected by FXMLLoader

    @FXML // fx:id="txtcarga"
    private TextField txtcarga; // Value injected by FXMLLoader

    @FXML // fx:id="columnmatricula"
    private TableColumn<Vehiculo, String> columnmatricula; // Value injected by FXMLLoader

    @FXML // fx:id="txtmodelo"
    private TextField txtmodelo; // Value injected by FXMLLoader

    @FXML // fx:id="columnanio"
    private TableColumn<Vehiculo, String> columnanio; // Value injected by FXMLLoader

    @FXML // fx:id="titulocaja"
    private Text titulocaja; // Value injected by FXMLLoader

    @FXML // fx:id="comboboxcaja"
    private ComboBox<Caja> comboboxcaja; // Value injected by FXMLLoader

    /**
     * Actualiza un vehiculo de la lista de vehiculos
     * 
     * @param event
     */
    @FXML
    void actualizarvehiculoAction(ActionEvent event) {
        try {
            Vehiculo vehiculoseleccionado = tblvehiculos.getSelectionModel().getSelectedItem();
            if (vehiculoseleccionado != null) {
                if (validarDatos(txtmatricula.getText(), txtmarca.getText(), txtmodelo.getText(), txtaño.getText(),
                        txtpuertas.getText(), comboboxcaja.getSelectionModel().getSelectedItem(), txtcarga.getText())) {// Valida
                                                                                                                        // los
                                                                                                                        // datos
                    Integer puertas = 0;
                    float carga = 0;
                    if (!txtpuertas.getText().isEmpty()) {// Verifica si el campo de texto de puertas tiene un dato para
                                                          // actualizar un auto
                        puertas = Integer.parseInt(txtpuertas.getText());// Convierte el texto a entero
                    }
                    if (!txtcarga.getText().isEmpty()) {// Verifica si el campo de texto de carga tiene un dato para
                                                        // actualizar una camioneta
                        carga = Float.parseFloat(txtcarga.getText());// Convierte el texto a float
                    }
                    String resultado = vehiculoController.ActualizarVehiculo(vehiculoseleccionado,
                            txtmatricula.getText(), txtmarca.getText(), txtmodelo.getText(), txtaño.getText(), puertas,
                            comboboxcaja.getSelectionModel().getSelectedItem(), carga);
                    mostrarmensaje("Actualizacion de Vehiculo", "Actualizar Vehiculo", resultado,
                            AlertType.INFORMATION);
                    if (resultado.equals("El vehiculo ha sido actualizado")) {
                        tblvehiculos.refresh();// Refresca la tabla
                        limpiarseleccion();// Limpia los campos de texto y la seleccion de la tabla de vehiculos
                    }
                }
            } else {
                mostrarmensaje("Actualizacion de Vehiculo", "Actualizar Vehiculo", "Seleccione un vehiculo de la tabla",
                        AlertType.WARNING);
            }
        } catch (Exception e) {// En caso de que el usuario quiera actualizar la informacion de un vehiculo
                               // cambiando el tipo de vehiculo los atributos unicos se pondran en un valor por
                               // defecto sin soltar un nullpointerException

        }
    }

    /**
     * Agrega un vehiculo a la lista de vehiculo
     * 
     * @param event
     */
    @FXML
    void agregarvehiculoAction(ActionEvent event) {
        String matricula = txtmatricula.getText();
        String marca = txtmarca.getText();
        String modelo = txtmodelo.getText();
        String año = txtaño.getText();
        String puerta = txtpuertas.getText();
        Caja caja = comboboxcaja.getSelectionModel().getSelectedItem();
        String carga = txtcarga.getText();
        boolean validacion = validarDatos(matricula, marca, modelo, año, puerta, caja, carga);// Valida los datos
        if (validacion) {
            String respuesta = "";
            if (!puerta.isEmpty()) {// Si hay informacion en el campo de texto de puertas crea un auto
                Auto auto = new Auto(matricula, marca, modelo, año, Integer.parseInt(puerta));
                respuesta = vehiculoController.AgregarVehiculo(auto);
                if (respuesta.equals("El vehiculo ha sido agregado")) {
                    listaVehiculos.add(auto);
                    limpiarseleccion();// Limpia los campos de texto y la seleccion de la tabla de vehiculos
                }
            }
            if (caja != null) {// Si se selecciona una opcion en la combobox de caja se crea una moto
                Moto moto = new Moto(matricula, marca, modelo, año, caja);
                respuesta = vehiculoController.AgregarVehiculo(moto);
                if (respuesta.equals("El vehiculo ha sido agregado")) {
                    listaVehiculos.add(moto);
                    limpiarseleccion();// Limpia los campos de texto y la seleccion de la tabla de vehiculos
                }
            }
            if (!carga.isEmpty()) {// Si hay informacion en el campo de texto de Carga crea una camioneta
                Camioneta camioneta = new Camioneta(matricula, marca, modelo, año, Float.parseFloat(carga));
                respuesta = vehiculoController.AgregarVehiculo(camioneta);
                if (respuesta.equals("El vehiculo ha sido agregado")) {
                    listaVehiculos.add(camioneta);
                    limpiarseleccion();// Limpia los campos de texto y la seleccion de la tabla de vehiculos
                }
            }
            mostrarmensaje("Agregar Vehiculo", "Verificación", respuesta, AlertType.INFORMATION);
        }
    }

    /**
     * Elimina un vehiculo de la lista de vehiculos
     * 
     * @param event
     */
    @FXML
    void eliminarvehiculoAction(ActionEvent event) {
        Vehiculo vehiculoseleccionado = tblvehiculos.getSelectionModel().getSelectedItem();
        if (vehiculoseleccionado != null) {
            String resultado = vehiculoController.EliminarVehiculo(vehiculoseleccionado);
            mostrarmensaje("Eliminacion de Vehiculo", "Eliminar Vehiculo", resultado, AlertType.INFORMATION);
            if (resultado.equals("El vehiculo ha sido eliminado")) {
                listaVehiculos.remove(vehiculoseleccionado);
                limpiarseleccion();// Limpia los campos de texto y la seleccion de la tabla de vehiculos
            }
        } else {// Si no hay seleccionado ningun vehiculo en la tabla suelta este mensaje
            mostrarmensaje("Eliminacion de Vehiculo", "Eliminar Vehiculo", "Seleccione un vehiculo de la tabla",
                    AlertType.WARNING);
        }
    }

    /**
     * Abre la ventana principal
     * 
     * @param event
     */
    @FXML
    void RegresarAction(ActionEvent event) {
        app.openViewPrincipal();
    }

    /**
     * Al seleccionar el tipo de vehiculo se ocultan los widgets de los atributos
     * propios de los otros tipos de vehiculo
     * 
     * @param event
     */
    @FXML
    void seleccionartipovehiculoAction(ActionEvent event) {
        ocultarwidgets();// Se ocultan los widgets de los 3 tipos
        Vaciarcampos(); // Se vacia la informacion de los atributos propios
        String seleccion = comboboxtipovehiculo.getSelectionModel().getSelectedItem().toString();// Recibe la seleccion
        if (seleccion.equals(("Auto"))) {// Si es un auto muestra el widget para escribir el numero de puertas
            titulopuertas.setVisible(true);
            txtpuertas.setVisible(true);
        }
        if (seleccion.equals(("Moto"))) {// Si es una moto muestra la combobox para seleccionar el tipo de tabla
            titulocaja.setVisible(true);
            comboboxcaja.setVisible(true);
        }
        if (seleccion.equals(("Camioneta"))) {// Si es una camioneta muestra el campo de texto para escribir la
                                              // capacidad de carga
            titulocarga.setVisible(true);
            txtcarga.setVisible(true);
        }
    }

    public void setApp(App app) {
        this.app = app;
        vehiculoController = new VehiculoController(app.getEmpresa());
        initView();// Inicia la información de la tabla
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert comboboxtipovehiculo != null
                : "fx:id=\"comboboxtipovehiculo\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert columnmarca != null
                : "fx:id=\"Columnmarca\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert btnagregarvehiculo != null
                : "fx:id=\"btnagregarvehiculo\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert btneliminarVehiculo != null
                : "fx:id=\"btneliminarVehiculo\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert btnactualizarvehiculo != null
                : "fx:id=\"btnactualizarvehiculo\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert btnregresar != null
                : "fx:id=\"btnregresar\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert columnmodelo != null
                : "fx:id=\"columnmodelo\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert txtaño != null : "fx:id=\"txtaño\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert columncaja != null
                : "fx:id=\"columncaja\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert txtpuertas != null
                : "fx:id=\"txtpuertas\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert titulocarga != null
                : "fx:id=\"titulocarga\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert txtmatricula != null
                : "fx:id=\"txtmatricula\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert titulopuertas != null
                : "fx:id=\"titulopuertas\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert columnpuertas != null
                : "fx:id=\"columnpuertas\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert columncarga != null
                : "fx:id=\"columncarga\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert tblvehiculos != null
                : "fx:id=\"tblvehiculos\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert txtmarca != null : "fx:id=\"txtmarca\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert txtcarga != null : "fx:id=\"txtcarga\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert columnmatricula != null
                : "fx:id=\"columnmatricula\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert txtmodelo != null
                : "fx:id=\"txtmodelo\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert columnanio != null
                : "fx:id=\"columnaño\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert titulocaja != null
                : "fx:id=\"titulocaja\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
        assert comboboxcaja != null
                : "fx:id=\"comboboxcaja\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";

    }

    /**
     * Muestra un mensaje al usuario
     * 
     * @param titulo
     * @param header
     * @param contenido
     * @param alertType
     */
    public void mostrarmensaje(String titulo, String header, String contenido, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    /**
     * Inicia los datos de las tablas y oculta los atributos unicos
     */
    private void initView() {
        initDataBinding();// Asigna valores a cada columna
        obtenerVehiculos();// Obtiene la lista de vehiculos de la empresa
        tblvehiculos.getItems().clear();// Limpia la tabla
        if (!listaVehiculos.isEmpty()) {
            tblvehiculos.setItems(listaVehiculos);// Asigna los valores de la lista de vehiculos a la tabla siempre y
                                                  // cuando exista almenos 1 vehiculo
        }
        listenerSelection();// Listener para detectar la eleccion de la tabla
        ocultarwidgets();// Oculta los atributos propios de cada tipo de vehiculo
    }

    /**
     * Asigna a cada columna un valor de vehiculo
     */
    private void initDataBinding() {
        columnmatricula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMatricula()));
        columnmarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        columnmodelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        columnanio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAñofabricacion()));
        columnpuertas.setCellValueFactory(cellData -> {// Si el vehiculo es un auto pide el valor de numero de puertas
                                                       // de lo contrario se asigna N/A
            if (cellData.getValue() instanceof Auto) {
                return new SimpleStringProperty(((Auto) cellData.getValue()).getNumeropuertas().toString());
            }
            return new SimpleStringProperty("N/A");
        });
        columncaja.setCellValueFactory(cellData -> {// Si el vehiculo es una moto pide el valor de caja de lo contrario
                                                    // se asigna N/A
            if (cellData.getValue() instanceof Moto) {
                return new SimpleStringProperty(((Moto) cellData.getValue()).getCaja().toString());
            }
            return new SimpleStringProperty("N/A");
        });
        columncarga.setCellValueFactory(cellData -> {// Si el vehiculo es una camioneta pide el valor de carga de lo
                                                     // contrario se asigna N/A
            if (cellData.getValue() instanceof Camioneta) {
                return new SimpleStringProperty(((Camioneta) cellData.getValue()).getCarga() + " Toneladas");
            }
            return new SimpleStringProperty("N/A");
        });

        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
        comboboxtipovehiculo.setItems(tipovehiculo);// Se asignan las opciones de la combobox de tipo de vehiculo
        comboboxcaja.setItems(tipocaja);// Se assignan las opciones de la combobox de caja
    }

    /**
     * Obtiene la lista de vehiculos de la empresa
     */
    private void obtenerVehiculos() {
        Collection<Vehiculo> vehiculos = vehiculoController.obtenerlistaVehiculos();
        if (vehiculos != null) {
            listaVehiculos.addAll(vehiculos);
        }
    }

    /**
     * Obtiene el vehiculo seleccionado de la tabla y muestra su informacion
     */
    private void listenerSelection() {
        tblvehiculos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null && !listaVehiculos.isEmpty()) {
                vehiculoseleccionado = newSelection;
                mostrarInformacionVehiculo(vehiculoseleccionado);// Muestra la informacion del vehiculo seleccionado
            }
        });
    }

    /**
     * Muestra la información del vehiculo seleccionado en los campos de texto y los
     * atributos propios
     * 
     * @param vehiculo
     */
    private void mostrarInformacionVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            MostrarWidgetsSeleccion(vehiculo);// Muestra los atributos propios de cada tipo de vehiculo
            txtmatricula.setText(vehiculo.getMatricula());
            txtmarca.setText(vehiculo.getMarca());
            txtmodelo.setText(vehiculo.getModelo());
            txtaño.setText(vehiculo.getAñofabricacion());
        } else {
            Vaciarcampos();
        }
    }

    /**
     * Limpia los campos de los atributos propios
     */
    private void Vaciarcampos() {
        txtpuertas.clear();
        comboboxcaja.setValue(null);
        txtcarga.clear();
    }

    /**
     * Limpia los campos de los atributos propios, los campos de texto y
     * deselecciona el vehiculo de la tabla
     */
    private void limpiarseleccion() {
        tblvehiculos.getSelectionModel().clearSelection();
        txtmatricula.clear();
        txtmarca.clear();
        txtmodelo.clear();
        txtaño.clear();
        Vaciarcampos();
    }

    /**
     * Oculta todos los widgets de los atributos propios de cada tipo
     */
    private void ocultarwidgets() {
        titulopuertas.setVisible(false);
        txtpuertas.setVisible(false);
        titulocaja.setVisible(false);
        comboboxcaja.setVisible(false);
        titulocarga.setVisible(false);
        txtcarga.setVisible(false);
    }

    /**
     * Verifica si las selecciones no estan vacias y de ser el caso de ingresar
     * texto en un valor numerico mostrar un mensaje
     * 
     * @param matricula
     * @param marca
     * @param modelo
     * @param año
     * @param puertas
     * @param caja
     * @param carga
     * @return
     */
    public boolean validarDatos(String matricula, String marca, String modelo, String año, String puertas, Caja caja,
            String carga) {
        if (matricula.isEmpty() || marca.isEmpty() || modelo.isEmpty() || año.isEmpty()
                || puertas.isEmpty() && caja == null && carga.isEmpty()) {// Verifica que los campos de texto no esten
                                                                          // vacios y que almenos 1 atributo propio
                                                                          // tenga valor
            mostrarmensaje("Error", "Datos incompletos", "Llene todos los datos correctamente", AlertType.WARNING);
            return false;
        }
        if (!txtpuertas.getText().isEmpty()) {// En caso de ser un auto el campo de puertas debe de ser numerico
            try {
                Integer.parseInt(puertas);
            } catch (NumberFormatException e) {
                mostrarmensaje("Error", "Ingreso invalido", "El valor de puertas debe ser númerico", AlertType.WARNING);// Mensaje
                                                                                                                        // en
                                                                                                                        // caso
                                                                                                                        // de
                                                                                                                        // no
                                                                                                                        // ingresar
                                                                                                                        // valor
                                                                                                                        // numerico
                return false;
            }
        }
        if (!txtcarga.getText().isEmpty()) {// En caso de ser una camioneta el campo carga debe ser numerico
            try {
                Float.parseFloat(carga);
            } catch (NumberFormatException e) {
                mostrarmensaje("Error", "Ingreso invalido", "El valor de la carga debe ser númerico",
                        AlertType.WARNING);// Mensaje en caso de no ingresar valor numerico
                return false;
            }
        }
        return true;
    }

    /**
     * Selecciona y muestra los atributos propios dependiendo del tipo de vehiculo
     * 
     * @param vehiculo
     */
    private void MostrarWidgetsSeleccion(Vehiculo vehiculo) {
        if (vehiculo instanceof Auto) {
            comboboxtipovehiculo.setValue("Auto");
            txtpuertas.setText(((Auto) vehiculo).getNumeropuertas().toString());
        }
        if (vehiculo instanceof Moto) {
            comboboxtipovehiculo.setValue("Moto");
            comboboxcaja.setValue(((Moto) vehiculo).getCaja());

        }
        if (vehiculo instanceof Camioneta) {
            comboboxtipovehiculo.setValue("Camioneta");
            txtcarga.setText(((Camioneta) vehiculo).getCarga() + "");
        }
    }

}
