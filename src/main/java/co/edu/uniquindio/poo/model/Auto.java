package co.edu.uniquindio.poo.model;

public class Auto extends Vehiculo{
    
    private byte numeropuertas;

    public Auto(String matricula, String marca, String modelo, String añofabricacion, byte numeropuertas){
        super(matricula, marca, modelo, añofabricacion);
        this.numeropuertas = numeropuertas;
    }

    public byte getNumeropuertas() {
        return numeropuertas;
    }

    public void setNumeropuertas(byte numeropuertas) {
        this.numeropuertas = numeropuertas;
    }
    
    public float CalcularCosto(int dias){
        float costo = 0;
        costo += 10000 * dias;
        return costo;
    }
}
