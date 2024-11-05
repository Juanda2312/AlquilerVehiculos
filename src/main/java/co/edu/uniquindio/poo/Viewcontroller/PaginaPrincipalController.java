package co.edu.uniquindio.poo.Viewcontroller;

/**
 * Sample Skeleton for 'PaginaPrincipal.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PaginaPrincipalController {

   App app;
   @FXML // ResourceBundle that was given to the FXMLLoader
   private ResourceBundle resources;

   @FXML // URL location of the FXML file that was given to the FXMLLoader
   private URL location;

   @FXML // fx:id="btnvehiculos"
   private Button btnvehiculos; // Value injected by FXMLLoader

   @FXML // fx:id="btnclientes"
   private Button btnclientes; // Value injected by FXMLLoader

   @FXML // fx:id="btnreservas"
   private Button btnreservas; // Value injected by FXMLLoader

   /**
    * Abre la ventana GestionClientes
    * 
    * @param event
    */
   @FXML
   void clientesAction(ActionEvent event) {
      app.openGestionClientes();
   }

   /**
    * Abre la ventana GestionReservas
    * 
    * @param event
    */
   @FXML
   void reservasAction(ActionEvent event) {
      app.openGestionReserva();
   }

   /**
    * Abre la ventana GestionVehiculos
    * 
    * @param event
    */
   @FXML
   void vehiculosActions(ActionEvent event) {
      app.openGestionVehiculos();
   }

   @FXML // This method is called by the FXMLLoader when initialization is complete
   void initialize() {
      assert btnvehiculos != null
            : "fx:id=\"btnvehiculos\" was not injected: check your FXML file 'PaginaPrincipal.fxml'.";
      assert btnclientes != null
            : "fx:id=\"btnclientes\" was not injected: check your FXML file 'PaginaPrincipal.fxml'.";
      assert btnreservas != null
            : "fx:id=\"btnreservas\" was not injected: check your FXML file 'PaginaPrincipal.fxml'.";

   }

   public void setApp(App app) {
      this.app = app;
   }
}
