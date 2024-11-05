package co.edu.uniquindio.poo.model;

public class Auto extends Vehiculo {

    private Integer numeropuertas;

    public Auto(String matricula, String marca, String modelo, String añofabricacion, Integer puerta) {
        super(matricula, marca, modelo, añofabricacion);
        this.numeropuertas = puerta;
    }

    public Integer getNumeropuertas() {
        return numeropuertas;
    }

    public void setNumeropuertas(Integer numeropuertas) {
        this.numeropuertas = numeropuertas;
    }

    /**
     * El costo es una tarifa fija de 10000 multiplicado con por días
     */
    public float CalcularCosto(int dias) {
        float costo = 0;
        costo += 10000 * dias;// costo
        return costo;
    }
}
