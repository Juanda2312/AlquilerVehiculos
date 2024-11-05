package co.edu.uniquindio.poo.model;

public class Moto extends Vehiculo {

    private Caja caja;

    public Moto(String matricula, String marca, String modelo, String añofabricacion, Caja caja) {
        super(matricula, marca, modelo, añofabricacion);
        this.caja = caja;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    /**
     * Calcula el costo con una tarifa base de 10000 multiplicado por los dias
     * ademas de una tarifa adicional de 5000 si es automatica
     */
    public float CalcularCosto(int dias) {
        float costo = 0;
        costo += 10000 * dias;// tarifa base
        if (caja == Caja.AUTOMATICO) {
            costo += 5000;// Tarifa extra si es automatica
        }
        return costo;
    }
}
