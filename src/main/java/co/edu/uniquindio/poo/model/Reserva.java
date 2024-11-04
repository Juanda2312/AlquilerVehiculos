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
        this.total = CalcularTotal();
    }
    
    public float getTotal() {
        return total;
    }
    
    public float CalcularTotal(){
        float totalaux = vehiculo.CalcularCosto(dias);
        return totalaux;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + dias;
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((vehiculo == null) ? 0 : vehiculo.hashCode());
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
        Reserva other = (Reserva) obj;
        if (dias != other.dias)
            return false;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        if (vehiculo == null) {
            if (other.vehiculo != null)
                return false;
        } else if (!vehiculo.equals(other.vehiculo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Reserva [dias=" + dias + ", total=" + total + "]";
    }
    

}
