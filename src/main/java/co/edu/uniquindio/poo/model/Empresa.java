package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class Empresa {

    private String nombre;
    private LinkedList<Cliente> listaclientes;
    private LinkedList<Reserva> listareservas;
    private LinkedList<Vehiculo> listavehiculos;

    public Empresa(String nombre) {
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

    /**
     * Agrega un cliente a la lista de clientes si este no existe
     * 
     * @param cliente
     * @return un mensaje indicando si se agregó o no
     */
    public String Agregarcliente(Cliente cliente) {
        String respuesta = "No se pudo agregar";
        if (cliente != null) {
            Cliente clienteaux = BuscarCliente(cliente);
            if (clienteaux == null) {
                listaclientes.add(cliente);
                respuesta = "El cliente ha sido agregado";
            }
        }
        return respuesta;
    }

    /**
     * Busca un cliente en la lista de clientes siempre y cuando exista
     * 
     * @param cliente
     * @return el cliente si existe o null si no existe
     */
    public Cliente BuscarCliente(Cliente cliente) {
        Cliente clienteaux = null;
        if (cliente != null && listaclientes.contains(cliente)) {
            clienteaux = cliente;
        }
        return clienteaux;
    }

    /**
     * Elimina un cliente de la lista de clientes si este existe
     * 
     * @param cliente
     * @return un mensaje indicando si se pudo eliminar o no
     */
    public String EliminaCliente(Cliente cliente) {
        String respuesta = "No se pudo eliminar";
        if (cliente != null) {
            Cliente clienteaux = BuscarCliente(cliente);
            if (clienteaux != null) {
                listaclientes.remove(cliente);
                respuesta = "El cliente ha sido eliminado";
            }
        }
        return respuesta;
    }

    /**
     * Actualiza un cliente siempre y cuando esta exista
     * 
     * @param cliente
     * @param nombre
     * @param cedula
     * @param telefono
     * @param correo
     * @return un mensaje indicando si se pudo actualizar o no
     */
    public String ActualizarCliente(Cliente cliente, String nombre, String cedula, String telefono, String correo) {
        String respuesta = "No se pudo actualizar";
        if (cliente != null) {
            Cliente clienteaux = BuscarCliente(cliente);
            if (clienteaux != null) {
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

    /**
     * Agrega un vehiculo a la lista de vehiculos siempre y cuando este exista
     * 
     * @param vehiculo
     * @return un mensaje indicando si se pudo agregar o no
     */
    public String Agregarvehiculo(Vehiculo vehiculo) {
        String respuesta = "No se pudo agregar";
        if (vehiculo != null) {
            Vehiculo vehiculoaux = BuscarVehiculo(vehiculo);
            if (vehiculoaux == null) {
                listavehiculos.add(vehiculo);
                respuesta = "El vehiculo ha sido agregado";
            }
        }
        return respuesta;
    }

    /**
     * Busca un vehiculo en la lista de vehiculos
     * 
     * @param vehiculo
     * @return el vehiculo si existe o null si no existe
     */
    public Vehiculo BuscarVehiculo(Vehiculo vehiculo) {
        Vehiculo vehiculoaux = null;
        if (listavehiculos.contains(vehiculo)) {
            vehiculoaux = vehiculo;
        }
        return vehiculoaux;
    }

    /**
     * Elimina un vehiculo de la lista de vehiculos siempre y cuando este exista
     * 
     * @param vehiculo
     * @return un mensaje indicando si se pudo eliminar o no
     */
    public String EliminarVehiculo(Vehiculo vehiculo) {
        String respuesta = "No se pudo eliminar";
        if (vehiculo != null) {
            Vehiculo vehiculoaux = BuscarVehiculo(vehiculo);
            if (vehiculoaux != null) {
                listavehiculos.remove(vehiculo);
                respuesta = "El vehiculo ha sido eliminado";
            }
        }
        return respuesta;
    }

    /**
     * Actualiza un vehiculo siempre y cuando este exista
     * 
     * @param vehiculo
     * @param matricula
     * @param marca
     * @param modelo
     * @param año
     * @param puerta
     * @param caja
     * @param carga
     * @return un mensaje indicando si se pudo actualizar o no
     */
    public String ActualizarVehiculo(Vehiculo vehiculo, String matricula, String marca, String modelo, String año,
            Integer puerta, Caja caja, Float carga) {
        String respuesta = "No se ha podido actualizar";
        if (vehiculo != null) {
            Vehiculo vehiculoaux = BuscarVehiculo(vehiculo);
            if (vehiculoaux != null) {
                int index = listavehiculos.indexOf(vehiculo);
                vehiculoaux = listavehiculos.get(index);
                vehiculoaux.setMatricula(matricula);
                vehiculoaux.setMarca(marca);
                vehiculoaux.setModelo(modelo);
                vehiculoaux.setAñofabricacion(año);
                // Verifica la instancia del vehiculo para agregar atributos propios de la clase
                // hija e ignorar el resto
                if (vehiculoaux instanceof Auto) {
                    ((Auto) vehiculoaux).setNumeropuertas(puerta);
                }
                if (vehiculoaux instanceof Moto) {
                    ((Moto) vehiculoaux).setCaja(caja);
                }
                if (vehiculoaux instanceof Camioneta) {
                    ((Camioneta) vehiculoaux).setCarga(carga);
                }
                respuesta = "El vehiculo ha sido actualizado";
            }
        }
        return respuesta;
    }

    /**
     * Agrega una reserva a la lista de reservas siempre y cuando esta no exista
     * 
     * @param reserva
     * @return un mensaje indicando si se agregó o no se pudo agregar
     */
    public String AgregarReserva(Reserva reserva) {
        String respuesta = "No se ha podido agregar";
        if (reserva != null) {
            Reserva reservaaux = BuscarReserva(reserva);
            if (reservaaux == null) {
                listareservas.add(reserva);
                respuesta = "La reserva ha sido agregada";
            }
        }
        return respuesta;
    }

    /**
     * Busca una reserva en la lista de reservas
     * 
     * @param reserva
     * @return la reserva si es encontrada o null si no se encuentra
     */
    public Reserva BuscarReserva(Reserva reserva) {
        Reserva reservaaux = null;
        if (reserva != null && listareservas.contains(reserva)) {
            reservaaux = reserva;
        }
        return reservaaux;
    }

    /**
     * Se elimina una reserva de la lista siempre y cuando esta exista
     * 
     * @param reserva
     * @return un mensaje indicando si se eliminó o no se pudo eliminar
     */
    public String EliminarReserva(Reserva reserva) {
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

    /**
     * Actualiza una reserva siempre y cuando esta exista
     * 
     * @param reserva
     * @param cliente
     * @param vehiculo
     * @param dias
     * @return un mensaje indicando si se pudo actualizar o no
     */
    public String ActualizarReserva(Reserva reserva, Cliente cliente, Vehiculo vehiculo, int dias) {
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
