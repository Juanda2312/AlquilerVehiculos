package co.edu.uniquindio.poo.model;

public abstract class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private String añofabricacion;

    public Vehiculo(String matricula, String marca, String modelo, String añofabricacion){
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.añofabricacion = añofabricacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAñofabricacion() {
        return añofabricacion;
    }

    public void setAñofabricacion(String añofabricacion) {
        this.añofabricacion = añofabricacion;
    }
    
    public abstract float CalcularCosto(int dias);
}
