package co.edu.uniquindio.poo.Viewcontroller;

/**
 * Sample Skeleton for 'GestionReservas.fxml' Controller Class
 */

 import java.net.URL;
 import java.util.ResourceBundle;

import co.edu.uniquindio.poo.app.App;
import co.edu.uniquindio.poo.controllers.ReservaController;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
 
 public class GestionReservaController {
    App app;
    ReservaController reservaController;
    ObservableList<Reserva> listaReservas = FXCollections.observableArrayList();
    ObservableList<Vehiculo> listaVehiculos = FXCollections.observableArrayList();
    ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    Reserva reservaseleccionada;
    Vehiculo vehiculoseleccionado;
    Cliente clienteseleccionado;

     @FXML // ResourceBundle that was given to the FXMLLoader
     private ResourceBundle resources;
 
     @FXML // fx:id="txttotal"
     private Label txttotal; // Value injected by FXMLLoader

     @FXML // URL location of the FXML file that was given to the FXMLLoader
     private URL location;
 
     @FXML // fx:id="columncorreo"
     private TableColumn<Cliente, String> columncorreo; // Value injected by FXMLLoader

     @FXML // fx:id="btndeseleccionarvehiculo"
     private Button btndeseleccionarvehiculo; // Value injected by FXMLLoader

     @FXML // fx:id="btndesseleccionarcliente"
     private Button btndesseleccionarcliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="columncedula"
     private TableColumn<Cliente, String> columncedula; // Value injected by FXMLLoader
 
     @FXML // fx:id="columndias"
     private TableColumn<Reserva, String> columndias; // Value injected by FXMLLoader
 
     @FXML // fx:id="tblreserva"
     private TableView<Reserva> tblreserva; // Value injected by FXMLLoader
 
     @FXML // fx:id="tblvehiculo"
     private TableView<Vehiculo> tblvehiculo; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnregresar"
     private Button btnregresar; // Value injected by FXMLLoader
 
     @FXML // fx:id="columncliente"
     private TableColumn<Reserva, String> columncliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="columntotal"
     private TableColumn<Reserva, String> columntotal; // Value injected by FXMLLoader
 
     @FXML // fx:id="columntelefono"
     private TableColumn<Cliente, String> columntelefono; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnmodelo"
     private TableColumn<Vehiculo, String> columnmodelo; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtdias"
     private TextField txtdias; // Value injected by FXMLLoader
 
     @FXML // fx:id="btneliminarreserva"
     private Button btneliminarreserva; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnactualizarreserva"
     private Button btnactualizarreserva; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnnombre"
     private TableColumn<Cliente, String> columnnombre; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnagregarreserva"
     private Button btnagregarreserva; // Value injected by FXMLLoader
 
     @FXML // fx:id="tblcliente"
     private TableView<Cliente> tblcliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnmatricula"
     private TableColumn<Vehiculo, String> columnmatricula; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnvehiculo"
     private TableColumn<Reserva, String> columnvehiculo; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnmarca"
     private TableColumn<Vehiculo, String> columnmarca; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnaio"
     private TableColumn<Vehiculo, String> columnanio; // Value injected by FXMLLoader
 
     @FXML
     void actualizarreservaAction(ActionEvent event) {
        Reserva reservaseleccionada = tblreserva.getSelectionModel().getSelectedItem();
        if (reservaseleccionada!= null) {
            String dias = txtdias.getText();
            Cliente clienteseleccionado = tblcliente.getSelectionModel().getSelectedItem();
            Vehiculo vehiculoseleccionado = tblvehiculo.getSelectionModel().getSelectedItem();
            Boolean validacion = ValidarDatos(dias,clienteseleccionado,vehiculoseleccionado);
            if (validacion) {
                String resultado = reservaController.Actualizarreserva(reservaseleccionada, clienteseleccionado, vehiculoseleccionado, Integer.parseInt(dias));
                mostrarmensaje("Actualización de reserva", "Actualizar Reserva", resultado, AlertType.INFORMATION);
                if (resultado.equals("La reserva ha sido actualizado")) {
                    tblreserva.refresh();
                    limpiarseleccion();
                }
            }
        }else{
            mostrarmensaje("Actualización de reserva", "Actualizar Reserva", "Seleccione una reserva en la tabla", AlertType.WARNING);
        }
     }

     @FXML
    void deseleccionarclienteAction(ActionEvent event) {
        tblcliente.getSelectionModel().clearSelection();
    }

    @FXML
    void deseleccionarvehiculoAction(ActionEvent event) {
        tblvehiculo.getSelectionModel().clearSelection();
    }
 
     @FXML
     void agregarreservaAction(ActionEvent event) {
        String dias = txtdias.getText();
        Cliente clienteseleccionado = tblcliente.getSelectionModel().getSelectedItem();
        Vehiculo vehiculoseleccionado = tblvehiculo.getSelectionModel().getSelectedItem();
        Boolean validacion = ValidarDatos(dias,clienteseleccionado,vehiculoseleccionado);
        if (validacion) {
            Reserva reserva = new Reserva(clienteseleccionado, vehiculoseleccionado, Integer.parseInt(dias));
            String repuesta = reservaController.Agregarreserva(reserva);
            mostrarmensaje("Creacion de reserva", "Crear reserva", repuesta, AlertType.INFORMATION);
            if (repuesta.equals("La reserva ha sido agregada")) {   
                listaReservas.add(reserva);
                limpiarseleccion();
            }
        }
     }
 
     @FXML
     void eliminarreservaAction(ActionEvent event) {
        Reserva reservaseleccionada = tblreserva.getSelectionModel().getSelectedItem();
        if (reservaseleccionada != null) {
            String resultado = reservaController.Eliminarreserva(reservaseleccionada);
            mostrarmensaje("Eliminación de reserva", "eliminar reserva", resultado, AlertType.INFORMATION);
            if (resultado.equals("La reserva ha sido eliminada")) {
                listaReservas.remove(reservaseleccionada);
                limpiarseleccion();
            }
        }else{
            mostrarmensaje("Eliminación de reserva", "eliminar reserva", "Seleccione una reserva de la tabla", AlertType.WARNING);
        }
     }
 
     @FXML
     void regresarAction(ActionEvent event) {
        app.openViewPrincipal();
     }

    public void setApp(App app) {
     this.app = app;
     reservaController = new ReservaController(app.getEmpresa());
     initView();
    }

     @FXML // This method is called by the FXMLLoader when initialization is complete
     void initialize() {
         assert columncorreo != null : "fx:id=\"columncorreo\" was not injected: check your FXML file 'GestionReservas.fxml'.";
         assert columncedula != null : "fx:id=\"columncedula\" was not injected: check your FXML file 'GestionReservas.fxml'.";
         assert columndias != null : "fx:id=\"columndias\" was not injected: check your FXML file 'GestionReservas.fxml'.";
         assert tblreserva != null : "fx:id=\"tblreserva\" was not injected: check your FXML file 'GestionReservas.fxml'.";
         assert tblvehiculo != null : "fx:id=\"tblvehiculo\" was not injected: check your FXML file 'GestionReservas.fxml'.";
         assert btnregresar != null : "fx:id=\"btnregresar\" was not injected: check your FXML file 'GestionReservas.fxml'.";
         assert columncliente != null : "fx:id=\"columncliente\" was not injected: check your FXML file 'GestionReservas.fxml'.";
         assert columntotal != null : "fx:id=\"columntotal\" was not injected: check your FXML file 'GestionReservas.fxml'.";
         assert columntelefono != null : "fx:id=\"columntelefono\" was not injected: check your FXML file 'GestionReservas.fxml'.";
         assert columnmodelo != null : "fx:id=\"columnmodelo\" was not injected: check your FXML file 'GestionReservas.fxml'.";
         assert txtdias != null : "fx:id=\"txtdias\" was not injected: check your FXML file 'GestionReservas.fxml'.";
         assert btneliminarreserva != null : "fx:id=\"btneliminarreserva\" was not injected: check your FXML file 'GestionReservas.fxml'.";
         assert btnactualizarreserva != null : "fx:id=\"btnactualizarreserva\" was not injected: check your FXML file 'GestionReservas.fxml'.";
         assert columnnombre != null : "fx:id=\"columnnombre\" was not injected: check your FXML file 'GestionReservas.fxml'.";
         assert btnagregarreserva != null : "fx:id=\"btnagregarreserva\" was not injected: check your FXML file 'GestionReservas.fxml'.";
         assert tblcliente != null : "fx:id=\"tblcliente\" was not injected: check your FXML file 'GestionReservas.fxml'.";
         assert columnmatricula != null : "fx:id=\"columnmatricula\" was not injected: check your FXML file 'GestionReservas.fxml'.";
         assert columnvehiculo != null : "fx:id=\"columnvehiculo\" was not injected: check your FXML file 'GestionReservas.fxml'.";
         assert columnmarca != null : "fx:id=\"columnmarca\" was not injected: check your FXML file 'GestionReservas.fxml'.";
         assert columnanio != null : "fx:id=\"columnaño\" was not injected: check your FXML file 'GestionReservas.fxml'.";
 
     }
         public void mostrarmensaje(String titulo,String header, String contenido, AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
     }
     private void initView() {
        initDataBinding();
        obtenerReservas();
        obtenerClientes();
        obtenerVehiculos();
        tblreserva.getItems().clear();
        tblreserva.setItems(listaReservas);
        tblcliente.getItems().clear();
        tblcliente.setItems(listaClientes);
        tblvehiculo.getItems().clear();
        tblvehiculo.setItems(listaVehiculos);
        listenerSelectionReserva();
        listenerSelectionCliente();
        listenerSelectionVehiculo();

     }
        private void initDataBinding() {
        columndias.setCellValueFactory(cellData->new SimpleStringProperty((cellData.getValue().getDias())+ "Dias"));
        columnvehiculo.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getVehiculo().toString()));
        columncliente.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getCliente().toString()));
        columntotal.setCellValueFactory(cellData-> new SimpleStringProperty((cellData.getValue().getTotal())+"$COP"));

        columnnombre.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getNombre()));
        columncedula.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getCedula()));
        columntelefono.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getTelefono()));
        columncorreo.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getCorreo()));

        columnmatricula.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getMatricula()));
        columnmarca.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getMarca()));
        columnmodelo.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getModelo()));
        columnanio.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getAñofabricacion()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
        }
    private void obtenerReservas(){
        listaReservas.addAll(reservaController.obtenerReservas());
    }
    private void obtenerClientes(){
        listaClientes.addAll(reservaController.ObtenerClientes());
    }
    private void obtenerVehiculos(){
        listaVehiculos.addAll(reservaController.obtenerVehiculos());
    }
    
    private void listenerSelectionReserva() {
        tblreserva.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            reservaseleccionada = newSelection;
            mostrarInformacionReserva(reservaseleccionada);
        });
}
    private void listenerSelectionCliente() {
        tblcliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            clienteseleccionado = newSelection;
    });
}
    private void listenerSelectionVehiculo() {
        tblvehiculo.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            vehiculoseleccionado = newSelection;
    });
    }
    private void mostrarInformacionReserva(Reserva reserva) {
        if (reserva != null) {
            txtdias.setText(reserva.getDias()+"");
            txttotal.setText(reserva.getTotal()+"$COP");
            clienteseleccionado = reserva.getCliente();
            vehiculoseleccionado = reserva.getVehiculo();
        }
}
    private void limpiarseleccion(){
        txtdias.clear();
        txttotal.setText("");
        tblreserva.getSelectionModel().clearSelection();
        tblcliente.getSelectionModel().clearSelection();
        tblvehiculo.getSelectionModel().clearSelection();
    }
    private Boolean ValidarDatos(String dias, Cliente cliente, Vehiculo vehiculo){
        if (dias.isEmpty() || cliente == null || vehiculo == null) {
            mostrarmensaje("Error", "Datos incompletos", "Rellena y selecciona todos los datos", AlertType.WARNING);
            return false;
        }
        if (!txtdias.getText().isEmpty()) {
            try {
                Integer.parseInt(txtdias.getText());
            } catch (NumberFormatException e) {
                mostrarmensaje("Error", "Ingreso invalido", "El valor de dias debe ser númerico", AlertType.WARNING);
                return false;
            }
        }
        return true;
    }
}

 
 
