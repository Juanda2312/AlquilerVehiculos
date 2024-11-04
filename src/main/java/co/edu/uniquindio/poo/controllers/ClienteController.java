package co.edu.uniquindio.poo.controllers;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;

public class ClienteController {
    Empresa empresa;

    public ClienteController(Empresa empresa){
        this.empresa = empresa;
    }
    public String AgregarCliente(Cliente cliente){
        return empresa.Agregarcliente(cliente);
    }
    public Collection<Cliente> obtenerlistaClientes(){
        return empresa.getListaclientes();
    }
    public String EliminarCliente(Cliente cliente){
        return empresa.EliminaCliente(cliente);
    }
    public String ActualizarCliente(Cliente cliente,String nombre, String cedula, String telefono, String correo){
        return empresa.ActualizarCliente(cliente, nombre, cedula, telefono, correo);
    }
}
