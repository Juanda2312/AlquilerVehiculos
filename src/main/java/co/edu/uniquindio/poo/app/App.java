package co.edu.uniquindio.poo.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import co.edu.uniquindio.poo.Viewcontroller.GestionClientesController;
import co.edu.uniquindio.poo.Viewcontroller.GestionReservaController;
import co.edu.uniquindio.poo.Viewcontroller.GestionVehiculosController;
import co.edu.uniquindio.poo.Viewcontroller.PaginaPrincipalController;
import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Caja;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Reserva;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage primaryStage;
    Empresa empresa = new Empresa("Alquileres don Luis");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Página principal");
        inicializarData();
        openViewPrincipal();
    }

    /**
     * Abre la ventana principal
     */
    public void openViewPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/PaginaPrincipal.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            PaginaPrincipalController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    /**
     * Abre la ventana GestionClientes
     */
    public void openGestionClientes() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/GestionClientes.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            GestionClientesController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Abre la ventana GestionVehiculos
     */
    public void openGestionVehiculos() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/GestionVehiculos.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            GestionVehiculosController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Abre la ventana GestionReserva
     */
    public void openGestionReserva() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/GestionReservas.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            GestionReservaController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * Inicializa unos datos para realizar pruebas
     */
    public void inicializarData() {
        Cliente cliente = new Cliente("Paco", "1234", "32156", "Pacoantonio@gmail.com");
        empresa.Agregarcliente(cliente);
        Moto moto = new Moto("3UJADNWJ", "Honda", "Odyssey", "2024", Caja.MANUAL);
        empresa.Agregarvehiculo(moto);
        Reserva reserva = new Reserva(cliente, moto, 13);
        empresa.AgregarReserva(reserva);
        cliente = new Cliente("Pedro", "54658", "3215654564", "Pedritogamer@yahoo.com");
        empresa.Agregarcliente(cliente);
        Auto auto = new Auto("5465AWDA", "Renault", "Logan", "2022", 4);
        empresa.Agregarvehiculo(auto);
        Camioneta camioneta = new Camioneta("EKDNAKW54", "Tesla", "Cybertruck", "2023", 15);
        empresa.Agregarvehiculo(camioneta);
        reserva = new Reserva(cliente, camioneta, 6);
        empresa.AgregarReserva(reserva);
    }
}
