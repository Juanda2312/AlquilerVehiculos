package co.edu.uniquindio.poo.model;

public class Reserva {
    private int dias;
    private float total;
    private Cliente cliente;
    private Vehiculo vehiculo;

    public Reserva(Cliente cliente, Vehiculo vehiculo, int dias){
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.dias = dias;
        this.total = CalcularTotal();
        cliente.AgregarReserva(this);
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
        this.total = CalcularTotal();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public float getTotal() {
        return total;
    }
    
    public float CalcularTotal(){
        float totalaux = vehiculo.CalcularCosto(dias);
        return totalaux;
    }
    

}
