package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;

public class Cliente {
    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;
    private LinkedList<Reserva> listareservas;

    public Cliente(String nombre,String cedula, String telefono, String correo){
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        listareservas = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Collection<Reserva> getListareservas() {
        return listareservas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (cedula == null) {
            if (other.cedula != null)
                return false;
        } else if (!cedula.equals(other.cedula))
            return false;
        return true;
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

    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", cedula=" + cedula + "]";
    }


}

    

