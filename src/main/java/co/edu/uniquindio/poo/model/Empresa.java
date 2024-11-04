package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class Empresa {
    
    private String nombre;
    private LinkedList<Cliente> listaclientes;
    private LinkedList<Reserva> listareservas;
    private LinkedList<Vehiculo> listavehiculos;

    public Empresa(String nombre){
        this.nombre = nombre;
        listaclientes = new LinkedList<>();
        listareservas = new LinkedList<>();
        listavehiculos = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Cliente> getListaclientes() {
        return listaclientes;
    }

    public LinkedList<Reserva> getListareservas() {
        return listareservas;
    }

    public LinkedList<Vehiculo> getListavehiculos() {
        return listavehiculos;
    }
    
    public String Agregarcliente(Cliente cliente){
        String respuesta = "No se pudo agregar";
        if (cliente != null){
            Cliente clienteaux = BuscarCliente(cliente);
            if (clienteaux == null){
                listaclientes.add(cliente);
                respuesta = "El cliente ha sido agregado";
            }
        }
        return respuesta;
    }

    public Cliente BuscarCliente(Cliente cliente){
        Cliente clienteaux = null;
        if (cliente != null && listaclientes.contains(cliente)){
            clienteaux = cliente;
        }
        return clienteaux;
    }

    public String EliminaCliente(Cliente cliente){
        String respuesta = "No se pudo eliminar";
        if (cliente != null) {
            Cliente clienteaux = BuscarCliente(cliente);
            if (clienteaux != null){
                listaclientes.remove(cliente);
                respuesta = "El cliente ha sido eliminado";
            }
        }
        return respuesta;
    }

    public String ActualizarCliente(Cliente cliente, String nombre,String cedula, String telefono, String correo){
        String respuesta = "No se pudo actualizar";
        if (cliente != null){
            Cliente clienteaux = BuscarCliente(cliente);
            if (clienteaux != null){
                int index = listaclientes.indexOf(cliente);
                Cliente cliente2 = listaclientes.get(index);
                cliente2.setNombre(nombre);
                cliente2.setCedula(cedula);
                cliente2.setTelefono(telefono);
                cliente2.setCorreo(correo);
                respuesta = "El cliente ha sido actualizado";
            }
        }
        return respuesta;
    }
    
    public String Agregarvehiculo(Vehiculo vehiculo){
        String respuesta = "No se pudo agregar";
        if (vehiculo != null){
            Vehiculo vehiculoaux = BuscarVehiculo(vehiculo);
            if (vehiculoaux == null){
                listavehiculos.add(vehiculo);
                respuesta = "El vehiculo ha sido agregado";
            }
        }
        return respuesta;
    }


    public Vehiculo BuscarVehiculo(Vehiculo vehiculo){
        Vehiculo vehiculoaux = null;
        if (vehiculo != null && listavehiculos.contains(vehiculo)) {
            vehiculoaux = vehiculo;
        }
        return vehiculoaux;
    }

    public String EliminarVehiculo(Vehiculo vehiculo){
        String respuesta = "No se pudo eliminar";
        if (vehiculo != null){
            Vehiculo vehiculoaux = BuscarVehiculo(vehiculo);
            if (vehiculoaux != null) {
                listavehiculos.remove(vehiculo);
                respuesta = "El vehiculo ha sido eliminado";
            }
        }
        return respuesta;
    }


    public String AgregarReserva(Reserva reserva){
        String respuesta = "No se ha podido agregar";
        if (reserva!=null) {
            Reserva reservaaux = BuscarReserva(reserva);
            if (reservaaux==null){
                listareservas.add(reserva);
                respuesta = "La reserva ha sido agregada";
            }
        }
        return respuesta;
    }

    public Reserva BuscarReserva(Reserva reserva){
        Reserva reservaaux = null;
        if (reserva != null && listareservas.contains(reserva)) {
            reservaaux = reserva;
        }
        return reservaaux;
    }

    public String EliminarReserva(Reserva reserva){
        String respuesta = "No se pudo eliminar";
        if (reserva != null) {
            Reserva reservaaux = BuscarReserva(reserva);
            if (reservaaux != null) {
                listareservas.remove(reserva);
                respuesta = "La reserva ha sido eliminada";
            }
        }
        return respuesta;
    }

    public String ActualizarReserva(Reserva reserva, Cliente cliente, Vehiculo vehiculo, int dias){
        String respuesta = "No se ha podido actualizar";
        if (reserva != null) {
            Reserva reservaaux = BuscarReserva(reserva);
            if (reservaaux != null) {
                int index = listareservas.indexOf(reserva);
                reservaaux = listareservas.get(index);
                reservaaux.setCliente(cliente);
                reservaaux.setDias(dias);
                reservaaux.setVehiculo(vehiculo);
                respuesta = "La reserva ha sido actualizado";
            }
        }
        return respuesta;
    }
}
