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
    ObservableList<String> tipovehiculo = FXCollections.observableArrayList("Auto","Moto","Camioneta");
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

     @FXML
     void actualizarvehiculoAction(ActionEvent event) {
        try {
        Vehiculo vehiculoseleccionado = tblvehiculos.getSelectionModel().getSelectedItem();
        if (vehiculoseleccionado!= null) {
            if (validarDatos(txtmatricula.getText(), txtmarca.getText(), txtmodelo.getText(), txtaño.getText(), txtpuertas.getText(), comboboxcaja.getSelectionModel().getSelectedItem(), txtcarga.getText())) {
                Integer puertas = 0;
                float carga = 0;
                if (!txtpuertas.getText().isEmpty()) {
                    puertas = Integer.parseInt(txtpuertas.getText());
                }
                if (!txtcarga.getText().isEmpty()) {
                    carga = Float.parseFloat(txtcarga.getText());
                }
            String resultado = vehiculoController.ActualizarVehiculo(vehiculoseleccionado, txtmatricula.getText(), txtmarca.getText(), txtmodelo.getText(), txtaño.getText(), puertas, comboboxcaja.getSelectionModel().getSelectedItem(), carga);
            mostrarmensaje("Actualizacion de Vehiculo", "Actualizar Vehiculo",resultado, AlertType.INFORMATION);
            if (resultado.equals("El vehiculo ha sido actualizado")) {
                tblvehiculos.refresh();
               limpiarseleccion();
        }
            }       
     }else{
        mostrarmensaje("Actualizacion de Vehiculo", "Actualizar Vehiculo","Seleccione un vehiculo de la tabla", AlertType.WARNING);
     }
        }catch (Exception e) {

        }
     }
 
     @FXML
     void agregarvehiculoAction(ActionEvent event) {
        String matricula = txtmatricula.getText();
        String marca = txtmarca.getText();
        String modelo = txtmodelo.getText();
        String año = txtaño.getText();
        String puerta = txtpuertas.getText();
        Caja caja = comboboxcaja.getSelectionModel().getSelectedItem();
        String carga = txtcarga.getText();
        boolean validacion = validarDatos(matricula, marca, modelo, año, puerta, caja, carga);
        if (validacion) {
            String respuesta = "";
            if (!puerta.isEmpty()) {
                Auto auto = new Auto(matricula, marca, modelo, año, Integer.parseInt(puerta));
                respuesta = vehiculoController.AgregarVehiculo(auto);
                if (respuesta.equals("El vehiculo ha sido agregado")) {
                    listaVehiculos.add(auto);
                    limpiarseleccion();
                }
            }
            if (caja != null) {
                Moto moto = new Moto(matricula, marca, modelo, año, caja);
                respuesta = vehiculoController.AgregarVehiculo(moto);
                if (respuesta.equals("El vehiculo ha sido agregado")) {
                    listaVehiculos.add(moto);
                    limpiarseleccion();
                }
            }
            if (!carga.isEmpty()) {
                Camioneta camioneta = new Camioneta(matricula, marca, modelo, año, Float.parseFloat(carga));
                respuesta = vehiculoController.AgregarVehiculo(camioneta);
                if (respuesta.equals("El vehiculo ha sido agregado")) {
                    listaVehiculos.add(camioneta);
                    limpiarseleccion();
                }
            }
                mostrarmensaje("Agregar Vehiculo", "Verificación", respuesta, AlertType.INFORMATION);
        }
     }
 
 
     @FXML
     void eliminarvehiculoAction(ActionEvent event) {
        Vehiculo vehiculoseleccionado = tblvehiculos.getSelectionModel().getSelectedItem();
        if (vehiculoseleccionado!= null) {
            String resultado = vehiculoController.EliminarVehiculo(vehiculoseleccionado);
            mostrarmensaje("Eliminacion de Vehiculo", "Eliminar Vehiculo",resultado, AlertType.INFORMATION);
            if (resultado.equals("El vehiculo ha sido eliminado")) {
                listaVehiculos.remove(vehiculoseleccionado);
               limpiarseleccion();
        }
     }else{
        mostrarmensaje("Eliminacion de Vehiculo", "Eliminar Vehiculo","Seleccione un vehiculo de la tabla", AlertType.WARNING);
     }
    }

     @FXML
     void RegresarAction(ActionEvent event) {
        app.openViewPrincipal();
     }

    @FXML
    void seleccionartipovehiculoAction(ActionEvent event) {
        ocultarwidgets();
        Vaciarcampos();
        String seleccion = comboboxtipovehiculo.getSelectionModel().getSelectedItem().toString();
        if (seleccion.equals(("Auto"))) {
            titulopuertas.setVisible(true);
            txtpuertas.setVisible(true);
        }
        if (seleccion.equals(("Moto"))) {
            titulocaja.setVisible(true);
            comboboxcaja.setVisible(true);
        }
        if (seleccion.equals(("Camioneta"))) {
            titulocarga.setVisible(true);
            txtcarga.setVisible(true);
        }
    }

    public void setApp(App app) {
        this.app = app;
        vehiculoController = new VehiculoController(app.getEmpresa());
        initView();
 }
     @FXML // This method is called by the FXMLLoader when initialization is complete
     void initialize() {
         assert comboboxtipovehiculo != null : "fx:id=\"comboboxtipovehiculo\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert columnmarca != null : "fx:id=\"Columnmarca\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert btnagregarvehiculo != null : "fx:id=\"btnagregarvehiculo\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert btneliminarVehiculo != null : "fx:id=\"btneliminarVehiculo\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert btnactualizarvehiculo != null : "fx:id=\"btnactualizarvehiculo\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert btnregresar != null : "fx:id=\"btnregresar\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert columnmodelo != null : "fx:id=\"columnmodelo\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert txtaño != null : "fx:id=\"txtaño\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert columncaja != null : "fx:id=\"columncaja\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert txtpuertas != null : "fx:id=\"txtpuertas\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert titulocarga != null : "fx:id=\"titulocarga\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert txtmatricula != null : "fx:id=\"txtmatricula\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert titulopuertas != null : "fx:id=\"titulopuertas\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert columnpuertas != null : "fx:id=\"columnpuertas\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert columncarga != null : "fx:id=\"columncarga\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert tblvehiculos != null : "fx:id=\"tblvehiculos\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert txtmarca != null : "fx:id=\"txtmarca\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert txtcarga != null : "fx:id=\"txtcarga\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert columnmatricula != null : "fx:id=\"columnmatricula\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert txtmodelo != null : "fx:id=\"txtmodelo\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert columnanio != null : "fx:id=\"columnaño\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert titulocaja != null : "fx:id=\"titulocaja\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
         assert comboboxcaja != null : "fx:id=\"comboboxcaja\" was not injected: check your FXML file 'GestionVehiculos.fxml'.";
 
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
        obtenerVehiculos();
        tblvehiculos.getItems().clear();
        if (!listaVehiculos.isEmpty()) {
            tblvehiculos.setItems(listaVehiculos);
        }
        listenerSelection();
        ocultarwidgets();
    }
    

  private void initDataBinding() {
        columnmatricula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMatricula()));
        columnmarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        columnmodelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        columnanio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAñofabricacion()));
        columnpuertas.setCellValueFactory(cellData -> {
            if (cellData.getValue() instanceof Auto) {
                return new SimpleStringProperty(((Auto) cellData.getValue()).getNumeropuertas().toString());
            }
            return new SimpleStringProperty("N/A");
        });
        columncaja.setCellValueFactory(cellData -> {
            if (cellData.getValue() instanceof Moto) {
                return new SimpleStringProperty(((Moto) cellData.getValue()).getCaja().toString());
            }
            return new SimpleStringProperty("N/A");
        });
        columncarga.setCellValueFactory(cellData -> {
            if (cellData.getValue() instanceof Camioneta) {
                return new SimpleStringProperty(((Camioneta) cellData.getValue()).getCarga() +" Toneladas");
            }
            return new SimpleStringProperty("N/A");
        });
        

        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
        comboboxtipovehiculo.setItems(tipovehiculo);
        comboboxcaja.setItems(tipocaja);
    }
    private void obtenerVehiculos(){
        Collection <Vehiculo> vehiculos = vehiculoController.obtenerlistaVehiculos(); 
        if (vehiculos != null) {
            listaVehiculos.addAll(vehiculos);
        }
    }

    private void listenerSelection() {
        tblvehiculos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null && !listaVehiculos.isEmpty()) { 
                vehiculoseleccionado = newSelection;
                mostrarInformacionVehiculo(vehiculoseleccionado);
            }
        });
    }
    
    
    private void mostrarInformacionVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            MostrarWidgetsSeleccion(vehiculo);
            txtmatricula.setText(vehiculo.getMatricula());
            txtmarca.setText(vehiculo.getMarca());
            txtmodelo.setText(vehiculo.getModelo());
            txtaño.setText(vehiculo.getAñofabricacion());
        } else {
            Vaciarcampos();
        }
    }
    

    private void Vaciarcampos(){
        txtpuertas.clear();
        comboboxcaja.setValue(null);
        txtcarga.clear();
}

    private void limpiarseleccion(){
    tblvehiculos.getSelectionModel().clearSelection();
    txtmatricula.clear();
    txtmarca.clear();
    txtmodelo.clear();
    txtaño.clear();
    Vaciarcampos();
}
    private void ocultarwidgets(){
        titulopuertas.setVisible(false);
        txtpuertas.setVisible(false);
        titulocaja.setVisible(false);
        comboboxcaja.setVisible(false);
        titulocarga.setVisible(false);
        txtcarga.setVisible(false);
    }

         public boolean validarDatos(String matricula, String marca, String modelo, String año, String puertas, Caja caja, String carga){
        if (matricula.isEmpty()||marca.isEmpty()||modelo.isEmpty()||año.isEmpty()||puertas.isEmpty() && caja == null && carga.isEmpty()){
            mostrarmensaje("Error", "Datos incompletos", "Llene todos los datos correctamente", AlertType.WARNING);
            return false;
        }
        if (!txtpuertas.getText().isEmpty()) {
            try {
                Integer.parseInt(puertas);
            } catch (NumberFormatException e) {
                mostrarmensaje("Error", "Ingreso invalido", "El valor de puertas debe ser númerico", AlertType.WARNING);
                return false;
            }
        }
        if (!txtcarga.getText().isEmpty()){
            try {
                Float.parseFloat(carga);
            } catch (NumberFormatException e) {
                mostrarmensaje("Error", "Ingreso invalido", "El valor de la carga debe ser númerico", AlertType.WARNING);
                return false;
            }
        }
        return true;
     }
     
     private void MostrarWidgetsSeleccion(Vehiculo vehiculo){
        if (vehiculo instanceof Auto) {
            comboboxtipovehiculo.setValue("Auto");
            txtpuertas.setText(((Auto)vehiculo).getNumeropuertas().toString());
        }
        if (vehiculo instanceof Moto) {
            comboboxtipovehiculo.setValue("Moto");
            comboboxcaja.setValue(((Moto)vehiculo).getCaja());

        }
        if (vehiculo instanceof Camioneta) {
            comboboxtipovehiculo.setValue("Camioneta");
            txtcarga.setText(((Camioneta)vehiculo).getCarga()+ "");
        }
     }
     
}

 