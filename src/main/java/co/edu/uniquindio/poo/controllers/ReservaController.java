package co.edu.uniquindio.poo.controllers;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;

public class ReservaController {
    Empresa empresa;

    public ReservaController(Empresa empresa) {
        this.empresa = empresa;
    }

    public Collection<Reserva> obtenerReservas() {
        return empresa.getListareservas();
    }

    public Collection<Vehiculo> obtenerVehiculos() {
        return empresa.getListavehiculos();
    }

    public Collection<Cliente> ObtenerClientes() {
        return empresa.getListaclientes();
    }

    public String Agregarreserva(Reserva reserva) {
        return empresa.AgregarReserva(reserva);
    }

    public String Eliminarreserva(Reserva reserva) {
        return empresa.EliminarReserva(reserva);
    }

    public String Actualizarreserva(Reserva reserva, Cliente cliente, Vehiculo vehiculo, int dias) {
        return empresa.ActualizarReserva(reserva, cliente, vehiculo, dias);
    }
}
