package co.edu.uniquindio.poo.model;

public class Camioneta extends Vehiculo {

    private float carga;

    public Camioneta(String matricula, String marca, String modelo, String añofabricacion, float carga) {
        super(matricula, marca, modelo, añofabricacion);
        this.carga = carga;
    }

    public float getCarga() {
        return carga;
    }

    public void setCarga(float carga) {
        this.carga = carga;
    }

    /**
     * El costo se calcula con una tarifa base multiplicado por los dias y una
     * tarifa extra por cada tonelada de capacidad
     */
    public float CalcularCosto(int dias) {
        float costo = 0;
        costo += 10000 * dias;// tarifa base
        costo += (costo * (0.05 * carga));// tarifa extra por cada tonelada
        return costo;
    }
}
