package co.edu.uniquindio.poo.model;

public class Camioneta extends Vehiculo{

    private float carga;

    public Camioneta(String matricula, String marca, String modelo, String añofabricacion, float carga){
        super(matricula, marca, modelo, añofabricacion);
        this.carga = carga;
    }

    public float getCarga() {
        return carga;
    }

    public void setCarga(float carga) {
        this.carga = carga;
    }
    
    public float CalcularCosto(int dias){
        float costo = 0;
        costo += 10000 * dias;
        costo += (costo * (0.05*carga));
        return costo;
    }
}
