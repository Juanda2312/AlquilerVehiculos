package co.edu.uniquindio.poo.Viewcontroller;

/**
 * Sample Skeleton for 'GestionClientes.fxml' Controller Class
 */

import java.net.URL;

import java.util.ResourceBundle;

import co.edu.uniquindio.poo.app.App;
import co.edu.uniquindio.poo.controllers.ClienteController;
import co.edu.uniquindio.poo.model.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class GestionClientesController {

    ClienteController clientecontroller;
    ObservableList<Cliente> listclientes = FXCollections.observableArrayList();
    Cliente Selectedcliente;

    App app;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btneliminarcliente"
    private Button btneliminarcliente; // Value injected by FXMLLoader

    @FXML // fx:id="columncorreo"
    private TableColumn<Cliente, String> columncorreo; // Value injected by FXMLLoader

    @FXML // fx:id="columncedula"
    private TableColumn<Cliente, String> columncedula; // Value injected by FXMLLoader

    @FXML // fx:id="txtcorreo"
    private TextField txtcorreo; // Value injected by FXMLLoader

    @FXML // fx:id="btnActualizarCliente"
    private Button btnActualizarCliente; // Value injected by FXMLLoader

    @FXML // fx:id="btnregresar"
    private Button btnregresar; // Value injected by FXMLLoader

    @FXML // fx:id="columntelefono"
    private TableColumn<Cliente, String> columntelefono; // Value injected by FXMLLoader

    @FXML // fx:id="columnnombre"
    private TableColumn<Cliente, String> columnnombre; // Value injected by FXMLLoader

    @FXML // fx:id="columnreservas"
    private TableColumn<Cliente, String> columnreservas; // Value injected by FXMLLoader

    @FXML // fx:id="txtcedula"
    private TextField txtcedula; // Value injected by FXMLLoader

    @FXML // fx:id="tblcliente"
    private TableView<Cliente> tblcliente; // Value injected by FXMLLoader

    @FXML // fx:id="txttelefono"
    private TextField txttelefono; // Value injected by FXMLLoader

    @FXML // fx:id="btnagregarcliente"
    private Button btnagregarcliente; // Value injected by FXMLLoader

    @FXML // fx:id="txtnombre"
    private TextField txtnombre; // Value injected by FXMLLoader

    /**
     * Agrega el cliente a la lista de clientes
     * 
     * @param event
     */
    @FXML
    void AgregarClienteAction(ActionEvent event) {
        String nombre = txtnombre.getText();
        String cedula = txtcedula.getText();
        String telefono = txttelefono.getText();
        String correo = txtcorreo.getText();

        boolean valido = validarDatos(nombre, cedula, telefono, correo);// valida que las casillas no esten vacias
        if (valido) {
            Cliente cliente = new Cliente(nombre, cedula, telefono, correo);
            String respuesta = clientecontroller.AgregarCliente(cliente);
            mostrarmensaje("Creacion de cliente", "Agregar cliente", respuesta, AlertType.INFORMATION);

            if (respuesta.equals("El cliente ha sido agregado")) {
                listclientes.add(cliente);
                limpiarseleccion();// Vacia los campos y limpia la seleccion de la tabla
            }
        }
    }

    /**
     * Elimina un cliente de la lista de clientes
     * 
     * @param event
     */
    @FXML
    void EliminarClienteAction(ActionEvent event) {
        Cliente clienteseleccionado = tblcliente.getSelectionModel().getSelectedItem();
        if (clienteseleccionado != null) {
            String resultado = clientecontroller.EliminarCliente(clienteseleccionado);
            mostrarmensaje("Eliminacion de cliente", "Eliminar cliente", resultado, AlertType.INFORMATION);
            if (resultado.equals("El cliente ha sido eliminado")) {
                listclientes.remove(clienteseleccionado);
                limpiarseleccion();// Vacia los campos y limpia la seleccion de la tabla
            }
        } else {
            mostrarmensaje("Eliminacion de cliente", "Eliminar cliente", "Seleccione un cliente en la tabla",
                    AlertType.WARNING);
        }
    }

    /**
     * Actualiza los datos de un cliente de la tabla
     * 
     * @param event
     */
    @FXML
    void ActualizarClienteAction(ActionEvent event) {
        Cliente clienteseleccionado = tblcliente.getSelectionModel().getSelectedItem();
        if (clienteseleccionado != null) {
            if (validarDatos(txtnombre.getText(), txtcedula.getText(), txttelefono.getText(), txtcorreo.getText())) {
                String resultado = clientecontroller.ActualizarCliente(clienteseleccionado, txtnombre.getText(),
                        txtcedula.getText(), txttelefono.getText(), txtcorreo.getText());
                mostrarmensaje("Actualización del cliente", "Actualizar cliente", resultado, AlertType.INFORMATION);
                if (resultado.equals("El cliente ha sido actualizado")) {
                    tblcliente.refresh();
                    limpiarseleccion();// Vacia los campos y limpia la seleccion de la tabla
                }
            }
        } else {
            mostrarmensaje("Actualización del cliente", "Actualizar cliente", "Seleccione un cliente en la tabla",
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
     * Verifica si las cajas de texto tienen la informacion necesaria
     * 
     * @param nombre
     * @param cedula
     * @param telefono
     * @param correo
     * @return false si hay alguna casilla vacia y true si todas tienen informacion
     */
    public boolean validarDatos(String nombre, String cedula, String telefono, String correo) {
        if (nombre.isEmpty() || cedula.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
            mostrarmensaje("Error", "Datos incompletos", "Rellene los datos correctamente", AlertType.WARNING);
            return false;
        }
        return true;
    }

    public void setApp(App app) {
        this.app = app;
        clientecontroller = new ClienteController(app.getEmpresa());
        initView();// Inicia los datos de la tabla
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btneliminarcliente != null
                : "fx:id=\"btneliminarcliente\" was not injected: check your FXML file 'GestionClientes.fxml'.";
        assert columncorreo != null
                : "fx:id=\"columncorreo\" was not injected: check your FXML file 'GestionClientes.fxml'.";
        assert columncedula != null
                : "fx:id=\"columncedula\" was not injected: check your FXML file 'GestionClientes.fxml'.";
        assert txtcorreo != null : "fx:id=\"txtcorreo\" was not injected: check your FXML file 'GestionClientes.fxml'.";
        assert btnActualizarCliente != null
                : "fx:id=\"btnActualizarCliente\" was not injected: check your FXML file 'GestionClientes.fxml'.";
        assert btnregresar != null
                : "fx:id=\"btnregresar\" was not injected: check your FXML file 'GestionClientes.fxml'.";
        assert columntelefono != null
                : "fx:id=\"columntelefono\" was not injected: check your FXML file 'GestionClientes.fxml'.";
        assert columnnombre != null
                : "fx:id=\"columnnombre\" was not injected: check your FXML file 'GestionClientes.fxml'.";
        assert columnreservas != null
                : "fx:id=\"columnreservas\" was not injected: check your FXML file 'GestionClientes.fxml'.";
        assert txtcedula != null : "fx:id=\"rxtcedula\" was not injected: check your FXML file 'GestionClientes.fxml'.";
        assert tblcliente != null
                : "fx:id=\"tblcliente\" was not injected: check your FXML file 'GestionClientes.fxml'.";
        assert txttelefono != null
                : "fx:id=\"txttelefono\" was not injected: check your FXML file 'GestionClientes.fxml'.";
        assert btnagregarcliente != null
                : "fx:id=\"btnagregarcliente\" was not injected: check your FXML file 'GestionClientes.fxml'.";
        assert txtnombre != null : "fx:id=\"txtnombre\" was not injected: check your FXML file 'GestionClientes.fxml'.";
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
     * Inicia los datos de la tabla
     */
    private void initView() {
        initDataBinding();// Asigna las columnas
        obtenerClientes();// Obtiene la listas de clientes de la empresa
        tblcliente.getItems().clear();// Limpia la tabla
        tblcliente.setItems(listclientes);// Pone la informacion de los clientes en la tabla
        listenerSelection();// Listener para poder seleccionar clientes de la tabla
    }

    /**
     * Asigna cada columna a datos de los clientes
     */
    private void initDataBinding() {
        columnnombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        columncedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        columntelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        columncorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        columnreservas.setCellValueFactory(cellData -> {
            if (cellData.getValue().getListareservas().isEmpty()) {
                return new SimpleStringProperty("No tiene reservas");// Si el cliente no tiene ninguna reserva se indica
            } else {
                return new SimpleStringProperty(cellData.getValue().getListareservas().toString());
            }
        });
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    /**
     * El controller solicita la lista de clientes a la empresa
     */
    private void obtenerClientes() {
        listclientes.addAll(clientecontroller.obtenerlistaClientes());
    }

    /**
     * Toma el cliente seleccionado de la tabla y muestra su informacion
     */
    private void listenerSelection() {
        tblcliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            Selectedcliente = newSelection;
            mostrarInformacionCliente(Selectedcliente);// muestra la informacion del cliente seleccionado
        });

    }

    /**
     * Toma el cliente seleccionado y muestra su información en los espacios de
     * texto
     * 
     * @param cliente
     */
    private void mostrarInformacionCliente(Cliente cliente) {
        if (cliente != null) {
            txtnombre.setText(cliente.getNombre());
            txtcedula.setText(cliente.getCedula());
            txtcorreo.setText(cliente.getCorreo());
            txttelefono.setText(cliente.getTelefono());
        }

    }

    /**
     * Limpia los campos de texto
     */
    private void Vaciarcampos() {
        txtnombre.clear();
        txtcedula.clear();
        txttelefono.clear();
        txtcorreo.clear();
    }

    /**
     * Deselecciona el cliente de la tabla y limpia los campos de textos
     */
    private void limpiarseleccion() {
        tblcliente.getSelectionModel().clearSelection();
        Vaciarcampos();
    }
}
