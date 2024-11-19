package clases.Alimentacion;

public abstract class Combustion implements IAlimentacion {
    String descripcion;
    int galonesMaximos;

    public Combustion(int galonesMaximos, String descripcion) {
        this.galonesMaximos = galonesMaximos;
        this.descripcion = descripcion;
    }

    public int getGalonesMaximos() {
        return galonesMaximos;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
