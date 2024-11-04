package co.edu.uniquindio.poo.Viewcontroller;

/**
 * Sample Skeleton for 'GestionClientes.fxml' Controller Class
 */

 import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.app.App;
import co.edu.uniquindio.poo.controllers.ClienteController;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Reserva;
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
import javafx.scene.control.Tooltip;
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
     private TableColumn<Cliente , String> columncedula; // Value injected by FXMLLoader
 
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
 
     @FXML
     void AgregarClienteAction(ActionEvent event) {
        String nombre = txtnombre.getText();
        String cedula = txtcedula.getText();
        String telefono = txttelefono.getText();
        String correo = txtcorreo.getText();

        boolean valido = validarDatos(nombre,cedula,telefono,correo);
        if (valido) {
            Cliente cliente = new Cliente(nombre, cedula, telefono, correo);
            String respuesta = clientecontroller.AgregarCliente(cliente);
            mostrarmensaje("Creacion de cliente", "Agregar cliente", respuesta, AlertType.INFORMATION);

            if (respuesta.equals("El cliente ha sido agregado")) {
                listclientes.add(cliente);
                limpiarseleccion();
            }
        }else{
            mostrarmensaje("Creación de cliente", "Agregar Cliente", "Llene los datos correctamente", AlertType.WARNING);
        }
     }
     
     @FXML
     void EliminarClienteAction(ActionEvent event) {
        Cliente clienteseleccionado = tblcliente.getSelectionModel().getSelectedItem();
        if (clienteseleccionado != null) {
            String resultado = clientecontroller.EliminarCliente(clienteseleccionado);
            mostrarmensaje("Eliminacion de cliente", "Eliminar cliente",resultado, AlertType.INFORMATION);
            if (resultado.equals("El cliente ha sido eliminado")) {
                listclientes.remove(clienteseleccionado);
               limpiarseleccion();
            }
        }else{
            mostrarmensaje("Eliminacion de cliente", "Eliminar cliente","Seleccione un cliente en la tabla", AlertType.WARNING);
        }
     }

     @FXML
     void ActualizarClienteAction(ActionEvent event) {
        Cliente clienteseleccionado = tblcliente.getSelectionModel().getSelectedItem();
        if (clienteseleccionado != null) {
            String resultado = clientecontroller.ActualizarCliente(clienteseleccionado, txtnombre.getText(), txtcedula.getText(), txttelefono.getText(),txtcorreo.getText());
            mostrarmensaje("Actualización del cliente", "Actualizar cliente",resultado, AlertType.INFORMATION);
            if (resultado.equals("El cliente ha sido actualizado")) {
                tblcliente.refresh();
                limpiarseleccion();
            }
        }else{
            mostrarmensaje("Eliminacion de cliente", "Eliminar cliente","Seleccione un cliente en la tabla", AlertType.WARNING);
        }
     }
     
 
 
     @FXML
     void RegresarAction(ActionEvent event) {
        app.openViewPrincipal();
     }

     public boolean validarDatos(String nombre,String cedula,String telefono, String correo){
        if (nombre.isEmpty()){
            txtnombre.setTooltip(new Tooltip("Llene el nombre"));
            return false;
        }
        if (cedula.isEmpty()){
            txtcedula.setTooltip(new Tooltip("Llene la cedula"));
            return false;
        }
        if (telefono.isEmpty()) {
            txttelefono.setTooltip(new Tooltip("Llene el telefono"));
            return false;
        }
        if (correo.isEmpty()){
            txtcorreo.setTooltip(new Tooltip("Llene el correo"));
            return false;
        }
        return true;
     }
     
     public void setApp(App app) {
        this.app = app;
        clientecontroller = new ClienteController(app.getEmpresa());
        initView();
    }
     @FXML // This method is called by the FXMLLoader when initialization is complete
     void initialize() {
         assert btneliminarcliente != null : "fx:id=\"btneliminarcliente\" was not injected: check your FXML file 'GestionClientes.fxml'.";
         assert columncorreo != null : "fx:id=\"columncorreo\" was not injected: check your FXML file 'GestionClientes.fxml'.";
         assert columncedula != null : "fx:id=\"columncedula\" was not injected: check your FXML file 'GestionClientes.fxml'.";
         assert txtcorreo != null : "fx:id=\"txtcorreo\" was not injected: check your FXML file 'GestionClientes.fxml'.";
         assert btnActualizarCliente != null : "fx:id=\"btnActualizarCliente\" was not injected: check your FXML file 'GestionClientes.fxml'.";
         assert btnregresar != null : "fx:id=\"btnregresar\" was not injected: check your FXML file 'GestionClientes.fxml'.";
         assert columntelefono != null : "fx:id=\"columntelefono\" was not injected: check your FXML file 'GestionClientes.fxml'.";
         assert columnnombre != null : "fx:id=\"columnnombre\" was not injected: check your FXML file 'GestionClientes.fxml'.";
         assert columnreservas != null : "fx:id=\"columnreservas\" was not injected: check your FXML file 'GestionClientes.fxml'.";
         assert txtcedula != null : "fx:id=\"rxtcedula\" was not injected: check your FXML file 'GestionClientes.fxml'.";
         assert tblcliente != null : "fx:id=\"tblcliente\" was not injected: check your FXML file 'GestionClientes.fxml'.";
         assert txttelefono != null : "fx:id=\"txttelefono\" was not injected: check your FXML file 'GestionClientes.fxml'.";
         assert btnagregarcliente != null : "fx:id=\"btnagregarcliente\" was not injected: check your FXML file 'GestionClientes.fxml'.";
         assert txtnombre != null : "fx:id=\"txtnombre\" was not injected: check your FXML file 'GestionClientes.fxml'.";
     }
     
     public void mostrarmensaje(String titulo,String header, String contenido, AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
     }
     private void initView(){
        initDataBinding();
        obtenerClientes();
        tblcliente.getItems().clear();
        tblcliente.setItems(listclientes);
        listenerSelection();

     }
     
     private void initDataBinding() {
        columnnombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        columncedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        columntelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        columncorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        columnreservas.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getListareservas().toString()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }
    private void obtenerClientes(){
        listclientes.addAll(clientecontroller.obtenerlistaClientes());
    }
    
    private void listenerSelection() {
        tblcliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            Selectedcliente = newSelection;
            mostrarInformacionCliente(Selectedcliente);
        });

 }
    private void mostrarInformacionCliente(Cliente cliente) {
        if (cliente != null) {
            txtnombre.setText(cliente.getNombre());
            txtcedula.setText(cliente.getCedula());
            txtcorreo.setText(cliente.getCorreo());
            txttelefono.setText(cliente.getTelefono());
        }

}
    private void Vaciarcampos(){
        txtnombre.clear();
        txtcedula.clear();
        txttelefono.clear();
        txtcorreo.clear();
    }
    private void limpiarseleccion(){
        tblcliente.getSelectionModel().clearSelection();
        Vaciarcampos();
    }
}
