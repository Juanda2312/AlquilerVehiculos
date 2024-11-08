package co.edu.uniquindio.poo.model;

public abstract class Vehiculo {// Clase abstracta vehiculo
    private String matricula;
    private String marca;
    private String modelo;
    private String añofabricacion;

    public Vehiculo(String matricula, String marca, String modelo, String añofabricacion) {
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

    /**
     * Calcula el costo dependiendo del tipo de vehiculo
     * 
     * @param dias
     * @return un float con el costo
     */
    public abstract float CalcularCosto(int dias);

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        return result;
    }

    /**
     * Verifica si un vehiculo es igual a otro a partir de su matricula
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vehiculo other = (Vehiculo) obj;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }

    /**
     * convierte el vehiculo a string indicando solamente la matricula
     */
    @Override
    public String toString() {
        return "Vehiculo [matricula=" + matricula + "]";
    }

}
