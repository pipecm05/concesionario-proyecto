package clases.Vehiculos.abstractas;

public enum TipoCaja {
    Mecanica("Mecánica"),
    Automatica("Automática");

    private String descripcion;

    TipoCaja(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
