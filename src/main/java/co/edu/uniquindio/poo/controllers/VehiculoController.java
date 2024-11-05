package co.edu.uniquindio.poo.controllers;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Caja;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Vehiculo;

public class VehiculoController {
    Empresa empresa;

    public VehiculoController(Empresa empresa) {
        this.empresa = empresa;
    }

    public Collection<Vehiculo> obtenerlistaVehiculos() {
        return empresa.getListavehiculos();
    }

    public String AgregarVehiculo(Vehiculo vehiculo) {
        return empresa.Agregarvehiculo(vehiculo);
    }

    public String EliminarVehiculo(Vehiculo vehiculo) {
        return empresa.EliminarVehiculo(vehiculo);
    }

    public String ActualizarVehiculo(Vehiculo vehiculo, String matricula, String marca, String modelo, String año,
            Integer puerta, Caja caja, Float carga) {
        return empresa.ActualizarVehiculo(vehiculo, matricula, marca, modelo, año, puerta, caja, carga);
    }
}
